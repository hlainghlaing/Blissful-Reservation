package ojt.blissfulreservation.system.web.form;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

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
    /**
     * <h2>bookingId</h2>
     * <p>
     * bookingId
     * </p>
     */
    private int bookingId;

    /**
     * <h2>checkIn</h2>
     * <p>
     * checkIn
     * </p>
     */
    @NotEmpty
    private String checkIn;

    /**
     * <h2>checkOut</h2>
     * <p>
     * checkOut
     * </p>
     */
    @NotEmpty
    private String checkOut;

    /**
     * <h2>roomNum</h2>
     * <p>
     * roomNum
     * </p>
     */
    @Range(min = 1)
    private int roomNum;

    /**
     * <h2>totalPrice</h2>
     * <p>
     * totalPrice
     * </p>
     */
    private Double totalPrice;

    /**
     * <h2>nrc</h2>
     * <p>
     * nrc
     * </p>
     */
    @Pattern(regexp = "\\d{1,2}/[a-zA-Z]+\\([a-zA-Z]\\)\\d{6}")
    private String nrc;

    /**
     * <h2>status</h2>
     * <p>
     * status
     * </p>
     */
    private int status;

    /**
     * <h2>roomId</h2>
     * <p>
     * roomId
     * </p>
     */
    private int roomId;

    /**
     * <h2>userId</h2>
     * <p>
     * userId
     * </p>
     */
    private int userId;

    /**
     * <h2>createdAt</h2>
     * <p>
     * createdAt
     * </p>
     */
    private LocalDateTime createdAt;

    /**
     * <h2>updatedAt</h2>
     * <p>
     * updatedAt
     * </p>
     */
    private LocalDateTime updatedAt;

    /**
     * <h2>deletedAt</h2>
     * <p>
     * deletedAt
     * </p>
     */
    private LocalDateTime deletedAt;

    /**
     * <h2>room</h2>
     * <p>
     * room
     * </p>
     */
    private Room room;

    /**
     * <h2>user</h2>
     * <p>
     * user
     * </p>
     */
    private User user;

    /**
     * <h2>formatter</h2>
     * <p>
     * formatter
     * </p>
     */
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

    /**
     * <h2>STATUS_MAP</h2>
     * <p>
     * STATUS_MAP
     * </p>
     */
    private static final Map<Integer, String> STATUS_MAP = new HashMap<Integer, String>() {
        /**
         * <h2>serialVersionUID</h2>
         * <p>
         * serialVersionUID
         * </p>
         */
        private static final long serialVersionUID = 3144772033711356967L;

        {
            put(1, "Pending");
            put(2, "Accept");
            put(3, "Reject");
        }
    };

    /**
     * <h2>getStatusName</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    public String getStatusName() {
        return STATUS_MAP.get(status);
    }

    /**
     * <h2>dateDiff</h2>
     * <p>
     * 
     * </p>
     *
     * @param startDate
     * @param endDate
     * @return
     * @return int
     */
    public int dateDiff(LocalDate startDate, LocalDate endDate) {
        return (int) ChronoUnit.DAYS.between(startDate, endDate);
    }
}
