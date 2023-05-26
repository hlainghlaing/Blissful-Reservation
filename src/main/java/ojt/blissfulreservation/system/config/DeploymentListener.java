package ojt.blissfulreservation.system.config;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ojt.blissfulreservation.system.persistence.dao.UserDAO;
import ojt.blissfulreservation.system.persistence.entity.User;

@Component
public class DeploymentListener {
    /**
     * <h2>passwordEncoder</h2>
     * <p>
     * passwordEncoder
     * </p>
     */
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * <h2>userDao</h2>
     * <p>
     * userDao
     * </p>
     */
    @Autowired
    private UserDAO userDao;

    @PostConstruct
    public void addInitialData() {
        if (this.userDao.dbGetList().size() <= 0) {
            User admin = new User();
            admin.setEmail("mimisoe968@gmail.com");
            admin.setPassword(passwordEncoder.encode("mimi#968"));
            admin.setPhoneNo("09-795373770");
            admin.setRoleType("0");
            admin.setUserName("Mi Mi Soe");
            admin.setCreatedAt(LocalDateTime.now());
            this.userDao.dbSave(admin);
        } else {
            System.out.println("User already exits.");
        }
    }
}
