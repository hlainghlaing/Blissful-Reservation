package ojt.blissfulreservation.system.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ojt.blissfulreservation.system.bl.service.UserService;
import ojt.blissfulreservation.system.persistence.entity.User;
import ojt.blissfulreservation.system.web.form.UserForm;

/**
 * <h2>UserContorller Class</h2>
 * <p>
 * Process for Displaying UserContorller
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
@Controller
public class UserContorller {
    /**
     * <h2>userService</h2>
     * <p>
     * userService
     * </p>
     */
    @Autowired
    private UserService userService;

    /**
     * <h2>viewUserList</h2>
     * <p>
     * method to show userList
     * </p>
     *
     * @param model
     * @return
     * @return String
     */
    @RequestMapping(value = "/UserList")
    public String viewUserList(Model model) {
        List<UserForm> userList = userService.doGetList();
        model.addAttribute("userList", userList);
        return "viewUserList";
    }

    /**
     * <h2>deleteUser</h2>
     * <p>
     * method to delete user
     * </p>
     *
     * @param request
     * @param userId
     * @return
     * @return String
     */
    @RequestMapping(value = "/delete-user", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request, @RequestParam("id") int userId) {
        UserForm user = userService.doGetById(userId);
        userService.doDelete(user);
        HttpSession session = request.getSession();
        session.setAttribute("successMessage", "User Deleted Successfully!");
        return "redirect:/UserList";
    }

    /**
     * <h2>getUserEmail</h2>
     * <p>
     * method to get user email
     * </p>
     *
     * @param model
     * @param email
     * @return
     * @return String
     */
    @RequestMapping(value = "/forgot-password")
    public String getUserEmail(Model model, @ModelAttribute("email") String email) {
        model.addAttribute("email", email);
        return "userProfile";
    }

    /**
     * <h2>handleInvalidEmailException</h2>
     * <p>
     * exception handling method
     * </p>
     *
     * @param ex
     * @return
     * @return ModelAndView
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleInvalidEmailException(Exception ex) {
        ModelAndView mav = new ModelAndView("userProfile");
        mav.addObject("errormsg", "Invalid Email!");
        return mav;
    }

    /**
     * <h2>updateUserPassword</h2>
     * <p>
     * method to get email
     * </p>
     *
     * @param email
     * @param model
     * @return
     * @throws Exception
     * @return String
     */
    @RequestMapping(value = "/editpassword")
    public String updateUserPassword(@ModelAttribute("email") String email, Model model) throws Exception {
        UserForm user = userService.doFindByEmail(email);
        if (user == null) {
            throw new Exception("Invalid Email");
        }
        user.setPassword(null);
        model.addAttribute("user", user);
        return "changePassword";
    }

    /**
     * <h2>updatePassword</h2>
     * <p>
     * method for updating password
     * </p>
     *
     * @param user
     * @return
     * @return String
     */
    @RequestMapping(value = "/updateUserPassword")
    public String updatePassword(@ModelAttribute("user") UserForm user, HttpServletRequest request) {
        userService.doUpdate(user);
        HttpSession session = request.getSession();
        session.setAttribute("successMessage", "Your password is Updated!");
        return "redirect:/Login";
    }

    /**
     * <h2>editUser</h2>
     * <p>
     * method for editing user info
     * </p>
     *
     * @param request
     * @param model
     * @param id
     * @return
     * @return String
     */
    @RequestMapping(value = "/edit-user", method = RequestMethod.GET)
    public String editUser(HttpServletRequest request, Model model, @RequestParam("id") int id) {
        UserForm user = userService.doGetById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    /**
     * <h2>updateUser</h2>
     * <p>
     * method for update user
     * </p>
     *
     * @param user
     * @return
     * @return String
     */
    @RequestMapping(value = "/update-user", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") UserForm user, HttpServletRequest request) {
        userService.doUpdate(user);
        HttpSession session = request.getSession();
        session.setAttribute("successMessage", "User details updated successfully!");
        return "redirect:/UserList";
    }
    
    
    @RequestMapping(value = "/downloaduserexcel", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadUsersExcel() {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("User List");

            List<UserForm> users = userService.doGetList();

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Name");
            headerRow.createCell(1).setCellValue("Email");
            headerRow.createCell(2).setCellValue("Phone Number");
            headerRow.createCell(3).setCellValue("Created At");
            headerRow.createCell(4).setCellValue("Deleted At");

            int rowNum = 1;
            for (UserForm user : users) {
                Row userDataRow = sheet.createRow(rowNum++);
                userDataRow.createCell(0).setCellValue(user.getUserName());
                userDataRow.createCell(1).setCellValue(user.getEmail());
                userDataRow.createCell(2).setCellValue(user.getPhoneNo());
                userDataRow.createCell(3).setCellValue(user.getCreatedAt());
                userDataRow.createCell(4).setCellValue(user.getDeletedAt());
                
            }
            
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "users.xlsx");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(outputStream.toByteArray());
        } catch (IOException e) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }
}
