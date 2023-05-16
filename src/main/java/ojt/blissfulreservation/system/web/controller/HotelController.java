package ojt.blissfulreservation.system.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ojt.blissfulreservation.system.bl.service.HotelService;
import ojt.blissfulreservation.system.web.form.HotelForm;

/**
 * <h2> HotelController Class</h2>
 * <p>
 * Process for Displaying HotelController
 * </p>
 * 
 * @author DELL
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
		return "/new-hotel-register";
	}

	/**
	 * <h2>registerNewHotel</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param hotel
	 * @return
	 * @throws IOException
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerNewHotel(@ModelAttribute("hotel") HotelForm hotel) throws IOException {
		ModelAndView view = new ModelAndView("hotel-list-admin-view");
		hotelService.doRegisterNewHotel(hotel, hotel.getFile());
		view.setViewName("redirect:view");
		return view;
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
	@GetMapping("/view")
	public String getAllHotels(Model model) {
		List<HotelForm> hotelList = hotelService.doGetAllHotels();
		model.addAttribute("hotelList", hotelList);
		return "hotel-list-admin-view";
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
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editHotelForm(@RequestParam("id") int hotelId) {
		HotelForm hotel = hotelService.doGetHotelById(hotelId);
		ModelAndView modelAndView = new ModelAndView("hotel-update-form");
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
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateHotel(@ModelAttribute("hotel") HotelForm hotelForm) throws IOException {
		hotelService.doUpdateHotel(hotelForm, hotelForm.getFile());
		return "redirect:/view";
	}

	/**
	 * <h2>deleteHotel</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param hotelId
	 * @return
	 * @return String
	 */
	@GetMapping("/delete")
	public String deleteHotel(@RequestParam("id") int hotelId) {
		hotelService.doDeleteHotel(hotelId);
		return "redirect:/view";
	}
}