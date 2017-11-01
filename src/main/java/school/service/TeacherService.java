package school.service;

import school.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeacher();
    void addNewTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacherById(long id);
    Teacher getTeacherByName(String name);
    long addNewTeacherAndReturnId(Teacher teacher);
    Teacher getTeacherById(long id);
}
