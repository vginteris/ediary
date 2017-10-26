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
        repParent.save(parent);
    }

    @Override
    public void deleteParentById(long id) {
        repParent.delete(id);
    }
}
