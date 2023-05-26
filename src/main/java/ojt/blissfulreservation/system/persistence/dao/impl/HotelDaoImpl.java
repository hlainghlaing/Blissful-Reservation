package ojt.blissfulreservation.system.persistence.dao.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.blissfulreservation.system.persistence.dao.HotelDAO;
import ojt.blissfulreservation.system.persistence.entity.Hotel;
import ojt.blissfulreservation.system.persistence.entity.Room;

/**
 * <h2>HotelDaoImpl Class</h2>
 * <p>
 * Process for Displaying HotelDaoImpl
 * </p>
 * 
 * @author HnaungThetHtarWai
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
     * <h2> SELECT_CITY_HQL</h2>
     * <p>
     * SELECT_CITY_HQL
     * </p>
     */
    private static final String SELECT_CITY_HQL = "SELECT DISTINCT h.city FROM Hotel h";
    
    /**
     * <h2> SELECT_HOTEL_BY_CITY</h2>
     * <p>
     * SELECT_HOTEL_BY_CITY
     * </p>
     */
    private static final String SELECT_HOTEL_BY_CITY = "SELECT h FROM Hotel h WHERE h.city = :city";
    
    /**
     * <h2>SELECT_HOTEL_HQL</h2>
     * <p>
     * SELECT_HOTEL_HQL
     * </p>
     */
    private static final String SELECT_HOTEL_HQL = "FROM Hotel h";

    /**
     * <h2>SELECT_HOTEL_BY_PHONE_HQL</h2>
     * <p>
     * SELECT_HOTEL_BY_PHONE_HQL
     * </p>
     */
    public static final String SELECT_HOTEL_BY_PHONE_HQL = "FROM Hotel h WHERE h.phone = :phone ";

    /**
     * <h2> dbGetHotelById </h2>
     * <p>
     * 
     * </p>
     * 
     * @param id
     * @return Hotel
     */
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
        Session session = sessionFactory.getCurrentSession();
        session.update(hotel);
    }

    /**
     * <h2>dbSaveHotel</h2>
     * <p>
     * 
     * </p>
     * 
     * @param hotel
     */
    @Override
    public void dbSaveHotel(Hotel hotel) {
        hotel.setCreatedAt(LocalDateTime.now());
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(hotel);
    }

    /**
     * <h2>dbFindUserByPhoneNo</h2>
     * <p>
     * 
     * </p>
     * 
     * @param phone
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public Hotel dbFindHotelByPhoneNo(String phone) {
        Query<Hotel> query = this.sessionFactory.getCurrentSession().createQuery(SELECT_HOTEL_BY_PHONE_HQL);
        query.setParameter("phone", phone);
        return query.uniqueResult();
    }

    /**
     * <h2>dbDeleteHotel</h2>
     * <p>
     * 
     * </p>
     * 
     * @param hotel
     */
    @Override
    public void dbDeleteHotel(Hotel hotel) {
        this.sessionFactory.getCurrentSession().update(hotel);
    }
    
    /**
     * <h2> dbGetCities </h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<String> dbGetCities() {
        Query<String> query = sessionFactory.getCurrentSession().createQuery(SELECT_CITY_HQL);
        List<String> cities = query.getResultList();
        return cities;

    }
    
    /**
     * <h2> dbGetHotels </h2>
     * <p>
     * 
     * </p>
     * 
     * @param city
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Hotel> dbGetHotels(String city) {
        Query<Hotel> query = sessionFactory.getCurrentSession().createQuery(SELECT_HOTEL_BY_CITY);
        query.setParameter("city", city);
        List<Hotel> hotelList = query.getResultList();
        return hotelList;
    }
    
    /**
     * <h2> dbGetRoomsForHotel </h2>
     * <p>
     * 
     * </p>
     * 
     * @param hotelId
     * @return
     */
    @Override
    public List<Room> dbGetRoomsForHotel(int hotelId) {
        Session session = sessionFactory.getCurrentSession();
        Hotel hotel = session.get(Hotel.class, hotelId);
        if (hotel != null) {
            return new ArrayList<>(hotel.getRooms());
        }
        return Collections.emptyList();
    }
}
