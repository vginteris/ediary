package school.model;

import javax.persistence.*;

@Entity
@Table(name = "ediary_login_user")
public class LoginUser {
    private long userId;
    private String username;
    private String password;
    private String passwordComfirm;
    private UserRole userRole;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Transient
    public String getPasswordComfirm() {
        return passwordComfirm;
    }

    public void setPasswordComfirm(String passwordComfirm) {
        this.passwordComfirm = passwordComfirm;
    }

    @ManyToOne
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
