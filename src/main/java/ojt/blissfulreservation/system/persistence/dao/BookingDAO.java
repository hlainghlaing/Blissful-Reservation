package ojt.blissfulreservation.system.persistence.dao;

import java.util.List;

import ojt.blissfulreservation.system.persistence.entity.Booking;

/**
 * <h2> BookingDAO Class</h2>
 * <p>
 * Process for Displaying BookingDAO
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
public interface BookingDAO {
    public void dbCreateBooking(Booking booking);
    
    public Booking dbGetBookingById(int id);
    
    public List<Booking> dbGetBookingList();
    
    public List<Booking> dbGetBookingByuser(int userId); 
    
    public void dbUpdateBooking(Booking booking);
    
    public void dbDeleteBooking(Booking booking);
}
