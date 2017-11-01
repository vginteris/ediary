package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.model.Teacher;

public interface RepTeacher extends JpaRepository<Teacher,Long>{
    Teacher getTeacherByTeacherName(String teacherName);
}
