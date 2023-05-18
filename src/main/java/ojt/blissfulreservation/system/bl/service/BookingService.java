package ojt.blissfulreservation.system.bl.service;

import java.util.List;


import ojt.blissfulreservation.system.web.form.BookingForm;

/**
 * <h2>BookingService Class</h2>
 * <p>
 * Process for Displaying BookingService
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
public interface BookingService {
    public void doCreateBooking(BookingForm bookingForm);
    
    public BookingForm doGetBookingById(int id);

    public List<BookingForm> doGetBookingList();

    public List<BookingForm> doGetBookingByuser(int userId);
    
    public void doUpdateBooking(BookingForm bookingForm);
    
    public void doDeleteBooking(BookingForm bookingForm);
}
