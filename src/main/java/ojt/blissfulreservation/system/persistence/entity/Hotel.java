package ojt.blissfulreservation.system.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {
    /**
     * <h2> hotelId</h2>
     * <p>
     * hotelId
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id",nullable = false)
    private int hotelId;
    
    /**
     * <h2> hotelName</h2>
     * <p>
     * hotelName
     * </p>
     */
    @Column(name = "hotel_name", nullable = false)
    private String hotelName;
    
    /**
     * <h2> rating</h2>
     * <p>
     * rating
     * </p>
     */
    @Column(name = "rating" , nullable = false)
    private int rating;
    
    /**
     * <h2> address</h2>
     * <p>
     * address
     * </p>
     */
    @Column(name = "address" , nullable = false)
    private String address;
    
    /**
     * <h2> city</h2>
     * <p>
     * city
     * </p>
     */
    @Column(name = "city", nullable = false)
    private String city;
    
    /**
     * <h2> phone</h2>
     * <p>
     * phone
     * </p>
     */
    @Column(name="phone",nullable = false)
    private String phone;
    
    /**
     * <h2> hotelImg</h2>
     * <p>
     * hotelImg
     * </p>
     */
    @Column(name = "hotel_img",nullable = false)
    private byte[] hotelImg;
}
