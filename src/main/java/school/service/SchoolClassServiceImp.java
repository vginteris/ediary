package school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.model.SchoolClass;
import school.repository.RepSchoolClass;

import java.util.List;

@Service
public class SchoolClassServiceImp implements SchoolClassService{
    @Autowired
    RepSchoolClass repSchoolClass;
    @Override
    public List<SchoolClass> getAllSchoolClass() {
        return repSchoolClass.findAll();
    }

    @Override
    public void addNewSchoolClass(SchoolClass schoolClass) {
        repSchoolClass.save(schoolClass);
    }

    @Override
    public void updateSchoolClass(SchoolClass schoolClass) {
        repSchoolClass.save(schoolClass);
    }

    @Override
    public void deleteSchoolClasstById(long id) {
        repSchoolClass.delete(id);
    }

    @Override
    public SchoolClass getSchoolClasByName(String name) {
        return repSchoolClass.getSchoolClassByClassName(name);
    }

    @Override
    public long addnewclass(SchoolClass schoolClass) {
        schoolClass = repSchoolClass.saveAndFlush(schoolClass);
        return schoolClass.getSchoolClassid();
    }

    @Override
    public SchoolClass getSchoolClassByID(long id) {
        return repSchoolClass.getOne(id);
    }


}
