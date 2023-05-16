package ojt.blissfulreservation.system.bl.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ojt.blissfulreservation.system.persistence.entity.Hotel;

/**
 * <h2>HotelService Class</h2>
 * <p>
 * Process for Displaying HotelService
 * </p>
 * 
 * @author Hnaung Thet Htar Wai
 *
 */
public interface HotelService {
    /**
     * <h2>getHotelById</h2>
     * <p>
     * 
     * </p>
     *
     * @param id
     * @return
     * @return Hotel
     */
    Hotel doGetHotelById(int id);

    /**
     * <h2>getAllHotels</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<Hotel>
     */
    List<Hotel> doGetAllHotels();

    /**
     * <h2>registerNewHotel</h2>
     * <p>
     * 
     * </p>
     *
     * @param hotel
     * @param image
     * @return void
     */

    void doRegisterNewHotel(Hotel hotel, MultipartFile image) throws IOException;

    /**
     * <h2> doUpdateHotel</h2>
     * <p>
     * 
     * </p>
     *
     * @param hotel
     * @param image
     * @throws IOException
     * @return void
     */
    void doUpdateHotel(Hotel hotel, MultipartFile image) throws IOException;

    /**
     * <h2>deleteHotel</h2>
     * <p>
     * 
     * </p>
     *
     * @param hotel
     * @return void
     */
    void doDeleteHotel(Hotel hotel);
}
