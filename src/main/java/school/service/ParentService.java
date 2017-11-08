package school.service;

import school.model.Parent;

import java.util.List;

public interface ParentService {
    List<Parent> getAllParent();
    void addNewParent(Parent parent);
    void updateParent(Parent parent);
    void deleteParentById(long id);
    Parent getParentByName(String name);
    long addNewParentAndReturnId(Parent parent);
    Parent getParentById(long id);
    Parent addNewParentAndReturnParent(Parent parent);
}
