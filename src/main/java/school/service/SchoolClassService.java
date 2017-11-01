package school.service;


import school.model.SchoolClass;

import java.util.List;

public interface SchoolClassService {
    List<SchoolClass> getAllSchoolClass();
    void addNewSchoolClass(SchoolClass schoolClass);
    void updateSchoolClass(SchoolClass schoolClass);
    void deleteSchoolClasstById(long id);
    SchoolClass getSchoolClasByName(String name);
    long addNewClassAndReturnId(SchoolClass schoolClass);
    SchoolClass getSchoolClassByID(long id);
}
