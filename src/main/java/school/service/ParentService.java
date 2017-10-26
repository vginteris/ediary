package school.service;

import school.model.Parent;

import java.util.List;

public interface ParentService {
    List<Parent> getAllParent();
    void addNewParent(Parent parent);
    void updateParent(Parent parent);
    void deleteParentById(long id);
}
