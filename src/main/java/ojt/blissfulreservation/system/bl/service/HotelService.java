package ojt.blissfulreservation.system.bl.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ojt.blissfulreservation.system.web.form.HotelForm;

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
	 * <h2>doGetHotelById</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param id
	 * @return
	 * @return HotelForm
	 */
	HotelForm doGetHotelById(int id);

	/**
	 * <h2>doGetAllHotels</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return List<HotelForm>
	 */
	List<HotelForm> doGetAllHotels();

	/**
	 * <h2>doRegisterNewHotel</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param hotel
	 * @param image
	 * @throws IOException
	 * @return void
	 */
	void doRegisterNewHotel(HotelForm hotel, MultipartFile image) throws IOException;

	/**
	 * <h2>doUpdateHotel</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param hotel
	 * @param image
	 * @throws IOException
	 * @return void
	 */
	void doUpdateHotel(HotelForm hotel, MultipartFile image) throws IOException;

	/**
	 * <h2>doDeleteHotel</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param id
	 * @return void
	 */
	void doDeleteHotel(int id);
}
