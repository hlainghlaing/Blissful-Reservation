package ojt.blissfulreservation.system.web.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.blissfulreservation.system.persistence.entity.Hotel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelForm {

    private int hotelId;

    @NotEmpty
    private String hotelName;

    @NotEmpty
    private int rating;

    @NotEmpty
    private String address;

    @NotEmpty
    private String city;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String hotelImg;

    private MultipartFile file;

    public HotelForm(Hotel hotel) {
        super();
        this.hotelId = hotel.getHotelId();
        this.hotelName = hotel.getHotelName();
        this.rating = hotel.getRating();
        this.address = hotel.getAddress();
        this.city = hotel.getCity();
        this.phone = hotel.getPhone();
        this.hotelImg = hotel.getHotelImg();
    }
}
