package ojt.blissfulreservation.system.web.form;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.blissfulreservation.system.persistence.entity.Booking;
import ojt.blissfulreservation.system.persistence.entity.Room;
import ojt.blissfulreservation.system.persistence.entity.User;

/**
 * <h2>BookingForm Class</h2>
 * <p>
 * Process for Displaying BookingForm
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookingForm {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    @NotEmpty
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date checkIn;
    @NotEmpty
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date checkOut;
    @NotEmpty
    private int roomNum;
    @NotEmpty
    private Double totalPrice;
    @NotEmpty
    private String nrc;
    @NotEmpty
    private int status;
    private int roomId;
    private int userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Room room;
    private User user;

    /**
     * <h2>Constructor for BookingForm</h2>
     * <p>
     * Constructor for BookingForm
     * </p>
     * 
     * @param booking
     */
    public BookingForm(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.checkIn = booking.getCheckIn();
        this.checkOut = booking.getCheckOut();
        this.roomNum = booking.getRoomNum();
        this.totalPrice = booking.getTotalPrice();
        this.nrc = booking.getNrc();
        this.createdAt = booking.getCreatedAt();
        this.updatedAt = booking.getUpdatedAt();
        this.deletedAt = booking.getDeletedAt();
        this.roomId = booking.getRoomId();
        this.userId = booking.getUserId();
    }
    
    private static final Map<Integer, String> STATUS_MAP = new HashMap<Integer,String>() {
        {
            put(1, "Pending");
            put(2, "Accept");
            put(3, "Reject");
        }
    };
    
    public String getStatusName() {
        return STATUS_MAP.get(status);
    }
}
