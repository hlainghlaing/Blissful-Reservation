package ojt.blissfulreservation.system.persistence.entity;

import java.sql.Date;

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
@Table(name = "booking")
public class Booking {
    /**
     * <h2> bookingId</h2>
     * <p>
     * bookingId
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_id")
    private int bookingId;
    
    /**
     * <h2> chekIn</h2>
     * <p>
     * chekIn
     * </p>
     */
    @Column(name = "check_in" , nullable = false)
    private Date chekIn;
    
    /**
     * <h2> checkOut</h2>
     * <p>
     * checkOut
     * </p>
     */
    @Column(name = "check_out", nullable = false)
    private Date checkOut;
    
    /**
     * <h2> roomNum</h2>
     * <p>
     * roomNum
     * </p>
     */
    @Column(name = "room_num",nullable = false)
    private int roomNum;
    
    /**
     * <h2> totalPrice</h2>
     * <p>
     * totalPrice
     * </p>
     */
    @Column(name = "total_price",nullable = false)
    private Double totalPrice;
    
    /**
     * <h2> nrc</h2>
     * <p>
     * nrc
     * </p>
     */
    @Column(name = "nrc",nullable = false)
    private String nrc;
    
    /**
     * <h2> status</h2>
     * <p>
     * status
     * </p>
     */
    @Column(name = "status", nullable = false)
    private String status;
    
    /**
     * <h2> roomId</h2>
     * <p>
     * roomId
     * </p>
     */
    @Column(name = "room_id")
    private int roomId;
    
    /**
     * <h2> userId</h2>
     * <p>
     * userId
     * </p>
     */
    @Column(name = "user_id")
    private int userId;
}
