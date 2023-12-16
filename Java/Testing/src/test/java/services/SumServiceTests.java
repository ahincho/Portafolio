package services;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import services.implementation.SumServiceImpl;

public class SumServiceTests {
    @Test
    public void sumTest() {
        int a = 2;
        int b = 2;
        SumService sumService = new SumServiceImpl();
        assertEquals(sumService.sum(a, b), 4);
    }
}
