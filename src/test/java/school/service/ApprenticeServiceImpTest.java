package school.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import school.model.Apprentice;
import school.repository.RepApprentice;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApprenticeServiceImpTest {
    ApprenticeServiceImp apprenticeService;

    @Mock
    RepApprentice repApprentice;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        apprenticeService = new ApprenticeServiceImp(repApprentice);
    }

    @Test
    public void getAllAprenticeAndReturnNull() throws Exception {
        List<Apprentice> getAllAprentic = apprenticeService.getAllAprentice();
        assertEquals(getAllAprentic.size(),0);
    }

    @Test
    public void getAllAprenticeAndReturnOne()throws Exception {
        Apprentice apprentice = new Apprentice();
        List<Apprentice> apprenticeList = new ArrayList<>();
        apprenticeList.add(apprentice);

        when(apprenticeService.getAllAprentice()).thenReturn(apprenticeList);
        List<Apprentice> getAllAprrentice = apprenticeService.getAllAprentice();
        assertEquals(getAllAprrentice.size(),1);
    }

    @Test
    public void getAllAprenticeAndReturnOneMockito()throws Exception {
        Apprentice apprentice = new Apprentice();
        List<Apprentice> apprenticeList = new ArrayList<>();
        apprenticeList.add(apprentice);

        when(apprenticeService.getAllAprentice()).thenReturn(apprenticeList);
        List<Apprentice> getAllAprrentice = apprenticeService.getAllAprentice();
        verify(repApprentice, times(1)).findAll();
    }
    



}