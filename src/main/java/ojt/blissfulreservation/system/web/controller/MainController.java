package ojt.blissfulreservation.system.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ojt.blissfulreservation.system.bl.service.UserService;
import ojt.blissfulreservation.system.web.form.UserForm;

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
        UserForm user = userService.doFindByEmail(email);
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

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String register(Model model, @ModelAttribute("user") UserForm user) {
        model.addAttribute("user", user);
        return "userRegister";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createUser(@ModelAttribute UserForm user, Model model) {
        UserForm userForm = userService.doFindByEmail(user.getEmail());
        if (userForm != null) {
            model.addAttribute("errormsg", "Email address is already registered");
            return "redirect:/Register";
        } 
        userService.doSave(user);
        return "redirect:/Login";
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String createUser(@ModelAttribute UserForm user,Model model)  {
//        // Dao => entity => service (DTO, Form) => Controller (Form) 
//        UserForm existeduser = userService.doFindByEmail(user.getEmail());
//        if (existeduser != null) {
//            model.addAttribute("errormsg", "Email should not duplicate");
//            return "redirect:/Register";
//        }
//        userService.doSave(user); // userService.doService(userForm);
//        return "redirect:/Login";
//    }
}
