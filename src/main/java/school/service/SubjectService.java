package school.service;

import school.model.SchoolSubject;

import java.util.List;

public interface SubjectService {
    List<SchoolSubject> getAllSubject();
    void addNewSubject(SchoolSubject subject);
    void updateSubject(SchoolSubject subject);
    void deleteSubjectById(long id);
    SchoolSubject getSubjectByName(String name);
    long addNewSubjectAndReturnId(SchoolSubject subject);
    SchoolSubject getSubjectById(long id);
    List<SchoolSubject> getALlUniqueSubject();
    void updateSubjectNameAndType(String subjectName,String subjectType, long subjectid);
}
