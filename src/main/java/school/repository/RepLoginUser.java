package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.model.LoginUser;

public interface RepLoginUser extends JpaRepository<LoginUser,Long> {
    LoginUser findByUsername(String username);
}
