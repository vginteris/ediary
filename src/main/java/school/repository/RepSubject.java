package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;
import org.springframework.transaction.annotation.Transactional;
import school.model.SchoolSubject;
import school.model.Teacher;

import java.util.List;

public interface RepSubject extends JpaRepository<SchoolSubject, Long> {
    SchoolSubject getSchoolSubjectBySubjectName(String subjectName);

    //    @Query("SELECT DISTINCT sub.subjectName from SchoolSubject sub")
//    List<SchoolSubject> findDistinctBySubjectName();
    @Modifying
    @Query
            ("update SchoolSubject sub set sub.subjectName = :subjectName , sub.subjectType = :subjectType where sub.subjectid= :subjectid")
   @Transactional
    void updateSubjectNameAndType(@Param("subjectName") String subjectName, @Param("subjectType") String subjectType, @Param("subjectid") long subjectid);

    @Modifying
    @Query
            ("update SchoolSubject subject set subject.teacher = :teacher where subject.subjectid = :subjectid")
    @Transactional
    void updateSubjectTeacher(@Param("teacher") Teacher teacher, @Param("subjectid") long subjectid);
}
