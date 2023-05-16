package ojt.blissfulreservation.system.persistence.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.blissfulreservation.system.persistence.dao.BookingDAO;
import ojt.blissfulreservation.system.persistence.entity.Booking;

/**
 * <h2>BookingDAOImpl Class</h2>
 * <p>
 * Process for Displaying BookingDAOImpl
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
@Repository
public class BookingDAOImpl implements BookingDAO {
    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    SessionFactory sessionFactory;

    /**
     * <h2>SELECT_Booking_HQL</h2>
     * <p>
     * SELECT_Booking_HQL
     * </p>
     */
    private static final String SELECT_Booking_HQL = "SELECT b FROM Booking b JOIN b.user u JOIN b.room r";

    /**
     * <h2>SELECT_Booking_BY_User_HQL</h2>
     * <p>
     * SELECT_Booking_BY_User_HQL
     * </p>
     */
    private static final String SELECT_Booking_BY_User_HQL = "SELECT b FROM bookings b WHERE b.userId = :userId";

    /**
     * <h2>dbCreateBooking</h2>
     * <p>
     * 
     * </p>
     * 
     * @param booking
     */
    @Override
    public void dbCreateBooking(Booking booking) {
        this.sessionFactory.getCurrentSession().save(booking);
    }

    /**
     * <h2>dbGetBookingList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return List<Booking>
     */
    @Override
    public List<Booking> dbGetBookingList() {
        Query<Booking> query = this.sessionFactory.getCurrentSession().createQuery(SELECT_Booking_HQL);
        List<Booking> bookingList = query.list();
        return bookingList;
    }

    /**
     * <h2>dbGetBookingByuser</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userId
     * @return List<Booking>
     */
    @Override
    public List<Booking> dbGetBookingByuser(int userId) {
        Query<Booking> query = this.sessionFactory.getCurrentSession().createQuery(SELECT_Booking_BY_User_HQL);
        query.setParameter("userId", userId);
        List<Booking> bookingList = query.list();
        return bookingList;
    }

    /**
     * <h2> dbUpdateBooking </h2>
     * <p>
     * 
     * </p>
     * 
     * @param booking
     */
    @Override
    public void dbUpdateBooking(Booking booking) {
        this.sessionFactory.getCurrentSession().update(booking);
    }

    /**
     * <h2> dbDeleteBooking </h2>
     * <p>
     * 
     * </p>
     * 
     * @param booking
     */
    @Override
    public void dbDeleteBooking(Booking booking) {
        this.sessionFactory.getCurrentSession().update(booking);
    }

}
