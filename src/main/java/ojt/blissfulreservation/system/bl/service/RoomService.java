package ojt.blissfulreservation.system.bl.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ojt.blissfulreservation.system.web.form.RoomForm;

/**
 * <h2>RoomService Class</h2>
 * <p>
 * Process for Displaying RoomService
 * </p>
 * 
 * @author MiMiSoe
 *
 */
public interface RoomService {
    /**
     * <h2>doSave</h2>
     * <p>
     * 
     * </p>
     *
     * @param room
     * @param image
     * @throws IOException
     * @return void
     */
    public void doSave(RoomForm room, MultipartFile image) throws IOException;

    /**
     * <h2>doGetRoomList</h2>
     * <p>
     * 
     * </p>
     *
     * @param id
     * @return
     * @return List<RoomForm>
     */
    public List<RoomForm> doGetRoomList(int id);

    /**
     * <h2>doDelete</h2>
     * <p>
     * 
     * </p>
     *
     * @param roomForm
     * @return void
     */
    public void doDelete(RoomForm roomForm);

    /**
     * <h2>doGetById</h2>
     * <p>
     * 
     * </p>
     *
     * @param id
     * @return
     * @return RoomForm
     */
    public RoomForm doGetById(int id);

    /**
     * <h2>doUpdate</h2>
     * <p>
     * 
     * </p>
     *
     * @param room
     * @param image
     * @throws IOException
     * @return void
     */
    public void doUpdate(RoomForm room, MultipartFile image) throws IOException;

    /**
     * <h2>doGetHotelAndRoomList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<RoomForm>
     */
    public List<RoomForm> doGetHotelAndRoomList();
}
