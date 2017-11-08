package school.service;

import school.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeacher();
    void addNewTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacherById(long id);
    long addNewTeacherAndReturnId(Teacher teacher);
    void updateJustTeacher(Teacher teacher);
}
