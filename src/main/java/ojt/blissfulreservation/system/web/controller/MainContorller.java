package ojt.blissfulreservation.system.web.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ojt.blissfulreservation.system.bl.service.UserService;
import ojt.blissfulreservation.system.persistence.entity.User;

@Controller
public class MainContorller {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/Home")
    public String homePage() {
        return "homeforall";
    }
    
    @RequestMapping(value = "/HomeUser")
    public String homePageforuser() {
        return "homeforuser";
    }
    
    @RequestMapping(value = "/HomeAdmin")
    public String homePageforadmin() {
        return "homeforadmin";
    }

    @RequestMapping(value = "/Login")
    public String Login() {
        return "userLogin";
    }

    @RequestMapping(value = "/Register",method = RequestMethod.GET)
    public ModelAndView register(ModelAndView model) {
        User user = new User();
        model.addObject("user",user);
        model.setViewName("userRegister");
        return model;
    }
    
    @RequestMapping(value = "/save",method= RequestMethod.POST)
    public String createUser(@ModelAttribute User user,ModelAndView model) {
        userService.doSave(user);
        return "redirect:/HomeUser";
    }
    
    @RequestMapping(value = "/UserList")
    public String viewUserList(Model model){
        List<User> userList = userService.doGetList();
        model.addAttribute("userList", userList);
        return "viewUserList";
    }
    
    @RequestMapping(value = "/delete")
    public String deleteUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.doGetById(userId);
        userService.doDelete(user);
        return "redirect:/UserList";
    }
}
