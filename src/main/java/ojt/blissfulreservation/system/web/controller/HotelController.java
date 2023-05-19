package ojt.blissfulreservation.system.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ojt.blissfulreservation.system.bl.service.HotelService;
import ojt.blissfulreservation.system.bl.service.RoomService;
import ojt.blissfulreservation.system.persistence.entity.Hotel;
import ojt.blissfulreservation.system.web.form.HotelForm;
import ojt.blissfulreservation.system.web.form.RoomForm;

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
     * <h2> roomService</h2>
     * <p>
     * roomService
     * </p>
     */
    @Autowired
    private RoomService roomService;

    /**
     * <h2> hotelList</h2>
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
     * <h2> hotelByCity</h2>
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
        List<String> cityList = hotelService.getCities();
        model.addObject("cityList", cityList);
        List<Hotel> hotelList = hotelService.doGetHotels(city);
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
    public String registerNewHotel(@ModelAttribute("hotel") HotelForm hotel,HttpServletRequest request) throws IOException {
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
    public String updateHotel(@ModelAttribute("hotel") HotelForm hotelForm,HttpServletRequest request) throws IOException {
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
}