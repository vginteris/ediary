package school.service;

import school.model.LoginUser;

public interface UserService  {
    void insertNewUser(LoginUser loginUser);
    LoginUser findByUsername(String username);
    long insertNewUserAndGetID(LoginUser loginUser);
}
