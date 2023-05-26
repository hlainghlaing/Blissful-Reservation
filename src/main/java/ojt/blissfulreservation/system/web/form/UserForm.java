package ojt.blissfulreservation.system.web.form;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.Size;

//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.blissfulreservation.system.persistence.entity.User;

/**
 * <h2>UserForm Class</h2>
 * <p>
 * Process for Displaying UserForm
 * </p>
 * 
 * @author KhinYadanarHlaing
 *
 */
@NoArgsConstructor
@Setter
@Getter
public class UserForm {
    /**
     * <h2> userId</h2>
     * <p>
     * userId
     * </p>
     */
    private int userId;

    /**
     * <h2> userName</h2>
     * <p>
     * userName
     * </p>
     */
    @NotEmpty
    private String userName;

    /**
     * <h2> email</h2>
     * <p>
     * email
     * </p>
     */
    @NotEmpty
    @Email
    private String email;

    /**
     * <h2> password</h2>
     * <p>
     * password
     * </p>
     */
    @NotEmpty
    @Size(min = 6)
    private String password;

    /**
     * <h2> roleType</h2>
     * <p>
     * roleType
     * </p>
     */
    @NotEmpty
    private String roleType;

    /**
     * <h2> phoneNo</h2>
     * <p>
     * phoneNo
     * </p>
     */
    @NotEmpty
    private String phoneNo;

    /**
     * <h2> createdAt</h2>
     * <p>
     * createdAt
     * </p>
     */
    private LocalDateTime createdAt;

    /**
     * <h2> updatedAt</h2>
     * <p>
     * updatedAt
     * </p>
     */
    private LocalDateTime updatedAt;

    /**
     * <h2> deletedAt</h2>
     * <p>
     * deletedAt
     * </p>
     */
    private LocalDateTime deletedAt;

    /**
     * <h2>Constructor for UserForm</h2>
     * <p>
     * Constructor for UserForm
     * </p>
     * 
     * @param user
     */
    public UserForm(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roleType = user.getRoleType();
        this.phoneNo = user.getPhoneNo();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.deletedAt = user.getDeletedAt();
    }

    /**
     * <h2>STATUS_MAP</h2>
     * <p>
     * STATUS_MAP
     * </p>
     */
    private static final Map<String, String> STATUS_MAP = new HashMap<String, String>() {
        /**
         * <h2> serialVersionUID</h2>
         * <p>
         * serialVersionUID
         * </p>
         */
        private static final long serialVersionUID = -3682600126044830108L;

        {
            put("0", "Admin");
            put("1", "User");
        }
    };

    /**
     * <h2>getRoleType2</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    public String getRoleType2() {
        return STATUS_MAP.get(roleType);
    }
    
    /**
     * <h2> formatter</h2>
     * <p>
     * formatter
     * </p>
     */
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    /**
     * <h2> getFormattedCT</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    public String getFormattedCT() {
        if (createdAt != null) {
            return createdAt.format(formatter);
        }
        return null;
    }
    
    /**
     * <h2> getFormattedUT</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    public String getFormattedUT() {
        if (updatedAt != null) {
            return updatedAt.format(formatter);
        }
        return null;
    }
    
    /**
     * <h2> getFormattedDT</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    public String getFormattedDT() {
        if (deletedAt != null) {
            return deletedAt.format(formatter);
        }
        return null;
    }
}
