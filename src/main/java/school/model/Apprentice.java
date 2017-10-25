package school.model;

import javax.persistence.*;

@Entity
@Table(name = "ediary_apprentice")
public class Apprentice {
    private long apprenticeid;
    private String apprenticeName;
    private String apprenticeSurname;
    private SchoolClass schoolClass;
    private Parent apprentieParent;
    private LoginUser loginUser;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long getApprenticeid() {
        return apprenticeid;
    }

    public void setApprenticeid(long apprenticeid) {
        this.apprenticeid = apprenticeid;
    }

    public String getApprenticeName() {
        return apprenticeName;
    }

    public void setApprenticeName(String apprenticeName) {
        this.apprenticeName = apprenticeName;
    }

    public String getApprenticeSurname() {
        return apprenticeSurname;
    }

    public void setApprenticeSurname(String apprenticeSurname) {
        this.apprenticeSurname = apprenticeSurname;
    }

    @ManyToOne
    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
    @ManyToOne
    public Parent getApprentieParent() {
        return apprentieParent;
    }

    public void setApprentieParent(Parent apprentieParent) {
        this.apprentieParent = apprentieParent;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }
}
