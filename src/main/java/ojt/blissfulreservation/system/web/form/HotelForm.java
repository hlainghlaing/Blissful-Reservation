package ojt.blissfulreservation.system.web.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.blissfulreservation.system.persistence.entity.Hotel;

/**
 * <h2> HotelForm Class</h2>
 * <p>
 * Process for Displaying HotelForm
 * </p>
 * 
 * @author HnaungThetHtarWai
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelForm {

	/**
	 * <h2>hotelId</h2>
	 * <p>
	 * hotelId
	 * </p>
	 */
	private int hotelId;

	/**
	 * <h2>hotelName</h2>
	 * <p>
	 * hotelName
	 * </p>
	 */
	@NotEmpty
	private String hotelName;

	/**
	 * <h2>rating</h2>
	 * <p>
	 * rating
	 * </p>
	 */
	/**
	 * <h2>rating</h2>
	 * <p>
	 * rating
	 * </p>
	 */
	@NotEmpty
	private int rating;

	/**
	 * <h2>address</h2>
	 * <p>
	 * address
	 * </p>
	 */
	@NotEmpty
	private String address;

	/**
	 * <h2>city</h2>
	 * <p>
	 * city
	 * </p>
	 */
	@NotEmpty
	private String city;

	/**
	 * <h2>phone</h2>
	 * <p>
	 * phone
	 * </p>
	 */
	@NotEmpty
	private String phone;

	/**
	 * <h2>hotelImg</h2>
	 * <p>
	 * hotelImg
	 * </p>
	 */
	@NotEmpty
	private String hotelImg;

	/**
	 * <h2> createdAt</h2>
	 * <p>
	 * createdAt
	 * </p>
	 */
	private LocalDateTime createdAt;
	
	/**
	 * <h2> updatedAt</h2>
	 * <p>
	 * updatedAt
	 * </p>
	 */
	private LocalDateTime updatedAt;
	
	/**
	 * <h2> deletedAt</h2>
	 * <p>
	 * deletedAt
	 * </p>
	 */
	private LocalDateTime deletedAt;
	

	/**
	 * <h2>file</h2>
	 * <p>
	 * file
	 * </p>
	 */
	
	private MultipartFile file;

	/**
	 * <h2>Constructor for HotelForm</h2>
	 * <p>
	 * Constructor for HotelForm
	 * </p>
	 * 
	 * @param hotel
	 */
	public HotelForm(Hotel hotel) {
		this.hotelId = hotel.getHotelId();
		this.hotelName = hotel.getHotelName();
		this.rating = hotel.getRating();
		this.address = hotel.getAddress();
		this.city = hotel.getCity();
		this.phone = hotel.getPhone();
		this.hotelImg = hotel.getHotelImg();
		this.createdAt = hotel.getCreatedAt();
		this.updatedAt = hotel.getUpdatedAt();
		this.deletedAt = hotel.getDeleteAt();
	}
}
