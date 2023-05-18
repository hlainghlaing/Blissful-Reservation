package ojt.blissfulreservation.system.persistence.dao;

import java.util.List;

import ojt.blissfulreservation.system.persistence.entity.User;

/**
 * <h2> UserDAO Class</h2>
 * <p>
 * Process for Displaying UserDAO
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
public interface UserDAO {
    public void dbSave(User user);

    public User dbGetById(int id);
    
    public User dbFindByEmail(String email);
    
    public User dbFindUserByPhoneNo(String PhoneNo);

    public List<User> dbGetList();

    public void dbUpdate(User user);

    public void dbDelete(User user);
}
