package ojt.blissfulreservation.system.bl.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ojt.blissfulreservation.system.bl.service.HotelService;
import ojt.blissfulreservation.system.persistence.dao.HotelDAO;
import ojt.blissfulreservation.system.persistence.entity.Hotel;
import ojt.blissfulreservation.system.persistence.entity.User;
import ojt.blissfulreservation.system.web.form.HotelForm;
import ojt.blissfulreservation.system.web.form.UserForm;

/**
 * <h2>HotelServiceImpl Class</h2>
 * <p>
 * Process for Displaying HotelServiceImpl
 * </p>
 * 
 * @author Hnaung Thet Htar Wai
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
     * <h2>registerNewHotel</h2>
     * <p>
     * Process of accepting new hotel
     * </p>
     * 
     * @param hotel
     * @param image
     */

    @Override
    public void doRegisterNewHotel(HotelForm hotelForm, MultipartFile hotelImg) throws IOException {
        Hotel hotel = new Hotel(hotelForm);
        String fileName = StringUtils.cleanPath(hotelImg.getOriginalFilename());
        hotel.setHotelImg(fileName);
        hotelDAO.dbSaveHotel(hotel);

        String uploadDir = "D:\\EclipseWorkspace_BIB_OJT07\\Blissful_Reservation\\"
                + "src\\main\\webapp\\resources\\img\\hotel-images\\";
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        File serverFile = new File(uploadDir + fileName);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(hotelImg.getBytes());
        stream.close();
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
    public void doUpdateHotel(HotelForm hotelForm, MultipartFile image) throws IOException {
        Hotel existingHotel = new Hotel(hotelForm);
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

    @Override
    public List<String> getCities() {
        return hotelDAO.dbGetCities();
    }

    @Override
    public List<Hotel> doGetHotels(String city) {
        return hotelDAO.dbGetHotels(city);
    }

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
}
