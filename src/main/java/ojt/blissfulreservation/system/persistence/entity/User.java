package ojt.blissfulreservation.system.persistence.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2> User Class</h2>
 * <p>
 * Process for Displaying User
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    /**
     * <h2> userId</h2>
     * <p>
     * userId
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    
    /**
     * <h2> userName</h2>
     * <p>
     * userName
     * </p>
     */
    @Column(name = "user_name", nullable = false)
    private String userName;
    
    /**
     * <h2> email</h2>
     * <p>
     * email
     * </p>
     */
    @Column(name = "email", nullable = false)
    private String email;
    
    /**
     * <h2> password</h2>
     * <p>
     * password
     * </p>
     */
    @Column(name = "password", nullable = false)
    private String password;
    
    /**
     * <h2> roleType</h2>
     * <p>
     * roleType
     * </p>
     */
    @Column(name = "type", nullable = false)
    private String roleType;
    
    /**
     * <h2> phoneNo</h2>
     * <p>
     * phoneNo
     * </p>
     */
    @Column(name = "phone_no", nullable = false)
    private String phoneNo;
    
    /**
     * <h2> createdAt</h2>
     * <p>
     * createdAt
     * </p>
     */
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    
    /**
     * <h2> updatedAt</h2>
     * <p>
     * updatedAt
     * </p>
     */
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
    
    /**
     * <h2> deleteAt</h2>
     * <p>
     * deleteAt
     * </p>
     */
    @Column(name = "deleted_at", nullable = false)
    private Date deleteAt;
}
