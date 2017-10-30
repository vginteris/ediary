package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.model.Parent;

public interface RepParent extends JpaRepository<Parent, Long> {
    Parent getParentByParentName(String parentName);
}
