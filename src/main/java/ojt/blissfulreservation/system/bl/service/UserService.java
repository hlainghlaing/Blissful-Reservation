package ojt.blissfulreservation.system.bl.service;

import java.util.List;

import ojt.blissfulreservation.system.persistence.entity.User;

/**
 * <h2>UserService Class</h2>
 * <p>
 * Process for Displaying UserService
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
public interface UserService {
    public void doSave(User user);

    public User doGetById(int id);

    public User doFindByEmail(String email);

    public List<User> doGetList();

    public void doUpdate(User user);

    public void doDelete(User user);
    
}
