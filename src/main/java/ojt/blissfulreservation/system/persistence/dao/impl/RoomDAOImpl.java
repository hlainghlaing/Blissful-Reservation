package ojt.blissfulreservation.system.persistence.dao.impl;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ojt.blissfulreservation.system.persistence.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import antlr.StringUtils;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.io.BufferedOutputStream;
import ojt.blissfulreservation.system.persistence.dao.RoomDAO;
import ojt.blissfulreservation.system.persistence.entity.Room;

@Repository
@Transactional
public class RoomDAOImpl implements RoomDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final String SELECT_HOTEL_AND_ROOMS = "SELECT r FROM Room r JOIN r.hotel h";

    public static final String SELECT_ROOM_BY_ID_HQL = "FROM Room r WHERE r.roomId = :id ";

    @Override
    public void dbSave(Room room) {
        this.sessionFactory.getCurrentSession().save(room);
    }

    /**
     * Room List By Searching Hotel id
     */
    @Override
    public List<Room> dbGetRoomList(int hotelId) {
        String hql = "FROM Room WHERE hotelId = :hotelId";
        Query<Room> query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("hotelId", hotelId);
        List<Room> roomList = query.list();
        return roomList;
    }

    @Override
    public void dbDelete(Room room) {
        this.sessionFactory.getCurrentSession().update(room);
    }
    
    /**
     * Room by roomId
     */
    @Override
    public Room dbGetById(int id) {
        Query<Room> queryPetById = this.sessionFactory.getCurrentSession().createQuery(SELECT_ROOM_BY_ID_HQL);
        queryPetById.setParameter("id", id);
        Room room = queryPetById.uniqueResult();
        return room;
    }

    /**
     * all rooms by hotel info
     */
    @Override
    public List<Room> dbGetHotelsAndRoomList() {
        Query<Room> query = this.sessionFactory.getCurrentSession().createQuery(SELECT_HOTEL_AND_ROOMS);
        List<Room> roomList = query.list();
        return roomList;
    }

    @Override
    public void dbUpdate(Room room) {
       this.sessionFactory.getCurrentSession().update(room);
    }
}
