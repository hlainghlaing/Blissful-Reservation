package ojt.blissfulreservation.system.bl.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ojt.blissfulreservation.system.web.form.RoomForm;

/**
 * <h2> RoomService Class</h2>
 * <p>
 * Process for Displaying RoomService
 * </p>
 * 
 * @author MiMiSoe
 *
 */
public interface RoomService {
    public void doSave(RoomForm room, MultipartFile image) throws IOException;

    public List<RoomForm> doGetRoomList(int id);

    public void doDelete(RoomForm roomForm);

    public RoomForm doGetById(int id);

    public void doUpdate(RoomForm room, MultipartFile image) throws IOException;

    public List<RoomForm> doGetHotelAndRoomList();
}
