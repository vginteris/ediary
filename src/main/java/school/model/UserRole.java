package school.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ediary_user_role")
public class UserRole {
    private long roleId;
    private String roleName;
    private List<LoginUser> loginUsers;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
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
