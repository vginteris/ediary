package school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.model.SchoolSubject;
import school.repository.RepSubject;

import java.util.List;

@Service
public class SubjectServiceImp implements SubjectService {
    @Autowired
    RepSubject repSubject;

    @Override
    public List<SchoolSubject> getAllSubject() {
        return repSubject.findAll();
    }

    @Override
    public void addNewSubject(SchoolSubject subject) {
        repSubject.save(subject);
    }

    @Override
    public void updateSubject(SchoolSubject subject) {
        repSubject.save(subject);
    }

    @Override
    public void deleteSubjectById(long id) {
            repSubject.delete(id);
    }

    @Override
    public SchoolSubject getSubjectByName(String name) {
        return repSubject.getSchoolSubjectBySubjectName(name);
    }

    @Override
    public long addNewSubjectAndReturnId(SchoolSubject subject) {
        subject = repSubject.saveAndFlush(subject);
        return subject.getSubjectid();
    }

    @Override
    public SchoolSubject getSubjectById(long id) {
        return repSubject.getOne(id);
    }
}
