package ojt.blissfulreservation.system.persistence.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "booking")
public class Booking {
    /**
     * <h2>bookingId</h2>
     * <p>
     * bookingId
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_id")
    private int bookingId;

    /**
     * <h2>chekIn</h2>
     * <p>
     * chekIn
     * </p>
     */
    @Column(name = "check_in", nullable = false)
    private Date chekIn;

    /**
     * <h2>checkOut</h2>
     * <p>
     * checkOut
     * </p>
     */
    @Column(name = "check_out", nullable = false)
    private Date checkOut;

    /**
     * <h2>roomNum</h2>
     * <p>
     * roomNum
     * </p>
     */
    @Column(name = "b_room_num", nullable = false)
    private int roomNum;

    /**
     * <h2>totalPrice</h2>
     * <p>
     * totalPrice
     * </p>
     */
    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private Double totalPrice;

    /**
     * <h2>nrc</h2>
     * <p>
     * nrc
     * </p>
     */
    @Column(name = "nrc", nullable = false, unique = true, length = 45)
    private String nrc;

    /**
     * <h2>status</h2>
     * <p>
     * status
     * </p>
     */
    @Column(name = "status", nullable = false, columnDefinition = "int default 1")
    private int status;

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id",nullable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
