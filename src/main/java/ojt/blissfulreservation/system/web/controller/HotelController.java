package ojt.blissfulreservation.system.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelController {
    @RequestMapping(value = "/Hotels")
    public String cusViewHotels(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "hotelsforuser";
        }
        return "hotelsforall";
    }
}
