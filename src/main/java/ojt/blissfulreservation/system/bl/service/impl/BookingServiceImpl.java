package ojt.blissfulreservation.system.bl.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ojt.blissfulreservation.system.bl.service.BookingService;
import ojt.blissfulreservation.system.persistence.dao.BookingDAO;
import ojt.blissfulreservation.system.persistence.entity.Booking;
import ojt.blissfulreservation.system.web.form.BookingForm;

/**
 * <h2>BookingServiceImpl Class</h2>
 * <p>
 * Process for Displaying BookingServiceImpl
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    /**
     * <h2>bookingDao</h2>
     * <p>
     * bookingDao
     * </p>
     */
    @Autowired
    private BookingDAO bookingDao;

    /**
     * <h2>doCreateBooking</h2>
     * <p>
     * 
     * </p>
     * 
     * @param bookingForm
     */
    @Override
    public void doCreateBooking(BookingForm bookingForm) {
        bookingForm.setStatus(1);
        bookingForm.setCreatedAt(LocalDateTime.now());
        Booking booking = new Booking(bookingForm);
        this.bookingDao.dbCreateBooking(booking);
    }

    /**
     * <h2>doGetBookingList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return List<BookingForm>
     */
    @Override
    public List<BookingForm> doGetBookingList() {
        List<Booking> bList = bookingDao.dbGetBookingList();
        List<BookingForm> bFormList = new ArrayList<>();
        for (Booking b : bList) {
            BookingForm bForm = new BookingForm(b);
            if (bForm.getStatus() == 1) {
                bFormList.add(bForm);
            }
            bFormList.add(bForm);
        }
        return bFormList;
    }

    /**
     * <h2>doGetBookingByuser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userId
     * @return List<BookingForm>
     */
    @Override
    public List<BookingForm> doGetBookingByuser(int userId) {
        List<Booking> bList = bookingDao.dbGetBookingByuser(userId);
        List<BookingForm> bFormList = new ArrayList<>();
        for (Booking b : bList) {
            BookingForm bForm = new BookingForm(b);
            bFormList.add(bForm);
        }
        return bFormList;
    }

    /**
     * <h2>doUpdateBooking</h2>
     * <p>
     * 
     * </p>
     * 
     * @param bookingForm
     */
    @Override
    public void doUpdateBooking(BookingForm bookingForm) {
        bookingForm.setUpdatedAt(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate sdate = LocalDate.parse(bookingForm.getCheckIn(), formatter);
        LocalDate edate = LocalDate.parse(bookingForm.getCheckOut(), formatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        bookingForm.setCheckIn(sdate.format(outputFormatter));
        bookingForm.setCheckOut(edate.format(outputFormatter));
        Booking booking = new Booking(bookingForm);
        bookingDao.dbUpdateBooking(booking);
    }

    /**
     * <h2>doDeleteBooking</h2>
     * <p>
     * 
     * </p>
     * 
     * @param bookingForm
     */
    @Override
    public void doDeleteBooking(BookingForm bookingForm) {
        bookingForm.setDeletedAt(LocalDateTime.now());
        Booking booking = new Booking(bookingForm);
        bookingDao.dbDeleteBooking(booking);
    }

    /**
     * <h2>doGetBookingById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param id
     * @return BookingForm
     */
    @Override
    public BookingForm doGetBookingById(int id) {
        Booking booking = bookingDao.dbGetBookingById(id);
        BookingForm bookingForm = new BookingForm(booking);
        return bookingForm;
    }
}
