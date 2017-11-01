package school.service;

import school.model.LoginUser;

import java.util.List;

public interface UserService  {
    void insertNewUser(LoginUser loginUser);
    LoginUser findByUsername(String username);
    long insertNewUserAndGetID(LoginUser loginUser);
    List<LoginUser> getAllUser();
}
