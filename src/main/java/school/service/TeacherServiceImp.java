package school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.model.Teacher;
import school.repository.RepSubject;
import school.repository.RepTeacher;

import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    RepTeacher repTeacher;
    @Autowired
    RepSubject repSubject;

    @Override
    public List<Teacher> getAllTeacher() {
        return repTeacher.findAll();
    }

    @Override
    public void addNewTeacher(Teacher teacher) {
        repTeacher.save(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        repTeacher.save(teacher);
    }

    @Override
    public void deleteTeacherById(long id) {
        repTeacher.delete(id);
    }

    @Override
    public long addNewTeacherAndReturnId(Teacher teacher) {
        teacher = repTeacher.saveAndFlush(teacher);
        return teacher.getTeacherid();
    }

    @Override
    public void updateJustTeacher(Teacher teacher) {
        repTeacher.updateJustTeacher(teacher.getPersonalCode(),teacher.getTeacherName(),teacher.getTeacherSurname(),teacher.getTeacherPhone(),teacher.getTeacherEmail(),teacher.getTeacherid());
    }

}
