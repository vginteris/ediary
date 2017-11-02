package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.model.SchoolClass;

public interface RepSchoolClass extends JpaRepository<SchoolClass, Long> {
    SchoolClass getSchoolClassByClassName(String className);
    int countByClassName(String className);
//    Boolean countSchoolClassBy
}
