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
    /**
     * <h2> doCreateBooking</h2>
     * <p>
     * 
     * </p>
     *
     * @param bookingForm
     * @return void
     */
    public void doCreateBooking(BookingForm bookingForm);
    
    /**
     * <h2> doGetBookingById</h2>
     * <p>
     * 
     * </p>
     *
     * @param id
     * @return
     * @return BookingForm
     */
    public BookingForm doGetBookingById(int id);

    /**
     * <h2> doGetBookingList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<BookingForm>
     */
    public List<BookingForm> doGetBookingList();

    /**
     * <h2> doGetBookingByuser</h2>
     * <p>
     * 
     * </p>
     *
     * @param userId
     * @return
     * @return List<BookingForm>
     */
    public List<BookingForm> doGetBookingByuser(int userId);
    
    /**
     * <h2> doUpdateBooking</h2>
     * <p>
     * 
     * </p>
     *
     * @param bookingForm
     * @return void
     */
    public void doUpdateBooking(BookingForm bookingForm);
    
    /**
     * <h2> doDeleteBooking</h2>
     * <p>
     * 
     * </p>
     *
     * @param bookingForm
     * @return void
     */
    public void doDeleteBooking(BookingForm bookingForm);
}
