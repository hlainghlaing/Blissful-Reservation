package ojt.blissfulreservation.system.persistence.dao;

import java.util.List;

import ojt.blissfulreservation.system.persistence.entity.Hotel;

/**
 * /**
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
	 * <h2>dbDeleteHotelById</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param id
	 * @return void
	 */
	void dbDeleteHotelById(int id);

}