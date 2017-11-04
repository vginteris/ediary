package school.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ediary_teacher")
public class Teacher {
    private long teacherid;
    private String teacherName;
    private String teacherSurname;
    private String teacherPhone;
    private String teacherEmail;
    private List<SchoolSubject> subjects;
    private SchoolClass schoolClass;
    private LoginUser loginUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(long teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "teacher")
    public List<SchoolSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SchoolSubject> subjects) {
        this.subjects = subjects;
    }

    @OneToOne
    @JoinColumn(name = "schoolClassid")
    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
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
