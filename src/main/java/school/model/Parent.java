package school.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ediary_parent")
public class Parent {
    private long parentid;
    private long personalCode;
    private String parentName;
    private String parentSurname;
    private String parentPhone;
    private String parentEmail;
    private String parentAddress;
    private List<Apprentice> parentChildrenList;
    private LoginUser loginUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getParentid() {
        return parentid;
    }

    public void setParentid(long parentid) {
        this.parentid = parentid;
    }

    public long getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(long personalCode) {
        this.personalCode = personalCode;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentSurname() {
        return parentSurname;
    }

    public void setParentSurname(String parentSurname) {
        this.parentSurname = parentSurname;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public String getParentAddress() {
        return parentAddress;
    }

    public void setParentAddress(String parentAddress) {
        this.parentAddress = parentAddress;
    }

    @OneToMany(mappedBy = "apprentieParent")
    @Column(columnDefinition="default null")
    public List<Apprentice> getParentChildrenList() {
        return parentChildrenList;
    }

    public void setParentChildrenList(List<Apprentice> parentChildrenList) {
        this.parentChildrenList = parentChildrenList;
    }

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "userid")
    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }
}
