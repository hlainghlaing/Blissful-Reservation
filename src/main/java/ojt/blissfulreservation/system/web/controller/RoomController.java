package ojt.blissfulreservation.system.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomController {
    @RequestMapping(value = "/view-room")
    public String viewRoomType(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "roomsforuser";
        }
        return "roomsforall";
    }
}
