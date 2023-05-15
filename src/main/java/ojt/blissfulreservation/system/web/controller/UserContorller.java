package ojt.blissfulreservation.system.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ojt.blissfulreservation.system.bl.service.UserService;
import ojt.blissfulreservation.system.web.form.UserForm;

@Controller
public class UserContorller {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/UserList")
    public String viewUserList(Model model) {
        List<UserForm> userList = userService.doGetList();
        model.addAttribute("userList", userList);
        return "viewUserList";
    }

    @RequestMapping(value = "/delete-user", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request, @RequestParam("id") int userId) {
        UserForm user = userService.doGetById(userId);
        userService.doDelete(user);
        return "redirect:/UserList";
    }

    @RequestMapping(value = "/forgot-password")
    public String getUserEmail(Model model, @ModelAttribute("email") String email) {
        model.addAttribute("email", email);
        return "userProfile";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleInvalidEmailException(Exception ex) {
        ModelAndView mav = new ModelAndView("userProfile");
        mav.addObject("errormsg", "Invalid Email!");
        return mav;
    }

    @RequestMapping(value = "/editpassword")
    public String updateUserPassword(@ModelAttribute("email") String email, Model model) throws Exception {
        UserForm user = userService.doFindByEmail(email);
        if(user == null) {
            throw new Exception ("Invalid Email");
        }
        user.setPassword(null);
        model.addAttribute("user", user);
        return "changePassword";
    }

    @RequestMapping(value = "/updateUserPassword")
    public String updatePassword(@ModelAttribute("user") UserForm user) {
        userService.doUpdate(user);
        return "redirect:/Login";
    }

    @RequestMapping(value = "/edit-user", method = RequestMethod.GET)
    public String editUser(HttpServletRequest request, Model model, @RequestParam("id") int id) {
        UserForm user = userService.doGetById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @RequestMapping(value = "/update-user", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute UserForm user) {
        userService.doUpdate(user);
        return "redirect:/UserList";
    }
}
