package school.service;

import school.model.Apprentice;
import school.model.Parent;

import java.util.List;

public interface ApprenticeService {
    List<Apprentice> getAllAprentice();
    void addNewApprentice(Apprentice apprentice);
    void updateApprentice(Apprentice apprentice);
    void deleteApprenticeById(long id);
    Apprentice getApprenticeByID(Long id);
    List<Apprentice> getApprenticeWithoutClass();
    void addNewApprenticeFromCSV(List<Apprentice> apprenticeList);
    void updateApprenticeNameSurnameAndCode(String name, String surname, long personalCode, long apprenticeid);
    void updateApprenticeParent(Parent parent, long apprenticeid);
    void setNullWhenDeleteParent(Parent parent);
    List<Apprentice> getApprenticesByApprentieParent(Parent parent);
}
