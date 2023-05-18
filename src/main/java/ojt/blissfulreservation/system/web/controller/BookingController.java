package ojt.blissfulreservation.system.web.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * @author Dell
 *
 */
@Controller
public class BookingController {
    @Autowired
    BookingService bService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

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

    @RequestMapping(value = "booking-success", method = RequestMethod.POST)
    public String successBooking(@ModelAttribute("booking") BookingForm booking, Model model,
            Authentication authentication) {
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
        return "redirect:/booking-list";
    }

    @RequestMapping(value = "booking-lists")
    public String bookingListAdminView(Model model) {
        List<BookingForm> bookingList = bService.doGetBookingList();
        model.addAttribute("bookingList", bookingList);
        return "bookingAdminView";
    }

    @RequestMapping(value = "booking-list")
    public String bookingListUserView(Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        UserForm user = userService.doFindByEmail(email);
        List<BookingForm> bookingList = bService.doGetBookingByuser(user.getUserId());
        model.addAttribute("bookingList", bookingList);
        return "bookingUserView";
    }

    @RequestMapping(value = "/accept")
    public String acceptBooking(@RequestParam("id") int id) {
        BookingForm bookingForm = bService.doGetBookingById(id);
        bookingForm.setStatus(2);
        bService.doUpdateBooking(bookingForm);
        return "redirect:/booking-lists";
    }

    @RequestMapping(value = "/reject")
    public String rejectBooking(@RequestParam("id") int id) {
        BookingForm bookingForm = bService.doGetBookingById(id);
        bookingForm.setStatus(3);
        bService.doUpdateBooking(bookingForm);
        return "redirect:/booking-lists";
    }
}
