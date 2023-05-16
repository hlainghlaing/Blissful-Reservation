package ojt.blissfulreservation.system.bl.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ojt.blissfulreservation.system.bl.service.UserService;
import ojt.blissfulreservation.system.persistence.dao.UserDAO;
import ojt.blissfulreservation.system.persistence.entity.User;
import ojt.blissfulreservation.system.web.form.UserForm;

/**
 * <h2>UserServiceImpl Class</h2>
 * <p>
 * Process for Displaying UserServiceImpl
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {
    /**
     * <h2>userDao</h2>
     * <p>
     * userDao
     * </p>
     */
    @Autowired
    private UserDAO userDao;

    /**
     * <h2>passwordEncoder</h2>
     * <p>
     * passwordEncoder
     * </p>
     */
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * <h2>doSave</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userForm
     */
    @Override
    public void doSave(UserForm userForm) {
        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userForm.setRoleType("1");
        userForm.setCreatedAt(LocalDateTime.now());
        User user = new User(userForm);
        this.userDao.dbSave(user);
    }

    /**
     * <h2>doGetById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param id
     * @return UserForm
     */
    @Override
    public UserForm doGetById(int id) {
        UserForm userForm = new UserForm(userDao.dbGetById(id));
        return userForm;
    }

    /**
     * <h2>doFindByEmail</h2>
     * <p>
     * 
     * </p>
     * 
     * @param email
     * @return UserForm
     */
    @Override
    public UserForm doFindByEmail(String email) {
        User user = userDao.dbFindByEmail(email);
        if (user != null) {
            UserForm userForm = new UserForm(user);
            return userForm;
        }
        return null;
    }

    /**
     * <h2>doFindUserByPhoneNo</h2>
     * <p>
     * 
     * </p>
     * 
     * @param phoneNo
     * @return UserForm
     */
    @Override
    public UserForm doFindUserByPhoneNo(String phoneNo) {
        User user = userDao.dbFindUserByPhoneNo(phoneNo);
        if (user != null) {
            UserForm userForm = new UserForm(user);
            return userForm;
        }
        return null;
    }

    /**
     * <h2>doGetList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return List<UserForm>
     */
    @Override
    public List<UserForm> doGetList() {
        List<User> userList = userDao.dbGetList();
        List<UserForm> userFormList = new ArrayList<>();
        for (User user : userList) {
            UserForm userForm = new UserForm(user);
            userFormList.add(userForm);
        }
        return userFormList;
    }

    /**
     * <h2>doUpdate</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userForm
     */
    @Override
    public void doUpdate(UserForm userForm) {
        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userForm.setUpdatedAt(LocalDateTime.now());
        User user = new User(userForm);
        userDao.dbUpdate(user);
    }

    /**
     * <h2>doDelete</h2>
     * <p>
     * 
     * </p>
     * 
     * @param userForm
     */
    @Override
    public void doDelete(UserForm userForm) {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?");
        if (option == JOptionPane.YES_OPTION) {
            userForm.setDeletedAt(LocalDateTime.now());
            User user = new User(userForm);
            userDao.dbDelete(user);
        }
    }

    /**
     * <h2>loadUserByUsername</h2>
     * <p>
     * 
     * </p>
     * 
     * @param email
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.dbFindByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        Map<String, String> roles = new HashMap<>();
        roles.put("ADMIN", "0");
        roles.put("USER", "1");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles.keySet()) {
            if (user.getRoleType().equals(roles.get(role))) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
