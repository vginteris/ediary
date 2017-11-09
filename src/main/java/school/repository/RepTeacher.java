package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import school.model.Apprentice;
import school.model.Teacher;

public interface RepTeacher extends JpaRepository<Teacher,Long>{
    Teacher getTeacherByTeacherName(String teacherName);
    Teacher getTeacherByTeacherid(long teacherid);
    @Modifying
    @Query
            ("update Teacher teach set teach.personalCode = :personalCode, teach.teacherName = :teacherName, teach.teacherSurname = :teacherSurname" +
                    ",teach.teacherPhone = :teacherPhone, teach.teacherEmail = :teacherEmail where teach.teacherid = :teacherid")
    @Transactional
    void updateJustTeacher(@Param("personalCode") long personalCode, @Param("teacherName") String teacherName, @Param("teacherSurname") String teacherSurname
            , @Param("teacherPhone") String teacherPhone, @Param("teacherEmail") String teacherEmail, @Param("teacherid") long teacherid);



}
