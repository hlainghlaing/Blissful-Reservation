package ojt.blissfulreservation.system.persistence.dao;

import java.util.List;

import ojt.blissfulreservation.system.persistence.entity.Room;

/**
 * <h2>RoomDAO Class</h2>
 * <p>
 * Process for Displaying RoomDAO
 * </p>
 * 
 * @author MiMiSoe
 *
 */
public interface RoomDAO {
    /**
     * <h2> dbSave</h2>
     * <p>
     * 
     * </p>
     *
     * @param room
     * @return void
     */
    public void dbSave(Room room);

    /**
     * <h2> dbGetRoomList</h2>
     * <p>
     * 
     * </p>
     *
     * @param id
     * @return
     * @return List<Room>
     */
    public List<Room> dbGetRoomList(int id);

    /**
     * <h2> dbDelete</h2>
     * <p>
     * 
     * </p>
     *
     * @param roomForm
     * @return void
     */
    public void dbDelete(Room roomForm);

    /**
     * <h2> dbGetById</h2>
     * <p>
     * 
     * </p>
     *
     * @param id
     * @return
     * @return Room
     */
    public Room dbGetById(int id);

    /**
     * <h2> dbUpdate</h2>
     * <p>
     * 
     * </p>
     *
     * @param room
     * @return void
     */
    public void dbUpdate(Room room);

    /**
     * <h2> dbGetHotelsAndRoomList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<Room>
     */
    public List<Room> dbGetHotelsAndRoomList();
}
