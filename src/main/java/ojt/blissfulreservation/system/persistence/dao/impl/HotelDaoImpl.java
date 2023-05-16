package ojt.blissfulreservation.system.persistence.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.blissfulreservation.system.persistence.dao.HotelDAO;
import ojt.blissfulreservation.system.persistence.entity.Hotel;

/**
 * <h2>HotelDaoImpl Class</h2>
 * <p>
 * Process for Displaying HotelDaoImpl
 * </p>
 * 
 * @author Hnaung Thet Htar Wai
 *
 */
@SuppressWarnings("deprecation")
@Repository
public class HotelDaoImpl implements HotelDAO {

    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>SELECT_HOTEL_HQL</h2>
     * <p>
     * SELECT_HOTEL_HQL
     * </p>
     */
    private static final String SELECT_HOTEL_HQL = "FROM Hotel h";

    @Override
    public Hotel dbGetHotelById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Hotel.class, id);
    }

    /**
     * <h2>getAllHotels</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Hotel> dbGetAllHotels() {
        Session session = sessionFactory.getCurrentSession();
        Query<Hotel> query = session.createQuery(SELECT_HOTEL_HQL, Hotel.class);
        return query.getResultList();
    }

    /**
     * <h2>registerNewHotel</h2>
     * <p>
     * 
     * </p>
     * 
     * @param hotel
     */
    @Override
    public void dbRegisterNewHotel(Hotel hotel) {
        hotel.setCreatedAt(LocalDateTime.now());
        hotel.setUpdatedAt(null);
        hotel.setDeleteAt(null);
        Session session = sessionFactory.getCurrentSession();
        session.save(hotel);
    }

    /**
     * <h2>updateHotel</h2>
     * <p>
     * 
     * </p>
     * 
     * @param hotel
     */
    @Override
    public void dbUpdateHotel(Hotel hotel) {
        hotel.setUpdatedAt(LocalDateTime.now());
        hotel.setDeleteAt(null);
        Session session = sessionFactory.getCurrentSession();
        session.update(hotel);
    }

    @Override
    public void dbSaveHotel(Hotel hotel) {
        sessionFactory.getCurrentSession();
    }

    /**
     * <h2>deleteHotel</h2>
     * <p>
     * 
     * </p>
     * 
     * @param hotel
     */
    @Override
    public void dbDeleteHotel(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(hotel);
    }
}
