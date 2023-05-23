package ojt.blissfulreservation.system.persistence.dao;

import java.util.List;

import ojt.blissfulreservation.system.persistence.entity.Hotel;
import ojt.blissfulreservation.system.persistence.entity.Room;

/**
 * <h2>HotelDAO Class</h2>
 * <p>
 * Process for Displaying HotelDAO
 * </p>
 * 
 * @author HnaungThetHtarWai
 *
 */
/**
 * <h2> HotelDAO Class</h2>
 * <p>
 * Process for Displaying HotelDAO
 * </p>
 * 
 * @author DELL
 *
 */
public interface HotelDAO {

    /**
     * <h2>dbGetAllHotels</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<Hotel>
     */
    List<Hotel> dbGetAllHotels();

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
    Hotel dbGetHotelById(int id);

    /**
     * <h2>registerNewHotel</h2>
     * <p>
     * 
     * </p>
     *
     * @param hotel
     * @return void
     */
    void dbRegisterNewHotel(Hotel hotel);

    /**
     * <h2>updateHotel</h2>
     * <p>
     * 
     * </p>
     *
     * @param hotel
     * @return void
     */
    void dbUpdateHotel(Hotel hotel);

    /**
     * <h2>dbSaveHotel</h2>
     * <p>
     * 
     * </p>
     *
     * @param hotel
     * @return void
     */
    void dbSaveHotel(Hotel hotel);

    /**
     * <h2>dbFindUserByPhoneNo</h2>
     * <p>
     * 
     * </p>
     *
     * @param phone
     * @return
     * @return Hotel
     */
    Hotel dbFindHotelByPhoneNo(String phone);

    /**
     * <h2>dbDeleteHotel</h2>
     * <p>
     * 
     * </p>
     *
     * @param hotel
     * @return void
     */
    void dbDeleteHotel(Hotel hotel);
    
    /**
     * <h2> dbGetCities</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<String>
     */
    public List<String> dbGetCities();

    /**
     * <h2> dbGetHotels</h2>
     * <p>
     * 
     * </p>
     *
     * @param city
     * @return
     * @return List<Hotel>
     */
    public List<Hotel> dbGetHotels(String city);
    
    List<Room> dbGetRoomsForHotel(int hotelId);
}
