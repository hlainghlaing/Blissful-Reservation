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
    /**
     * <h2> dbSave</h2>
     * <p>
     * 
     * </p>
     *
     * @param user
     * @return void
     */
    public void dbSave(User user);

    /**
     * <h2> dbGetById</h2>
     * <p>
     * 
     * </p>
     *
     * @param id
     * @return
     * @return User
     */
    public User dbGetById(int id);
    
    /**
     * <h2> dbFindByEmail</h2>
     * <p>
     * 
     * </p>
     *
     * @param email
     * @return
     * @return User
     */
    public User dbFindByEmail(String email);
    
    /**
     * <h2> dbFindUserByPhoneNo</h2>
     * <p>
     * 
     * </p>
     *
     * @param PhoneNo
     * @return
     * @return User
     */
    public User dbFindUserByPhoneNo(String PhoneNo);

    /**
     * <h2> dbGetList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<User>
     */
    public List<User> dbGetList();

    /**
     * <h2> dbUpdate</h2>
     * <p>
     * 
     * </p>
     *
     * @param user
     * @return void
     */
    public void dbUpdate(User user);

    /**
     * <h2> dbDelete</h2>
     * <p>
     * 
     * </p>
     *
     * @param user
     * @return void
     */
    public void dbDelete(User user);
}
