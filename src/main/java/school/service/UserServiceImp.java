package school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import school.model.LoginUser;
import school.model.UserRole;
import school.repository.RepLoginUser;
import school.repository.RepUserRole;

import java.util.HashSet;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    RepLoginUser repLoginUser;
    @Autowired
    RepUserRole repUserRole;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void insertNewUser(LoginUser loginUser) {
        loginUser.setPassword(bCryptPasswordEncoder.encode(loginUser.getPassword()));
        loginUser.setUserRole(loginUser.getUserRole());
        repLoginUser.save(loginUser);
    }

    @Override
    public LoginUser findByUsername(String username) {
        return repLoginUser.findByUsername(username);
    }

    @Override
    public long insertNewUserAndGetID(LoginUser loginUser) {
        loginUser.setPassword(bCryptPasswordEncoder.encode(loginUser.getPassword()));
        loginUser.setUserRole(loginUser.getUserRole());
        loginUser = repLoginUser.saveAndFlush(loginUser);
        return loginUser.getUserid();
    }
}
