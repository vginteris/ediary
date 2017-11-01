package school.service;

import school.model.Apprentice;

import java.util.List;

public interface ApprenticeService {
    List<Apprentice> getAllAprentice();
    void addNewApprentice(Apprentice apprentice);
    void updateApprentice(Apprentice apprentice);
    void deleteApprenticeById(long id);
    Apprentice getApprenticeByID(long id);
    List<Apprentice> getApprenticeWithoutClass();
}
