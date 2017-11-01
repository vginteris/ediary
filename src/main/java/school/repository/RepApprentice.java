package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.model.Apprentice;
import school.model.SchoolClass;

import java.util.List;

public interface RepApprentice extends JpaRepository<Apprentice,Long> {
    String getApprenticeByApprenticeName(String name);
    List<Apprentice> getApprenticesBySchoolClass(SchoolClass schoolClass);


}

