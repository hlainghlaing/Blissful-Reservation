package ojt.blissfulreservation.system.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ojt.blissfulreservation.system.web.form.BookingForm;

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
    @RequestMapping(value = "booking-register")
    public String bookingRegister(Model model, @ModelAttribute("booking") BookingForm booking) {
        model.addAttribute("booking", booking);
        return "bookingRegister";
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
