package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import school.model.Apprentice;
import school.model.Parent;
import school.model.SchoolClass;

import java.util.List;

public interface RepApprentice extends JpaRepository<Apprentice,Long> {
    String getApprenticeByApprenticeName(String name);
    List<Apprentice> getApprenticesBySchoolClass(SchoolClass schoolClass);
    @Modifying
    @Query
            ("update Apprentice apr set apr.apprenticeName = :apprenticeName , apr.apprenticeSurname = :apprenticeSurname, apr.personalCode = :personalCode where apr.apprenticeid = :apprenticeid")
    @Transactional
    void updateApprenticeNameSurnameAndCode(@Param("apprenticeName") String apprenticeName, @Param("apprenticeSurname") String apprenticeSurname, @Param("personalCode") long personalCode, @Param("apprenticeid") long apprenticeid);
    @Modifying
    @Query
            ("update Apprentice apr set apr.apprentieParent = :parent where apr.apprenticeid= :apprenticeid")
    @Transactional
    void updateApprenticeParent(@Param("parent")Parent parent, @Param("apprenticeid") long apprenticeid);

    @Modifying
    @Query
            ("update Apprentice apr set apr.apprentieParent = null where apr.apprentieParent= :parent")
    @Transactional
    void updateApprenticeParentSetNull(@Param("parent")Parent parent);

}

