package school.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApprenticeTest {

    Apprentice apprentice;

    @Before
    public void setUp(){
        apprentice = new Apprentice();
    }
    @Test
    public void getApprenticeid() throws Exception {
        long tempId = 4L;
        apprentice.setApprenticeid(tempId);
        assertEquals(4L, apprentice.getApprenticeid());
    }

    @Test
    public void getPersonalCode() throws Exception {
    }

    @Test
    public void getApprenticeName() throws Exception {
    }

    @Test
    public void getApprenticeSurname() throws Exception {
    }

}