package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.model.UserRole;

public interface RepUserRole extends JpaRepository<UserRole,Long> {
}
