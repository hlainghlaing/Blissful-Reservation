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
@Table(name = "room")
public class Room {
    /**
     * <h2> roomId</h2>
     * <p>
     * roomId
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private int roomId;
    
    /**
     * <h2> roomType</h2>
     * <p>
     * roomType
     * </p>
     */
    @Column(name = "room_type", nullable = false)
    private String roomType;
    
    /**
     * <h2> price</h2>
     * <p>
     * price
     * </p>
     */
    @Column(name = "price" , nullable = false)
    private Double price;
    
    /**
     * <h2> roomImg</h2>
     * <p>
     * roomImg
     * </p>
     */
    @Column(name = "room_img", nullable = false)
    private byte[] roomImg;
    
    /**
     * <h2> hotelId</h2>
     * <p>
     * hotelId 
     * </p>
     */
    @Column(name = "hotel_id")
    private int hotelId;
}
