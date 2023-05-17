package ojt.blissfulreservation.system.persistence.dao;

import java.util.List;

import ojt.blissfulreservation.system.persistence.entity.Hotel;

/**
 * <h2>HotelDAO Class</h2>
 * <p>
 * Process for Displaying HotelDAO
 * </p>
 * 
 * @author Hnaung Thet Htar Wai
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
    
    public List<String> dbGetCities();

    public List<Hotel> dbGetHotels(String city);
}
