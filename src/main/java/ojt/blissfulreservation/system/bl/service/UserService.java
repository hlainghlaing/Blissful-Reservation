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
    public void doSave(UserForm user);

    public UserForm doGetById(int id);

    public UserForm doFindByEmail(String email);

    public UserForm doFindUserByPhoneNo(String phoneNo);

    public List<UserForm> doGetList();

    public void doUpdate(UserForm user);

    public void doDelete(UserForm user);
}
