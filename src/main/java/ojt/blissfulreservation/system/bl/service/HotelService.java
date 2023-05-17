package ojt.blissfulreservation.system.bl.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ojt.blissfulreservation.system.persistence.entity.Hotel;
import ojt.blissfulreservation.system.web.form.HotelForm;
import ojt.blissfulreservation.system.web.form.UserForm;

/**
 * <h2>HotelService Class</h2>
 * <p>
 * Process for Displaying HotelService
 * </p>
 * 
 * @author Hnaung Thet Htar Wai
 *
 */
/**
 * <h2>HotelService Class</h2>
 * <p>
 * Process for Displaying HotelService
 * </p>
 * 
 * @author DELL
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
	 * <h2>doFindHotelByPhoneNo</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param phone
	 * @return
	 * @return HotelForm
	 */
	public HotelForm doFindHotelByPhoneNo(String phone);

	/**
	 * <h2>doDeleteHotel</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param hotel
	 * @return void
	 */
	public void doDeleteHotel(HotelForm hotel);
	
    /**
     * @return city list
     */
    public List<String> getCities();

    /**
     * @param city
     * @return hotel list
     */
    public List<Hotel> doGetHotels(String city);

}
