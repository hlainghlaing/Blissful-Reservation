package ojt.blissfulreservation.system.web.form;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

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

    private int userId;

    @NotEmpty
    private String userName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String roleType;

    @NotEmpty
    private String phoneNo;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

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
}
