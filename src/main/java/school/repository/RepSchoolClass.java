package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.model.SchoolClass;

public interface RepSchoolClass extends JpaRepository<SchoolClass, Long> {
}
