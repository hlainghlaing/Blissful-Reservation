package ojt.blissfulreservation.system.web.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ojt.blissfulreservation.system.bl.service.BookingService;
import ojt.blissfulreservation.system.bl.service.HotelService;
import ojt.blissfulreservation.system.bl.service.RoomService;
import ojt.blissfulreservation.system.bl.service.UserService;
import ojt.blissfulreservation.system.persistence.entity.Room;
import ojt.blissfulreservation.system.persistence.entity.User;
import ojt.blissfulreservation.system.web.form.BookingForm;
import ojt.blissfulreservation.system.web.form.HotelForm;
import ojt.blissfulreservation.system.web.form.RoomForm;
import ojt.blissfulreservation.system.web.form.UserForm;

/**
 * <h2>BookingController Class</h2>
 * <p>
 * Process for Displaying BookingController
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
@Controller
public class BookingController {
    /**
     * <h2>bService</h2>
     * <p>
     * bService
     * </p>
     */
    @Autowired
    BookingService bService;

    /**
     * <h2>hotelService</h2>
     * <p>
     * hotelService
     * </p>
     */
    @Autowired
    private HotelService hotelService;

    /**
     * <h2>roomService</h2>
     * <p>
     * roomService
     * </p>
     */
    @Autowired
    private RoomService roomService;

    /**
     * <h2>userService</h2>
     * <p>
     * userService
     * </p>
     */
    @Autowired
    private UserService userService;

    /**
     * <h2>bookingRegister</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @param booking
     * @param roomId
     * @param hotelId
     * @param authentication
     * @return
     * @return String
     */
    @RequestMapping(value = "booking-register")
    public String bookingRegister(Model model, BookingForm booking, @RequestParam("id") int roomId,
            @RequestParam("hotelid") int hotelId, Authentication authentication) {
        booking.setRoomId(roomId);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        UserForm user = userService.doFindByEmail(email);
        booking.setUserId(user.getUserId());
        RoomForm room = roomService.doGetById(roomId);
        HotelForm hotel = hotelService.doGetHotelById(hotelId);
        model.addAttribute("room", room);
        model.addAttribute("hotel", hotel);
        model.addAttribute("booking", booking);
        return "bookingRegister";
    }

    /**
     * <h2>successBooking</h2>
     * <p>
     * 
     * </p>
     *
     * @param booking
     * @param model
     * @param authentication
     * @param request
     * @return
     * @return String
     */
    @RequestMapping(value = "booking-success", method = RequestMethod.POST)
    public String successBooking(@ModelAttribute("booking") @Validated BookingForm booking, BindingResult bindingResult,
            Model model, Authentication authentication, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            RoomForm room = roomService.doGetById(booking.getRoomId());
            model.addAttribute("room", room);
            HotelForm hotel = hotelService.doGetHotelById(room.getHotelId());
            model.addAttribute("hotel", hotel);
            return "bookingRegister";
        }
        RoomForm roomForm = roomService.doGetById(booking.getRoomId());
        booking.setRoom(new Room(roomForm));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        UserForm userForm = userService.doFindByEmail(email);
        booking.setUser(new User(userForm));
        double eachroomPrice = roomForm.getPrice();
        int diff = booking.dateDiff(LocalDate.parse(booking.getCheckIn()), LocalDate.parse(booking.getCheckOut()));
        int result = diff * booking.getRoomNum();
        double totalPrice = result * eachroomPrice;
        booking.setTotalPrice(totalPrice);
        bService.doCreateBooking(booking);
        HttpSession session = request.getSession();
        session.setAttribute("successMessage",
                "Thank you for booking with us! Your hotel reservation has been confirmed.");
        return "redirect:/booking-list";
    }

    /**
     * <h2>bookingListAdminView</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @return
     * @return String
     */
    @RequestMapping(value = "booking-lists")
    public String bookingListAdminView(Model model) {
        List<BookingForm> bookingList = bService.doGetBookingList();
        model.addAttribute("bookingList", bookingList);
        return "bookingAdminView";
    }

    /**
     * <h2>bookingListUserView</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @param authentication
     * @return
     * @return String
     */
    @RequestMapping(value = "booking-list")
    public String bookingListUserView(Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        UserForm user = userService.doFindByEmail(email);
        List<BookingForm> bookingList = bService.doGetBookingByuser(user.getUserId());
        model.addAttribute("bookingList", bookingList);
        return "bookingUserView";
    }

    /**
     * <h2>acceptBooking</h2>
     * <p>
     * 
     * </p>
     *
     * @param id
     * @param email
     * @return
     * @return String
     */
    @RequestMapping(value = "/accept")
    public String acceptBooking(@RequestParam("id") int id, @RequestParam("email") String email, Model model) {
        BookingForm bookingForm = bService.doGetBookingById(id);
        bookingForm.setStatus(2);
        model.addAttribute("email", email);
        bService.doUpdateBooking(bookingForm);
        return "emailForm";
    }

    /**
     * <h2>rejectBooking</h2>
     * <p>
     * 
     * </p>
     *
     * @param id
     * @param request
     * @return
     * @return String
     */
    @RequestMapping(value = "/reject")
    public String rejectBooking(@RequestParam("id") int id, HttpServletRequest request) {
        BookingForm bookingForm = bService.doGetBookingById(id);
        bookingForm.setStatus(3);
//        int option = JOptionPane.showConfirmDialog(null, "Are you sure to Reject?");
//        if (option == JOptionPane.YES_OPTION) {
            bService.doUpdateBooking(bookingForm);
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Booking Rejected!");
//            }
        return "redirect:/booking-lists";
    }

    /**
     * 
     * <h2>Send Email</h2>
     * 
     * 
     * @param email
     * @param request
     * @return String
     */
    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    public String sendEmail(@RequestParam("email") String email, HttpServletRequest request) {
        final String senderEmail = "mimisoe968@gmail.com";
        final String senderPassword = "fsfdnjwmcljwuvoy";
        // Set up SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Replace with your email provider's SMTP server
        properties.put("mail.smtp.port", "587"); // Replace with the appropriate port number

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Blissful Reservation");
            message.setText("Your booking is successfully registered. Thanks for joining Blissful Reservation");

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully!");
            HttpSession ses = request.getSession();
            ses.setAttribute("successMessage", "Email Successfully Sent");
            return "redirect:/booking-lists";

        } catch (MessagingException e) {
            e.printStackTrace();
            HttpSession ses = request.getSession();
            ses.setAttribute("errormsg", "Message can not be sent");
            return "redirect:/booking-lists";
        }
    }
}
