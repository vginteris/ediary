package school.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ediary_schoolclass")
public class SchoolClass {
    private long schoolClassid;
    private String className;
    private List<Apprentice> apprenticeList;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getSchoolClassid() {
        return schoolClassid;
    }

    public void setSchoolClassid(long schoolClassid) {
        this.schoolClassid = schoolClassid;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @OneToMany(mappedBy = "schoolClass")
    public List<Apprentice> getApprenticeList() {
        return apprenticeList;
    }

    public void setApprenticeList(List<Apprentice> apprenticeList) {
        this.apprenticeList = apprenticeList;
    }
}
