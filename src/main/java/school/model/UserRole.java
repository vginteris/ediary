package school.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ediary_user_role")
public class UserRole {
    private long roleid;
    private String roleName;
    private List<LoginUser> loginUsers;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getRoleid() {
        return roleid;
    }

    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }



    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    @OneToMany(mappedBy = "userRole")
    public List<LoginUser> getLoginUsers() {
        return loginUsers;
    }

    public void setLoginUsers(List<LoginUser> loginUsers) {
        this.loginUsers = loginUsers;
    }
}
