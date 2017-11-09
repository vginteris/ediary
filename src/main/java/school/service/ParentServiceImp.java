package school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.model.Parent;
import school.repository.RepParent;

import java.util.List;

@Service
public class ParentServiceImp implements ParentService {
    @Autowired
    RepParent repParent;

    @Override
    public List<Parent> getAllParent() {
        return repParent.findAll();
    }

    @Override
    public void addNewParent(Parent parent) {
        repParent.save(parent);
    }

    @Override
    public void updateParent(Parent parent) {
    }

    @Override
    public void deleteParentById(long id) {
        repParent.delete(id);
    }

    @Override
    public Parent getParentByName(String name) {
        return repParent.getParentByParentName(name);
    }

    @Override
    public long addNewParentAndReturnId(Parent parent) {
        parent = repParent.saveAndFlush(parent);
        return parent.getParentid();
    }

    @Override
    public Parent getParentById(long id) {
        return repParent.findOne(id);
    }

    @Override
    public Parent addNewParentAndReturnParent(Parent parent) {
        return addNewParentAndReturnParent(parent);
    }

    @Override
    public void updateJustParent(Parent parent) {
        repParent.updateJustParentInformation(parent.getParentName(),parent.getParentSurname(),
                parent.getPersonalCode(),parent.getParentPhone(),parent.getParentEmail(),
                parent.getParentAddress(),parent.getParentid());
    }
}
