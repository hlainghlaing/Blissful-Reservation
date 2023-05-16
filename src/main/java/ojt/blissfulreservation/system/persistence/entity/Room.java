package ojt.blissfulreservation.system.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2> Room Class</h2>
 * <p>
 * Process for Displaying Room
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    /**
     * <h2>roomId</h2>
     * <p>
     * roomId
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id", columnDefinition = "INT(4) ZEROFILL")
    private int roomId;

    /**
     * <h2>roomType</h2>
     * <p>
     * roomType
     * </p>
     */
    @Column(name = "room_type", nullable = false, length = 20)
    private String roomType;

    /**
     * <h2>price</h2>
     * <p>
     * price
     * </p>
     */
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private Double price;

    /**
     * <h2>roomImg</h2>
     * <p>
     * roomImg
     * </p>
     */
    @Column(name = "room_img", nullable = false)
    private String roomImg;

    /**
     * <h2>totalRoom</h2>
     * <p>
     * totalRoom
     * </p>
     */
    @Column(name = "total_room", nullable = false)
    private int totalRoom;

    /**
     * <h2>avaRoom</h2>
     * <p>
     * avaRoom
     * </p>
     */
    @Column(name = "ava_room", nullable = false)
    private int avaRoom;

    /**
     * <h2>createdAt</h2>
     * <p>
     * createdAt
     * </p>
     */
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /**
     * <h2>updatedAt</h2>
     * <p>
     * updatedAt
     * </p>
     */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * <h2>deleteAt</h2>
     * <p>
     * deleteAt
     * </p>
     */
    @Column(name = "deleted_at")
    private LocalDateTime deleteAt;

    /**
     * <h2>hotelId</h2>
     * <p>
     * hotelId
     * </p>
     */
    @Column(name = "hotel_id", columnDefinition = "INT(4) ZEROFILL", insertable = false, updatable = false)
    private int hotelId;

    /**
     * <h2>hotel</h2>
     * <p>
     * hotel
     * </p>
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    /**
     * <h2> bookings</h2>
     * <p>
     * bookings
     * </p>
     */
    @OneToMany(mappedBy = "room")
    private List<Booking> bookings = new ArrayList<>();
}
