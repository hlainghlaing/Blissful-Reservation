package ojt.blissfulreservation.system.web.form;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;

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
    private String checkIn;
    @NotEmpty
    private String checkOut;
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
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

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
        this.checkIn = booking.getCheckIn().format(formatter);
        this.checkOut = booking.getCheckOut().format(formatter);
        this.roomNum = booking.getRoomNum();
        this.totalPrice = booking.getTotalPrice();
        this.nrc = booking.getNrc();
        this.status = booking.getStatus();
        this.createdAt = booking.getCreatedAt();
        this.updatedAt = booking.getUpdatedAt();
        this.deletedAt = booking.getDeletedAt();
        this.roomId = booking.getRoomId();
        this.userId = booking.getUserId();
        this.room = booking.getRoom();
        this.user = booking.getUser();
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
    
//    public String getCheckInFormat() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String formattedDate = checkIn.format(formatter);
//        return formattedDate;
//    }
//    
//    public String getCheckOutFormat() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String formattedDate = checkOut.format(formatter);
//        return formattedDate;
//    }
    
    public int dateDiff(LocalDate startDate,LocalDate endDate) {
        return (int) ChronoUnit.DAYS.between(startDate, endDate);
    }
}
