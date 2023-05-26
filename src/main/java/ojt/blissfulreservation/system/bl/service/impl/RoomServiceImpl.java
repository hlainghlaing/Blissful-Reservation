package ojt.blissfulreservation.system.bl.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletRequest;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ojt.blissfulreservation.system.bl.service.RoomService;
import ojt.blissfulreservation.system.persistence.dao.RoomDAO;
import ojt.blissfulreservation.system.persistence.entity.Hotel;
import ojt.blissfulreservation.system.persistence.entity.Room;
import ojt.blissfulreservation.system.web.form.RoomForm;

/**
 * <h2>RoomServiceImpl Class</h2>
 * <p>
 * Process for Displaying RoomServiceImpl
 * </p>
 * 
 * @author MiMiSoe
 *
 */
@Service
@Transactional
public class RoomServiceImpl implements RoomService {
	/**
	 * <h2>roomDao</h2>
	 * <p>
	 * roomDao
	 * </p>
	 */
	@Autowired
	private RoomDAO roomDao;

	@Autowired
	private ServletRequest session;

	/**
	 * <h2>doGetRoomList</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param id
	 * @return List<RoomForm>
	 */
	@Override
	public List<RoomForm> doGetRoomList(int id) {
		List<Room> roomList = roomDao.dbGetRoomList(id);
		List<RoomForm> roomFormList = new ArrayList<>();
		for (Room room : roomList) {
			RoomForm roomForm = new RoomForm(room);
			roomFormList.add(roomForm);
		}
		return roomFormList;
	}

	/**
	 * <h2>doDelete</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param roomForm
	 */
	@Override
	public void doDelete(RoomForm roomForm) {
		int option = JOptionPane.showConfirmDialog(null, "Are you sure to delete?");
		if (option == JOptionPane.YES_OPTION) {
			roomForm.setDeleteAt(LocalDateTime.now());
			Room room = new Room(roomForm);
			roomDao.dbDelete(room);
		}
	}

	/**
	 * <h2>doGetById</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param id
	 * @return RoomForm
	 */
	@Override
	public RoomForm doGetById(int id) {
		RoomForm roomForm = new RoomForm(roomDao.dbGetById(id));
		return roomForm;
	}

	/**
	 * <h2>doGetHotelAndRoomList</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return List<RoomForm>
	 */
	@Override
	public List<RoomForm> doGetHotelAndRoomList() {
		List<Room> roomList = roomDao.dbGetHotelsAndRoomList();
		List<RoomForm> roomFormList = new ArrayList<>();
		for (Room room : roomList) {
			RoomForm roomForm = new RoomForm(room);
			roomFormList.add(roomForm);
		}
		return roomFormList;
	}

	/**
	 * <h2>doSave</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param roomForm
	 * @param roomImg
	 * @throws IOException
	 */
	@Override
	public void doSave(RoomForm roomForm, MultipartFile roomImg) throws IOException {

		roomForm.setCreatedAt(LocalDateTime.now());
		roomForm.setAvaRoom(roomForm.getTotalRoom());

		String webAppRoot = session.getServletContext().getRealPath("/");
		String uploadDir = webAppRoot + File.separator + "resources" + File.separator + "img" + File.separator
				+ "hotel-images" + File.separator;
		Path uploadPath = Paths.get(uploadDir);

		if (Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		try (InputStream inputStream = roomImg.getInputStream()) {
			String fileName = StringUtils.cleanPath(roomImg.getOriginalFilename());
			Room room = new Room(roomForm);
			room.setRoomImg(fileName);
			roomDao.dbSave(room);
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * <h2>doUpdate</h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param roomForm
	 * @param image
	 * @throws IOException
	 */
	@Override
	public void doUpdate(RoomForm roomForm, @RequestParam(value = "image", required = false) MultipartFile image)
			throws IOException {
		roomForm.setAvaRoom(roomForm.getTotalRoom());
		roomForm.setUpdatedAt(LocalDateTime.now());
		Room existingRoom = new Room(roomForm);

		if (image != null) {
			String webAppRoot = session.getServletContext().getRealPath("/");
			String uploadDir = webAppRoot + File.separator + "resources" + File.separator + "img" + File.separator
					+ "hotel-images" + File.separator;
			Path uploadPath = Paths.get(uploadDir);

			try (InputStream inputStream = image.getInputStream()) {
				String fileName = StringUtils.cleanPath(image.getOriginalFilename());
				existingRoom.setRoomImg(fileName);
				roomDao.dbUpdate(existingRoom);

				if (Files.notExists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}

				Path filePath = uploadPath.resolve(fileName);
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				System.out.println("Error saving image: " + e.getMessage());
			}
		}
		roomForm.setFile(roomForm.getFile());
		roomDao.dbUpdate(existingRoom);
	}
}
