package ojt.blissfulreservation.system.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
 * <h2>RoomController Class</h2>
 * <p>
 * Process for Displaying RoomController
 * </p>
 * 
 * @author MiMiSoe
 *
 */
@Controller
public class RoomController {
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
     * <h2>view</h2>
     * <p>
     * 
     * </p>
     *
     * @param model
     * @param room
     * @param id
     * @return
     * @return String
     */
    @RequestMapping(value = "/add-room")
    public String view(Model model, RoomForm room, @RequestParam("id") int id) {
        room.setHotelId(id);
        HotelForm hotel = hotelService.doGetHotelById(id);
        room.setHotel(new Hotel(hotel));
        model.addAttribute("room", room);
        model.addAttribute("hotel", hotel);
        return "addRoom";
    }

    /**
     * <h2>saveContact</h2>
     * <p>
     * 
     * </p>
     *
     * @param roomForm
     * @param request
     * @return
     * @throws IOException
     * @return ModelAndView
     */
    @RequestMapping(value = "/saveroom", method = RequestMethod.POST)
    public ModelAndView saveContact(@Valid @ModelAttribute("room") RoomForm roomForm, HttpServletRequest request,BindingResult bindingResult)
            throws IOException {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("addRoom");
        }
        HotelForm hotel = hotelService.doGetHotelById(roomForm.getHotelId());
        roomForm.setHotel(new Hotel(hotel));
        roomService.doSave(roomForm, roomForm.getFile());
        HttpSession session = request.getSession();
        session.setAttribute("successMessage", "New room is successfully registered!");
        return new ModelAndView("redirect:/hotel-view");
    }

    /**
     * <h2>deleteRoom</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @param id
     * @return
     * @return String
     */
    @RequestMapping(value = "/deleteroom", method = RequestMethod.GET)
    public String deleteRoom(HttpServletRequest request, @RequestParam("id") int id) {
        RoomForm roomForm = roomService.doGetById(id);
        roomService.doDelete(roomForm);
        HttpSession session = request.getSession();
        session.setAttribute("successMessage", "Room deleted successfully!");
        return "redirect:/hotel-view";
    }

    /**
     * <h2>editRoom</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @param m
     * @param id
     * @return
     * @return String
     */
    @RequestMapping(value = "/edit-room", method = RequestMethod.GET)
    public String editRoom(HttpServletRequest request, Model m, @RequestParam("id") int id) {
        RoomForm room = roomService.doGetById(id);
        m.addAttribute("room", room);
        return "editRoom";
    }

    /**
     * <h2>editsaveRoom</h2>
     * <p>
     * 
     * </p>
     *
     * @param roomForm
     * @param request
     * @return
     * @throws IOException
     * @return String
     */
    @RequestMapping(value = "/editsaveRoom", method = RequestMethod.POST)
    public String editsaveRoom(@ModelAttribute("room") RoomForm roomForm, HttpServletRequest request)
            throws IOException {
        System.out.println(roomForm.getAvaRoom() + roomForm.getPrice());
        HotelForm hotel = hotelService.doGetHotelById(roomForm.getHotelId());
        roomForm.setHotel(new Hotel(hotel));
        roomService.doUpdate(roomForm, roomForm.getFile());
        HttpSession session = request.getSession();
        session.setAttribute("successMessage", "Room updated successfully!");
        return "redirect:/hotel-view";
    }

    /**
     * <h2>roomList</h2>
     * <p>
     * 
     * </p>
     *
     * @param request
     * @param model
     * @param id
     * @param authentication
     * @return
     * @return ModelAndView
     */
    @RequestMapping(value = "/viewRoomByHotelId", method = RequestMethod.GET)
    public ModelAndView roomList(HttpServletRequest request, ModelAndView model, @RequestParam("id") int id,
            Authentication authentication) {
        List<RoomForm> roomList = roomService.doGetRoomList(id);
        model.addObject("roomList", roomList);
        if (authentication != null && authentication.isAuthenticated()) {
            model.setViewName("roomListUserView");
            return model;
        }
        model.setViewName("roomListAllView");
        return model;
    }
}
