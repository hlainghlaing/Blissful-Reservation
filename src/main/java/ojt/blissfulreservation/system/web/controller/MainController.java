package ojt.blissfulreservation.system.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ojt.blissfulreservation.system.bl.service.UserService;
import ojt.blissfulreservation.system.persistence.entity.User;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/Home")
    public String homePage() {
        return "homeforall";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        User user = userService.doFindByEmail(email);
        String role = user.getRoleType();
        if (role.equals("0")) {
            return "redirect:/admindashboard";
        } 
            return "redirect:/userdashboard";
    }

    @RequestMapping(value = "/userdashboard")
    public String homePageforuser() {
        return "homeforuser";
    }

    @RequestMapping(value = "/admindashboard")
    public String homePageforadmin() {
        return "homeforadmin";
    }

    @RequestMapping(value = "/Login")
    public String Login() {
        return "userLogin";
    }

}
