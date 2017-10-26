package school.model;

import javax.persistence.*;

@Entity
@Table(name = "ediary_subjectschool")
public class SchoolSubject {
    private long subjectid;
    private String subjectName;
    private Teacher teacher;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @ManyToOne
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
