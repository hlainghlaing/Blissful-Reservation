package ojt.blissfulreservation.system.web.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Files;
import java.io.File;
import java.io.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ojt.blissfulreservation.system.bl.service.HotelService;
import ojt.blissfulreservation.system.bl.service.RoomService;
import ojt.blissfulreservation.system.persistence.entity.Hotel;
import ojt.blissfulreservation.system.persistence.entity.Room;
import ojt.blissfulreservation.system.web.form.HotelForm;
import ojt.blissfulreservation.system.web.form.RoomForm;

@Controller
public class RoomController {

    @Autowired
    private HotelService hotelService;
    
    @Autowired
    private RoomService roomService;
    
    @RequestMapping(value = "/add-room")
    public String view(Model model,RoomForm room,@RequestParam("id") int id) {
        room.setHotelId(id);
        HotelForm hotel = hotelService.doGetHotelById(id);
        room.setHotel(new Hotel(hotel));
        model.addAttribute("room", room);
        model.addAttribute("hotel", hotel);
        return "addRoom";
    }

    /**
     * @param roomForm
     * @return viewRoom.jsp
     * @throws IOException
     */
    @RequestMapping(value = "/saveroom", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute("room") RoomForm roomForm) throws IOException {
        HotelForm hotel = hotelService.doGetHotelById(roomForm.getHotelId());
        roomForm.setHotel(new Hotel(hotel));
        roomService.doSave(roomForm, roomForm.getFile());
        return new ModelAndView("redirect:/hotel-view");
    }

    
    
    /**
     * @param roomId
     * @param ServletRequest
     * @return Mappingname
     */
    @RequestMapping(value = "/deleteroom", method = RequestMethod.GET)
    public String deleteRoom(HttpServletRequest request, @RequestParam("id") int id) {
        RoomForm roomForm = roomService.doGetById(id);
        roomService.doDelete(roomForm);
        return "redirect:/hotel-view";
    }

    /**
     * @param request
     * @param m
     * @param roomId
     * @return editRoom.jsp
     */
    @RequestMapping(value = "/edit-room", method = RequestMethod.GET)
    public String editRoom(HttpServletRequest request, Model m, @RequestParam("id") int id) {
        RoomForm room = roomService.doGetById(id);
        m.addAttribute("room", room);
        return "editRoom";
    }



    /**
     * @param roomForm
     * @return success.jsp
     * @throws IOException 
     */
    @RequestMapping(value = "/editsaveRoom", method = RequestMethod.POST)
    public String editsaveRoom(@ModelAttribute("room") RoomForm roomForm) throws IOException {
        HotelForm hotel = hotelService.doGetHotelById(roomForm.getHotelId());
        roomForm.setHotel(new Hotel(hotel));
        roomService.doUpdate(roomForm);
        return "redirect:/hotel-view";
    }
    
    @RequestMapping(value = "/viewRoomByHotelId", method = RequestMethod.GET)
    public ModelAndView roomList(HttpServletRequest request, ModelAndView model, @RequestParam("id") int id,Authentication authentication) {
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
