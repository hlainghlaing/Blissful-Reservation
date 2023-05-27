package ojt.blissfulreservation.system.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ojt.blissfulreservation.system.bl.service.HotelService;
import ojt.blissfulreservation.system.bl.service.RoomService;
import ojt.blissfulreservation.system.bl.service.UserService;
import ojt.blissfulreservation.system.web.form.HotelForm;
import ojt.blissfulreservation.system.web.form.RoomForm;
import ojt.blissfulreservation.system.web.form.UserForm;

/**
 * <h2>HotelController Class</h2>
 * <p>
 * Process for Displaying HotelController
 * </p>
 * 
 * @author Hnaung Thet Htar Wai
 *
 */
@Controller
public class HotelController {

    /**
     * <h2>hotelService</h2>
     * <p>
     * hotelService
     * </p>
     */
    @Autowired
    private HotelService hotelService;

    /**
     * <h2>roomService</h2>
     * <p>
     * roomService
     * </p>
     */
    @Autowired
    private RoomService roomService;

    /**
     * <h2>userService</h2>
     * <p>
     * userService
     * </p>
     */
    @Autowired
    private UserService userService;

    /**
     * <h2>hotelList</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @param authentication
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/searchform", method = RequestMethod.GET)
    public ModelAndView hotelList(ModelAndView model, Authentication authentication) {
        List<String> cityList = hotelService.getCities();
        model.addObject("cityList", cityList);
        List<HotelForm> hotelList = hotelService.doGetUpdatedHotels();
        model.addObject("hotelList", hotelList);
        if (authentication != null && authentication.isAuthenticated()) {
            model.setViewName("hotelUserView");
            return model;
        }
        model.setViewName("hotelAllView");
        return model;
    }

    /**
     * <h2>viewhotelHeader</h2>
     * <p>
     * 
     * </p>
     *
     * @param authentication
     * @return
     * @return String
     */
    @RequestMapping(value = "/hotel-view-url")
    public String viewhotelHeader(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String email = userDetails.getUsername();
            UserForm user = userService.doFindByEmail(email);
            String role = user.getRoleType();
            if (role.equals("0")) {
                return "redirect:/hotel-view";
            }else {
                return "redirect:/searchform";
            }  
        }
        return "redirect:/searchform";
    }

    /**
     * <h2>hotelByCity</h2>
     * <p>
     * 
     * </p>
     *
     * @param city
     * @param model
     * @param authentication
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/hotelByCityName", method = RequestMethod.POST)
    public ModelAndView hotelByCity(@RequestParam("selectedCity") String city, ModelAndView model,
            Authentication authentication) {
        model.addObject("c", city);
        List<String> cityList = hotelService.getCities();
        model.addObject("cityList", cityList);
        List<HotelForm> hotelList = hotelService.doGetHotels(city);
        model.addObject("hotelList", hotelList);
        if (authentication != null && authentication.isAuthenticated()) {
            model.setViewName("hotelSearchView");
            return model;
        }
        model.setViewName("hotelAllSearchView");
        return model;
    }

    /**
     * <h2>showNewHotelForm</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @return
     * @return String
     */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String showNewHotelForm(Model model) {
        model.addAttribute("hotel", new HotelForm());
        return "hotelRegister";
    }

    /**
     * <h2>registerNewHotel</h2>
     * <p>
     * 
     * </p>
     *
     * @param hotel
     * @param model
     * @return
     * @throws IOException
     * @return ModelAndView
     */
    @RequestMapping(value = "/register-hotel", method = RequestMethod.POST)
    public String registerNewHotel(@ModelAttribute("hotel") @Validated HotelForm hotel,BindingResult bindingResult, HttpServletRequest request)
            throws IOException {
        if(bindingResult.hasErrors()) {
            return "hotelRegister";
        }
        MultipartFile file = hotel.getFile();
        if (file == null || file.isEmpty()) {
            // Handle the case when the file is not selected
            bindingResult.rejectValue("file", "error.file", "Please select Image file");
            return "hotelRegister";
        }
        
        HotelForm hotelform = hotelService.doFindHotelByPhoneNo(hotel.getPhone());
        if (hotelform != null) {
            HttpSession session = request.getSession();
            session.setAttribute("errormsg", "Phone Number is already registered.");
            return "redirect:/form";
        } else {
            hotelService.doRegisterNewHotel(hotel, hotel.getFile());
            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Successfully register New Hotel!");
            return "redirect:/hotel-view";
        }
    }

    /**
     * <h2>getAllHotels</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @return
     * @return String
     */
    @GetMapping(value = "/hotel-view")
    public String getAllHotels(Model model) {
        List<HotelForm> hotelList = hotelService.doGetAllHotels();
        model.addAttribute("hotelList", hotelList);
        List<RoomForm> roomList = roomService.doGetHotelAndRoomList();
        model.addAttribute("list", roomList);
        return "hotelAdminView";
    }

    /**
     * <h2>editHotelForm</h2>
     * <p>
     * 
     * </p>
     *
     * @param hotelId
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/edit-hotel", method = RequestMethod.GET)
    public ModelAndView editHotelForm(@RequestParam("id") int hotelId) {
        HotelForm hotel = hotelService.doGetHotelById(hotelId);
        ModelAndView modelAndView = new ModelAndView("hotelUpdate");
        modelAndView.addObject("hotel", hotel);
        return modelAndView;
    }

    /**
     * <h2>updateHotel</h2>
     * <p>
     * 
     * </p>
     *
     * @param hotelForm
     * @return
     * @throws IOException
     * @return String
     */
    @RequestMapping(value = "/update-hotel", method = RequestMethod.POST)
    public String updateHotel(@ModelAttribute("hotel") HotelForm hotelForm, HttpServletRequest request)
            throws IOException {
        hotelService.doUpdateHotel(hotelForm, hotelForm.getFile());
        HttpSession session = request.getSession();
        session.setAttribute("successMessage", "Hotel Updated Successfully!");
        return "redirect:/hotel-view";
    }

    /**
     * <h2>deleteUser</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @param hotelId
     * @return
     * @return String
     */
    @RequestMapping(value = "/delete-hotel", method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request, @RequestParam("id") int hotelId) {
        HotelForm hotelform = hotelService.doGetHotelById(hotelId);
        hotelService.doDeleteHotel(hotelform);
        HttpSession session = request.getSession();
        session.setAttribute("successMessage", "Hotel Deleted Successfully!");
        return "redirect:/hotel-view";
    }

    /**
     * <h2>downloadExcel</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return ResponseEntity<byte[]>
     */
    @GetMapping(value = "/downloadexcel")
    public ResponseEntity<byte[]> downloadExcel() {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Hotels Data");

            List<HotelForm> hotels = hotelService.doGetAllHotels();

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Hotel Name");
            headerRow.createCell(1).setCellValue("Phone");
            headerRow.createCell(2).setCellValue("Rating");
            headerRow.createCell(3).setCellValue("Address");

            headerRow.createCell(4).setCellValue("Room Type");
            headerRow.createCell(5).setCellValue("Price");
            headerRow.createCell(6).setCellValue("Available Room");

            int rowNum = 1;
            for (HotelForm hotel : hotels) {
                Row hotelDataRow = sheet.createRow(rowNum++);
                hotelDataRow.createCell(0).setCellValue(hotel.getHotelName());
                hotelDataRow.createCell(1).setCellValue(hotel.getPhone());
                hotelDataRow.createCell(2).setCellValue(hotel.getRating());
                hotelDataRow.createCell(3).setCellValue(hotel.getAddress());

                List<RoomForm> rooms = hotelService.dbGetAllRoomsForHotel(hotel.getHotelId());
                for (RoomForm room : rooms) {
                    Row roomDataRow = sheet.createRow(rowNum++);
                    roomDataRow.createCell(4).setCellValue(room.getRoomType());
                    roomDataRow.createCell(5).setCellValue(room.getPrice());
                    roomDataRow.createCell(6).setCellValue(room.getAvaRoom());
                }
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "hotels.xlsx");

            return ResponseEntity.ok().headers(headers).body(outputStream.toByteArray());
        } catch (IOException e) {
            // Handle exception
            return ResponseEntity.badRequest().build();
        }
    }

}