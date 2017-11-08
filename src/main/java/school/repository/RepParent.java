package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import school.model.Parent;

public interface RepParent extends JpaRepository<Parent, Long> {
    Parent getParentByParentName(String parentName);
}
