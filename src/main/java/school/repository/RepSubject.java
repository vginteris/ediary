package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.model.SchoolSubject;

public interface RepSubject extends JpaRepository<SchoolSubject, Long> {
    SchoolSubject getSchoolSubjectBySubjectName(String subjectName);
}
