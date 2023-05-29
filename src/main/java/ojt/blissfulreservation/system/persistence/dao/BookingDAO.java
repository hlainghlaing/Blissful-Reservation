package ojt.blissfulreservation.system.persistence.dao;

import java.util.List;

import ojt.blissfulreservation.system.persistence.entity.Booking;

/**
 * <h2>BookingDAO Class</h2>
 * <p>
 * Process for Displaying BookingDAO
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
public interface BookingDAO {
    /**
     * <h2>dbCreateBooking</h2>
     * <p>
     * 
     * </p>
     *
     * @param booking
     * @return void
     */
    public void dbCreateBooking(Booking booking);

    /**
     * <h2>dbGetBookingById</h2>
     * <p>
     * 
     * </p>
     *
     * @param id
     * @return
     * @return Booking
     */
    public Booking dbGetBookingById(int id);

    /**
     * <h2>dbGetBookingList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<Booking>
     */
    public List<Booking> dbGetBookingList();

    /**
     * <h2>dbGetBookingByuser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userId
     * @return
     * @return List<Booking>
     */
    public List<Booking> dbGetBookingByuser(int userId);

    /**
     * <h2>dbUpdateBooking</h2>
     * <p>
     * 
     * </p>
     *
     * @param booking
     * @return void
     */
    public void dbUpdateBooking(Booking booking);

    /**
     * <h2>dbDeleteBooking</h2>
     * <p>
     * 
     * </p>
     *
     * @param booking
     * @return void
     */
    public void dbDeleteBooking(Booking booking);
}
