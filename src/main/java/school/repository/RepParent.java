package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import school.model.Parent;

public interface RepParent extends JpaRepository<Parent, Long> {
    Parent getParentByParentName(String parentName);
    @Modifying
    @Query
            ("update Parent par set par.parentName = :parentName , par.parentSurname = :parentSurname, par.personalCode = :personalCode, par.parentPhone = :parentPhone" +
                    ", par.parentEmail = :parentEmail, par.parentAddress = :parentAddress where par.parentid = :parentid")
    @Transactional
    void updateJustParentInformation(@Param("parentName") String parentName, @Param("parentSurname") String parentSurname, @Param("personalCode") long personalCode
            , @Param("parentPhone") String parentPhone, @Param("parentEmail") String parentEmail, @Param("parentAddress") String parentAddress,@Param("parentid") long parentid);
}
