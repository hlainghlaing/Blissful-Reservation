package ojt.blissfulreservation.system.web.form;

import java.time.LocalDateTime;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.blissfulreservation.system.persistence.entity.User;

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
}
