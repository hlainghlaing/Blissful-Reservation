package ojt.blissfulreservation.system.bl.service;

import java.util.List;

import ojt.blissfulreservation.system.web.form.UserForm;

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
    /**
     * <h2> doSave</h2>
     * <p>
     * 
     * </p>
     *
     * @param user
     * @return void
     */
    public void doSave(UserForm user);

    /**
     * <h2> doGetById</h2>
     * <p>
     * 
     * </p>
     *
     * @param id
     * @return
     * @return UserForm
     */
    public UserForm doGetById(int id);

    /**
     * <h2> doFindByEmail</h2>
     * <p>
     * 
     * </p>
     *
     * @param email
     * @return
     * @return UserForm
     */
    public UserForm doFindByEmail(String email);

    /**
     * <h2> doFindUserByPhoneNo</h2>
     * <p>
     * 
     * </p>
     *
     * @param phoneNo
     * @return
     * @return UserForm
     */
    public UserForm doFindUserByPhoneNo(String phoneNo);

    /**
     * <h2> doGetList</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return List<UserForm>
     */
    public List<UserForm> doGetList();

    /**
     * <h2> doUpdate</h2>
     * <p>
     * 
     * </p>
     *
     * @param user
     * @return void
     */
    public void doUpdate(UserForm user);

    /**
     * <h2> doDelete</h2>
     * <p>
     * 
     * </p>
     *
     * @param user
     * @return void
     */
    public void doDelete(UserForm user);
}
