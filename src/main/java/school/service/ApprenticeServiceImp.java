package school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.model.Apprentice;
import school.repository.RepApprentice;

import java.util.List;

@Service
public class ApprenticeServiceImp implements ApprenticeService {
    @Autowired
    RepApprentice repApprentice;

    @Override
    public List<Apprentice> getAllAprentice() {
        return repApprentice.findAll();
    }

    @Override
    public void addNewApprentice(Apprentice apprentice) {
            repApprentice.save(apprentice);
    }

    @Override
    public void updateApprentice(Apprentice apprentice) {
        repApprentice.save(apprentice);
    }

    @Override
    public void deleteApprenticeById(long id) {
        repApprentice.delete(id);
    }

    @Override
    public Apprentice getApprenticeByID(long id) {
        return repApprentice.getOne(id);
    }

    @Override
    public List<Apprentice> getApprenticeWithoutClass() {
        return repApprentice.getApprenticesBySchoolClass(null);
    }
}
