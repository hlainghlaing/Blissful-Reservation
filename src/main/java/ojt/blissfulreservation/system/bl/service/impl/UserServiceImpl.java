package ojt.blissfulreservation.system.bl.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ojt.blissfulreservation.system.bl.service.UserService;
import ojt.blissfulreservation.system.persistence.dao.UserDAO;
import ojt.blissfulreservation.system.persistence.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;

    @Override
    public void doSave(User user) {
        this.userDao.dbSave(user);
    }

    @Override
    public User doGetById(int id) {
        return userDao.dbGetById(id);
    }

    @Override
    public List<User> doGetList() {
        return userDao.dbGetList();
    }

    @Override
    public void doUpdate(User user) {
        userDao.dbUpdate(user);
    }

    @Override
    public void doDelete(User user) {
        userDao.dbDelete(user);
    }

}
