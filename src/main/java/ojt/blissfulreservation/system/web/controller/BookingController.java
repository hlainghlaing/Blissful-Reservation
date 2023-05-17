package ojt.blissfulreservation.system.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ojt.blissfulreservation.system.bl.service.BookingService;
import ojt.blissfulreservation.system.web.form.BookingForm;
import ojt.blissfulreservation.system.web.form.UserForm;

/**
 * <h2> BookingController Class</h2>
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
    
    @RequestMapping(value = "booking-register",method = RequestMethod.GET)
    public String bookingRegister(Model model, BookingForm booking) {
        model.addAttribute("booking", booking);
        return "bookingRegister";
    }
    
    @RequestMapping(value = "save-booking",method = RequestMethod.POST)
    public String successBooking(@ModelAttribute("booking") BookingForm booking ,Model model,@RequestParam("id") int roomId) {
        int userId = ((UserForm) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        booking.setUserId(userId);
        booking.setRoomId(roomId);
        bService.doCreateBooking(booking);
        return "bookingUserView";
    }
    
    @RequestMapping(value = "booking-lists")
    public String bookingListAdminView() {
        return "bookingAdminView";
    }
    
    @RequestMapping(value = "booking-list")
    public String bookingListUserView() {
        return "bookingUserView";
    }
}
