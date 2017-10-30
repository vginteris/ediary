package school.service;

import school.model.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getAllUserRoles();
    void addNewUserRole(UserRole userRole);
    void updateUserRole(UserRole userRole);
    void deleteUserRoleById(long id);
    UserRole getUserRoleByName(String username);
    long addnewclass(UserRole userRole);
    UserRole getUserRoleByID(long id);
}
