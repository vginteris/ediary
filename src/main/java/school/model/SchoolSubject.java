package school.model;

import javax.persistence.*;

@Entity
@Table(name = "ediary_subjectschool")
public class SchoolSubject {
    private long subjectid;
    private String subjectName;
    private String subjectType;
    private Teacher teacher;

    public SchoolSubject() {
    }

    public SchoolSubject(String subjectName, Teacher teacher) {
        this.subjectName = subjectName;
        this.teacher = teacher;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(long subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    @ManyToOne
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
