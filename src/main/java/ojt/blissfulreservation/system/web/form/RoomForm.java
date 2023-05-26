package ojt.blissfulreservation.system.web.form;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.blissfulreservation.system.persistence.entity.Hotel;
import ojt.blissfulreservation.system.persistence.entity.Room;

/**
 * <h2> RoomForm Class</h2>
 * <p>
 * Process for Displaying RoomForm
 * </p>
 * 
 * @author MiMiSoe
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomForm {
    /**
     * <h2> roomId</h2>
     * <p>
     * roomId
     * </p>
     */
    private int roomId;
 
    /**
     * <h2> roomType</h2>
     * <p>
     * roomType
     * </p>
     */
    @SuppressWarnings("deprecation")
    @NotEmpty
    private String roomType;

    /**
     * <h2> price</h2>
     * <p>
     * price
     * </p>
     */
    @Size(min = 5 , max = 10)
    private Double price;
    
    /**
     * <h2> roomImg</h2>
     * <p>
     * roomImg
     * </p>
     */
    private String roomImg;

    /**
     * <h2> totalRoom</h2>
     * <p>
     * totalRoom
     * </p>
     */
    @Size(min = 1 , max = 3)
    private int totalRoom;
 
    /**
     * <h2> avaRoom</h2>
     * <p>
     * avaRoom
     * </p>
     */
    private int avaRoom;
  
    /**
     * <h2> createdAt</h2>
     * <p>
     * createdAt
     * </p>
     */
    private LocalDateTime createdAt;
   
    /**
     * <h2> deleteAt</h2>
     * <p>
     * deleteAt
     * </p>
     */
    private LocalDateTime deleteAt;
  
    /**
     * <h2> updatedAt</h2>
     * <p>
     * updatedAt
     * </p>
     */
    private LocalDateTime updatedAt;
  
    /**
     * <h2> hotelId</h2>
     * <p>
     * hotelId
     * </p>
     */
    private int hotelId;
    
    /**
     * <h2> hotel</h2>
     * <p>
     * hotel
     * </p>
     */
    private Hotel hotel;
    /**
     * <h2>file</h2>
     * <p>
     * file
     * </p>
     */
    private MultipartFile file;

    /**
     * @param room
     */
    public RoomForm(Room room) {
        this.hotel = room.getHotel();
        this.roomId = room.getRoomId();
        this.roomType = room.getRoomType();
        this.price = room.getPrice();
        this.roomImg = room.getRoomImg();
        this.totalRoom = room.getTotalRoom();
        this.avaRoom = room.getAvaRoom();
        this.createdAt = room.getCreatedAt();
        this.deleteAt = room.getDeleteAt();
        this.updatedAt = room.getUpdatedAt();
        this.hotelId = room.getHotelId();
    }
}
