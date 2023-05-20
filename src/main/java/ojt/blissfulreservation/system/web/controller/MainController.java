package ojt.blissfulreservation.system.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ojt.blissfulreservation.system.bl.service.HotelService;
import ojt.blissfulreservation.system.bl.service.UserService;
import ojt.blissfulreservation.system.web.form.HotelForm;
import ojt.blissfulreservation.system.web.form.UserForm;

/**
 * <h2>MainController Class</h2>
 * <p>
 * Process for Displaying MainController
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
@Controller
public class MainController {
    /**
     * <h2>userService</h2>
     * <p>
     * userService
     * </p>
     */
    @Autowired
    private UserService userService;

    /**
     * <h2>hotelService</h2>
     * <p>
     * hotelService
     * </p>
     */
    @Autowired
    private HotelService hotelService;

    /**
     * <h2>homePage</h2>
     * <p>
     * Method For Home Page
     * </p>
     *
     * @return String
     */
    @RequestMapping(value = "/Home")
    public String homePage(Model model) {
        List<HotelForm> hotelList = hotelService.doGetUpdatedHotels();
        model.addAttribute("hotelList", hotelList);
        return "homeforall";
    }

    /**
     * <h2>dashboard</h2>
     * <p>
     * method for showing dashboard after Login
     * </p>
     *
     * @param authentication
     * @return
     * @return String
     */
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

    /**
     * <h2>homePageforuser</h2>
     * <p>
     * method to show user home page
     * </p>
     *
     * @return
     * @return String
     */
    @RequestMapping(value = "/userdashboard")
    public String homePageforuser(Authentication authentication, Model model) {
        List<HotelForm> hotelList = hotelService.doGetUpdatedHotels();
        model.addAttribute("hotelList", hotelList);
        return "homeforuser";
    }

    /**
     * <h2>homePageforadmin</h2>
     * <p>
     * method to show admin home page
     * </p>
     *
     * @return
     * @return String
     */
    @RequestMapping(value = "/admindashboard")
    public String homePageforadmin(Model model) {
        List<HotelForm> hotelList = hotelService.doGetUpdatedHotels();
        model.addAttribute("hotelList", hotelList);
        return "homeforadmin";
    }

    /**
     * <h2>Login</h2>
     * <p>
     * method for login page
     * </p>
     *
     * @return
     * @return String
     */
    @RequestMapping(value = "/Login")
    public String Login() {
        return "userLogin";
    }

    /**
     * <h2>register</h2>
     * <p>
     * method for user-register
     * </p>
     *
     * @param model
     * @param user
     * @return
     * @return String
     */
    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String register(Model model, UserForm user) {
        model.addAttribute("user", user);
        return "userRegister";
    }

    /**
     * <h2>createUser</h2>
     * <p>
     * method for user creating
     * </p>
     *
     * @param user
     * @param model
     * @return
     * @return String
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user") UserForm user, Model model) {
        UserForm userForm = userService.doFindByEmail(user.getEmail());
        UserForm userForm2 = userService.doFindUserByPhoneNo(user.getPhoneNo());
        if (userForm != null) {
            model.addAttribute("errormsg", "Email address is already registered.");
            return "userRegister";
        } else if (userForm2 != null) {
            model.addAttribute("errormsg", "Phone Number is already registered.");
            return "userRegister";
        } else {
            userService.doSave(user);
            model.addAttribute("successMessage", "Registration successful.");
            return "userLogin";
        }
    }

    @RequestMapping(value = "/AboutUsPage")
    public String aboutUs(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "aboutUsUser";
        } else {
            return "aboutUs";
        }
    }

    @RequestMapping(value = "/ContactUsPage")
    public String contactUs(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "contactUsUser";
        } else {
            return "contactUs";
        }
    }
}
