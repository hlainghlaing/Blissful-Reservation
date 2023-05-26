package ojt.blissfulreservation.system.bl.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ojt.blissfulreservation.system.bl.service.HotelService;
import ojt.blissfulreservation.system.persistence.dao.HotelDAO;
import ojt.blissfulreservation.system.persistence.entity.Hotel;
import ojt.blissfulreservation.system.persistence.entity.Room;
import ojt.blissfulreservation.system.web.form.HotelForm;
import ojt.blissfulreservation.system.web.form.RoomForm;

/**
 * <h2>HotelServiceImpl Class</h2>
 * <p>
 * Process for Displaying HotelServiceImpl
 * </p>
 * 
 * @author HnaungThetHtarWai
 *
 */
@Service
@Transactional
public class HotelServiceImpl implements HotelService {

	/**
	 * <h2>hotelDAO</h2>
	 * <p>
	 * hotelDAO
	 * </p>
	 */
	@Autowired
	private HotelDAO hotelDAO;

	/**
	 * <h2>session</h2>
	 * <p>
	 * session
	 * </p>
	 */
	@Autowired
	private ServletRequest session;

	/**
	 * <h2>doGetHotelById</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public HotelForm doGetHotelById(int id) {
		Hotel hotel = hotelDAO.dbGetHotelById(id);
		HotelForm hotelForm = new HotelForm(hotel);
		return hotelForm;
	}

	/**
	 * <h2>doGetAllHotels</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<HotelForm> doGetAllHotels() {
		List<Hotel> list = hotelDAO.dbGetAllHotels();
		List<HotelForm> hotelList = new ArrayList<>();
		for (Hotel hotel : list) {
			HotelForm hotelForm = new HotelForm(hotel);
			hotelList.add(hotelForm);
		}
		return hotelList;
	}

	/**
	 * <h2>doRegisterNewHotel</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param hotelForm
	 * @param hotelImg
	 * @throws IOException
	 */
	@Override
	public void doRegisterNewHotel(HotelForm hotelForm, MultipartFile hotelImg) throws IOException {
		String webAppRoot = session.getServletContext().getRealPath("/");
		String uploadDir = webAppRoot + File.separator + "resources" + File.separator + "img" + File.separator
				+ "hotel-images" + File.separator;
		Path uploadPath = Paths.get(uploadDir);

		if (Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		try (InputStream inputStream = hotelImg.getInputStream()) {
			String fileName = StringUtils.cleanPath(hotelImg.getOriginalFilename());
			hotelForm.setHotelImg(fileName);
			Hotel hotel = new Hotel(hotelForm);
			hotelDAO.dbSaveHotel(hotel);
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * <h2>doUpdateHotel</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param hotelForm
	 * @param image
	 * @throws IOException
	 */
	@Override
	public void doUpdateHotel(HotelForm hotelForm, @RequestParam(value = "image", required = false) MultipartFile image)
			throws IOException {
		Hotel existingHotel = new Hotel(hotelForm);

		if (image != null) {
			String webAppRoot = session.getServletContext().getRealPath("/");
			String uploadDir = webAppRoot + File.separator + "resources" + File.separator + "img" + File.separator
					+ "hotel-images" + File.separator;
			Path uploadPath = Paths.get(uploadDir);

			try (InputStream inputStream = image.getInputStream()) {
				String fileName = StringUtils.cleanPath(image.getOriginalFilename());
				existingHotel.setHotelImg(fileName);
				hotelDAO.dbUpdateHotel(existingHotel);

				if (Files.notExists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}

				Path filePath = uploadPath.resolve(fileName);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				System.out.println("Error saving image: " + e.getMessage());
			}
		}
		hotelForm.setFile(hotelForm.getFile());
		hotelDAO.dbUpdateHotel(existingHotel);
	}

	/**
	 * <h2>doFindHotelByPhoneNo</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param phone
	 * @return
	 */
	@Override
	public HotelForm doFindHotelByPhoneNo(String phone) {
		Hotel hotel = hotelDAO.dbFindHotelByPhoneNo(phone);
		if (hotel != null) {
			HotelForm hotelform = new HotelForm(hotel);
			return hotelform;
		}
		return null;
	}

	/**
	 * <h2>doDeleteHotel</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param hotelform
	 */
	@Override
	public void doDeleteHotel(HotelForm hotelform) {
		int option = JOptionPane.showConfirmDialog(null, "Are you sure to delete?");
		if (option == JOptionPane.YES_OPTION) {
			hotelform.setDeletedAt(LocalDateTime.now());
			Hotel hotel = new Hotel(hotelform);
			hotelDAO.dbDeleteHotel(hotel);
		}
	}

	/**
	 * <h2>getCities</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<String> getCities() {
		return hotelDAO.dbGetCities();
	}

	/**
	 * <h2>doGetHotels</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param city
	 * @return
	 */
	@Override
	public List<Hotel> doGetHotels(String city) {
		return hotelDAO.dbGetHotels(city);
	}

	/**
	 * <h2>doGetUpdatedHotels</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<HotelForm> doGetUpdatedHotels() {
		List<Hotel> list = hotelDAO.dbGetAllHotels();
		List<HotelForm> hotelList = new ArrayList<>();
		for (Hotel hotel : list) {
			HotelForm hotelForm = new HotelForm(hotel);
			if (hotel.getDeleteAt() == null) {
				hotelList.add(hotelForm);
			}
		}
		return hotelList;
	}

	/**
	 * <h2>dbGetAllRoomsForHotel</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param hotelId
	 * @return
	 */
	@Override
	public List<RoomForm> dbGetAllRoomsForHotel(int hotelId) {
		List<Room> rooms = hotelDAO.dbGetRoomsForHotel(hotelId);
		List<RoomForm> roomList = new ArrayList<>();
		for (Room room : rooms) {
			RoomForm roomForm = new RoomForm(room);
			roomList.add(roomForm);
		}
		return roomList;
	}
}
