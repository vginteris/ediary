package school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.model.UserRole;
import school.repository.RepUserRole;

import java.util.List;

@Service
public class UserRoleServiceImp implements UserRoleService {
    @Autowired
    RepUserRole repUserRole;
    @Override
    public List<UserRole> getAllUserRoles() {
        return repUserRole.findAll();
    }

    @Override
    public void addNewUserRole(UserRole userRole) {

    }

    @Override
    public void updateUserRole(UserRole userRole) {

    }

    @Override
    public void deleteUserRoleById(long id) {

    }

    @Override
    public UserRole getUserRoleByName(String username) {
        return null;
    }

    @Override
    public long addnewclass(UserRole userRole) {
        return 0;
    }

    @Override
    public UserRole getUserRoleByID(long id) {
        return repUserRole.getOne(id);
    }
}
