package ojt.blissfulreservation.system.web.form;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.blissfulreservation.system.persistence.entity.Hotel;
import ojt.blissfulreservation.system.persistence.entity.Room;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomForm {

    /**
     * roomId
     */
    private int roomId;
    /**
     * roomType
     */
    private String roomType;
    /**
     * roomPrice
     */
    private Double price;
    /**
     * roomImage
     */
    private String roomImg;
    /**
     * totalRoom
     */
    private int totalRoom;
    /**
     * Available Room
     */
    private int avaRoom;
    /**
     * Created Date
     */
    private LocalDateTime createdAt;
    /**
     * Deleted Date
     */
    private LocalDateTime deleteAt;
    /**
     * Updated Date
     */
    private LocalDateTime updatedAt;
    /**
     * Hotel id
     */
    private int hotelId;
    
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
