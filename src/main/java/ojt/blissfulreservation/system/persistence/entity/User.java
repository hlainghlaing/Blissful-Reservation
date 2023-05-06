package ojt.blissfulreservation.system.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>User Class</h2>
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
     * <h2>userId</h2>
     * <p>
     * userId
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "INT(4) ZEROFILL")
    private int userId;

    /**
     * <h2>userName</h2>
     * <p>
     * userName
     * </p>
     */
    @Column(name = "user_name", nullable = false, length = 45)
    private String userName;

    /**
     * <h2>email</h2>
     * <p>
     * email
     * </p>
     */
    @Column(name = "email", nullable = false, length = 45, unique = true)
    private String email;

    /**
     * <h2>password</h2>
     * <p>
     * password
     * </p>
     */
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    /**
     * <h2>roleType</h2>
     * <p>
     * roleType
     * </p>
     */
    @Column(name = "type", nullable = false, length = 1)
    private String roleType;

    /**
     * <h2>phoneNo</h2>
     * <p>
     * phoneNo
     * </p>
     */
    @Column(name = "phone_no", nullable = false, length = 20, unique = true)
    private String phoneNo;

    /**
     * <h2>createdAt</h2>
     * <p>
     * createdAt
     * </p>
     */
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /**
     * <h2>updatedAt</h2>
     * <p>
     * updatedAt
     * </p>
     */
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * <h2>deleteAt</h2>
     * <p>
     * deleteAt
     * </p>
     */
    @Column(name = "deleted_at")
    private LocalDateTime deleteAt;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();
}
