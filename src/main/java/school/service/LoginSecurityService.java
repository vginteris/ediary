package school.service;

public interface LoginSecurityService {
    String findLoginUsername();
    void login(String username, String password);
}
