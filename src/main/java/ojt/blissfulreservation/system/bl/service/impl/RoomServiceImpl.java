package ojt.blissfulreservation.system.bl.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ojt.blissfulreservation.system.bl.service.RoomService;
import ojt.blissfulreservation.system.persistence.dao.RoomDAO;
import ojt.blissfulreservation.system.persistence.entity.Room;
import ojt.blissfulreservation.system.web.form.RoomForm;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDAO roomDao;

    @Override
    public List<RoomForm> doGetRoomList(int id) {
        List<Room> roomList = roomDao.dbGetRoomList(id);
        List<RoomForm> roomFormList = new ArrayList<>();
        for (Room room : roomList) {
            RoomForm roomForm = new RoomForm(room);
            roomFormList.add(roomForm);
        }
        return roomFormList;
    }

    @Override
    public void doDelete(RoomForm roomForm) {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure to delete?");
        if (option == JOptionPane.YES_OPTION) {
            roomForm.setDeleteAt(LocalDateTime.now());
            Room room = new Room(roomForm);
            roomDao.dbDelete(room);
        }
    }

    @Override
    public RoomForm doGetById(int id) {
        RoomForm roomForm = new RoomForm(roomDao.dbGetById(id));
        return roomForm;
    }

    @Override
    public List<RoomForm> doGetHotelAndRoomList() {
        List<Room> roomList = roomDao.dbGetHotelsAndRoomList();
        List<RoomForm> roomFormList = new ArrayList<>();
        for (Room room : roomList) {
            RoomForm roomForm = new RoomForm(room);
            roomFormList.add(roomForm);
        }
        return roomFormList;
    }

    @Override
    public void doSave(RoomForm roomForm, MultipartFile roomImg) throws IOException {
        roomForm.setCreatedAt(LocalDateTime.now());
        Room room = new Room(roomForm);
        String fileName = StringUtils.cleanPath(roomImg.getOriginalFilename());
        room.setRoomImg(fileName);
        roomDao.dbSave(room);

        String uploadDir = "D:\\EclipseWorkspace_BIB_OJT07\\Blissful_Reservation\\"
                + "src\\main\\webapp\\resources\\img\\hotel-images\\";
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        File serverFile = new File(uploadDir + fileName);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(roomImg.getBytes());
        stream.close();
    }

    @Override
    public void doUpdate(RoomForm roomForm) {
        roomForm.setUpdatedAt(LocalDateTime.now());
        Room room = new Room(roomForm);
        roomDao.dbUpdate(room);
    }
}
