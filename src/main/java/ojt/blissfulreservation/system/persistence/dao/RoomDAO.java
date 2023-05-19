package ojt.blissfulreservation.system.persistence.dao;

import java.util.List;

import ojt.blissfulreservation.system.persistence.entity.Room;
import ojt.blissfulreservation.system.web.form.RoomForm;

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

    public void dbSave(Room room);

    public List<Room> dbGetRoomList(int id);

    public void dbDelete(Room roomForm);

    public Room dbGetById(int id);

    public void dbUpdate(Room room);

    public List<Room> dbGetHotelsAndRoomList();
}
