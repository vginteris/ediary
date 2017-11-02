package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.model.SchoolSubject;
import school.model.Teacher;

import java.util.List;

public interface RepSubject extends JpaRepository<SchoolSubject, Long> {
    SchoolSubject getSchoolSubjectBySubjectName(String subjectName);
//    @Query("SELECT DISTINCT sub.subjectName from SchoolSubject sub")
//    List<SchoolSubject> findDistinctBySubjectName();
}
