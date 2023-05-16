package ojt.blissfulreservation.system.persistence.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ojt.blissfulreservation.system.persistence.dao.UserDAO;
import ojt.blissfulreservation.system.persistence.entity.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    /**
     * <h2>sessionFactory</h2>
     * <p>
     * sessionFactory
     * </p>
     */
    @Autowired
    SessionFactory sessionFactory;

    /**
     * <h2>dbSave</h2>
     * <p>
     * 
     * </p>
     * 
     * @param user
     */

    /**
     * <h2>SELECT_User_HQL</h2>
     * <p>
     * SELECT_User_HQL
     * </p>
     */
    private static final String SELECT_User_HQL = "FROM User u";

    /**
     * <h2>SELECT_User_BY_ID_HQL</h2>
     * <p>
     * SELECT_User_BY_ID_HQL
     * </p>
     */
    public static final String SELECT_User_BY_ID_HQL = "FROM User u WHERE u.userId = :id ";

    /**
     * <h2>SELECT_User_BY_EMAIL_HQL</h2>
     * <p>
     * SELECT_User_BY_EMAIL_HQL
     * </p>
     */
    public static final String SELECT_User_BY_EMAIL_HQL = "FROM User u WHERE u.email = :email ";

    /**
     * <h2> SELECT_User_BY_PHONE_HQL</h2>
     * <p>
     * SELECT_User_BY_PHONE_HQL
     * </p>
     */
    public static final String SELECT_User_BY_PHONE_HQL = "FROM User u WHERE u.phoneNo = :phoneNo ";

    /**
     * <h2>dbSave</h2>
     * <p>
     * 
     * </p>
     * 
     * @param user
     */
    @Override
    public void dbSave(User user) {
        this.sessionFactory.getCurrentSession().save(user);
        JOptionPane.showInternalMessageDialog(null, "Success");
    }

    /**
     * <h2>dbGetById</h2>
     * <p>
     * 
     * </p>
     * 
     * @param id
     * @return User
     */
    @Override
    public User dbGetById(int id) {
        Query<User> query = this.sessionFactory.getCurrentSession().createQuery(SELECT_User_BY_ID_HQL);
        query.setParameter("id", id);
        User user = query.uniqueResult();
        return user;
    }

    /**
     * <h2>dbFindByEmail</h2>
     * <p>
     * 
     * </p>
     * 
     * @param email
     * @return User
     */
    @Override
    public User dbFindByEmail(String email) {
        Query<User> query = this.sessionFactory.getCurrentSession().createQuery(SELECT_User_BY_EMAIL_HQL);
        query.setParameter("email", email);
        return query.uniqueResult();
    }

    /**
     * <h2> dbFindUserByPhoneNo </h2>
     * <p>
     * 
     * </p>
     * 
     * @param phoneNo
     * @return User
     */
    @Override
    public User dbFindUserByPhoneNo(String phoneNo) {
        Query<User> query = this.sessionFactory.getCurrentSession().createQuery(SELECT_User_BY_PHONE_HQL);
        query.setParameter("phoneNo", phoneNo);
        return query.uniqueResult();
    }

    /**
     * <h2>dbGetList</h2>
     * <p>
     * Read UserList
     * </p>
     * 
     * @return List<User>
     */
    @Override
    public List<User> dbGetList() {
        Query<User> query = this.sessionFactory.getCurrentSession().createQuery(SELECT_User_HQL);
        List<User> userList = query.list();
        return userList;
    }

    /**
     * <h2>dbUpdate</h2>
     * <p>
     * Update User
     * </p>
     * 
     * @param user
     */
    @Override
    public void dbUpdate(User user) {
        this.sessionFactory.getCurrentSession().update(user);
    }

    /**
     * <h2>dbDelete</h2>
     * <p>
     * 
     * </p>
     * 
     * @param user
     */
    @Override
    public void dbDelete(User user) {
        this.sessionFactory.getCurrentSession().update(user);
    }
}
