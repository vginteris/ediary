package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.model.Apprentice;

public interface RepApprentice extends JpaRepository<Apprentice,Long> {
}

