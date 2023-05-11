package ojt.blissfulreservation.system.bl.service.impl;

import java.util.Collection;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ojt.blissfulreservation.system.bl.service.UserService;
import ojt.blissfulreservation.system.persistence.dao.UserDAO;
import ojt.blissfulreservation.system.persistence.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {
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
    public User doFindByEmail(String email) {
        return userDao.dbFindByEmail(email);
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
//        String role = user.getRoleType().equals("0") ? "ADMIN" : "USER";
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

}
