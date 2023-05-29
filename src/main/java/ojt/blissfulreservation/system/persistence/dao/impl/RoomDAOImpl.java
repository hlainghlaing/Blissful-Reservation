package ojt.blissfulreservation.system.persistence.dao.impl;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ojt.blissfulreservation.system.persistence.dao.RoomDAO;
import ojt.blissfulreservation.system.persistence.entity.Room;

/**
 * <h2>RoomDAOImpl Class</h2>
 * <p>
 * Process for Displaying RoomDAOImpl
 * </p>
 * 
 * @author MiMiSoe
 *
 */
@SuppressWarnings("deprecation")
@Repository
@Transactional
public class RoomDAOImpl implements RoomDAO {
    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <h2>SELECT_HOTEL_AND_ROOMS</h2>
     * <p>
     * SELECT_HOTEL_AND_ROOMS
     * </p>
     */
    private static final String SELECT_HOTEL_AND_ROOMS = "SELECT r FROM Room r JOIN r.hotel h";

    /**
     * <h2>SELECT_ROOM_BY_ID_HQL</h2>
     * <p>
     * SELECT_ROOM_BY_ID_HQL
     * </p>
     */
    public static final String SELECT_ROOM_BY_ID_HQL = "FROM Room r WHERE r.roomId = :id ";

    /**
     * <h2>dbSave</h2>
     * <p>
     * 
     * </p>
     * 
     * @param room
     */
    @Override
    public void dbSave(Room room) {
        this.sessionFactory.getCurrentSession().save(room);
    }

    /**
     * <h2>dbGetRoomList</h2>
     * <p>
     * 
     * </p>
     * 
     * @param hotelId
     * @return List<Room>
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Room> dbGetRoomList(int hotelId) {
        String hql = "FROM Room WHERE hotelId = :hotelId";
        Query<Room> query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("hotelId", hotelId);
        List<Room> roomList = query.list();
        return roomList;
    }

    /**
     * <h2>dbDelete</h2>
     * <p>
     * 
     * </p>
     * 
     * @param room
     */
    @Override
    public void dbDelete(Room room) {
        this.sessionFactory.getCurrentSession().update(room);
    }

    /**
     * <h2>dbGetById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param id
     * @return Room
     */
    @SuppressWarnings("unchecked")
    @Override
    public Room dbGetById(int id) {
        Query<Room> queryPetById = this.sessionFactory.getCurrentSession().createQuery(SELECT_ROOM_BY_ID_HQL);
        queryPetById.setParameter("id", id);
        Room room = queryPetById.uniqueResult();
        return room;
    }

    /**
     * <h2>dbGetHotelsAndRoomList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return List<Room>
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Room> dbGetHotelsAndRoomList() {
        Query<Room> query = this.sessionFactory.getCurrentSession().createQuery(SELECT_HOTEL_AND_ROOMS);
        List<Room> roomList = query.list();
        return roomList;
    }

    /**
     * <h2>dbUpdate</h2>
     * <p>
     * 
     * </p>
     * 
     * @param room
     */
    @Override
    public void dbUpdate(Room room) {
        this.sessionFactory.getCurrentSession().update(room);
    }
}
