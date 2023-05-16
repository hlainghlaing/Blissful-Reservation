package ojt.blissfulreservation.system.bl.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;

import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContextUtils;

import ojt.blissfulreservation.system.bl.service.HotelService;
import ojt.blissfulreservation.system.persistence.dao.HotelDAO;
import ojt.blissfulreservation.system.persistence.entity.Hotel;

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

    @Autowired
    private ServletContext session;

    /**
     * <h2>getHotelById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param id
     * @return
     */
    @Override
    public Hotel doGetHotelById(int id) {
        return hotelDAO.dbGetHotelById(id);
    }

    /**
     * <h2>getAllHotels</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    public List<Hotel> doGetAllHotels() {
        return hotelDAO.dbGetAllHotels();
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
    public void doRegisterNewHotel(Hotel hotel, MultipartFile hotelImg) throws IOException {
        String fileName = StringUtils.cleanPath(hotelImg.getOriginalFilename());
        hotel.setHotelImg(fileName);
        hotelDAO.dbSaveHotel(hotel);

        String uploadDir = "C:\\Users\\DELL\\Downloads\\Java Gp Project\\Blissful_Reservation\\"
                + "src\\main\\webapp\\resources\\images\\hotel-images\\";
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        File serverFile = new File(uploadDir + fileName);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(hotelImg.getBytes());
        stream.close();
    }

//    @Override
//    public void doUpdateHotel(Hotel hotel, MultipartFile image) throws IOException {
////      // Check if a new image is provided
////      if (image != null && !image.isEmpty()) {
////          String filename = image.getOriginalFilename();
////          String imagePath = "/resources/images/hotel-images/";
////          HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
////          saveImageToDirectory(image, filename, imagePath, request); // Save the image to the directory
////          existingHotel.setImage(filename); // Update the image filename in the hotel object
////      }
////
////        hotelDAO.dbUpdateHotel(hotel); 
////    }

    /**
     * <h2>deleteHotel</h2>
     * <p>
     * 
     * </p>
     * 
     * @param hotel
     */
    @Override
    public void doDeleteHotel(Hotel hotel) {
        hotelDAO.dbDeleteHotel(hotel);
    }

    @Override
    public void doUpdateHotel(Hotel hotel, MultipartFile image) throws IOException {
        // TODO Auto-generated method stub
        
    }
}
