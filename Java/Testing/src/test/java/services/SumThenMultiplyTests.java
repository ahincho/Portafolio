package services;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mockito;
import services.implementation.SumServiceImpl;
import services.implementation.SumThenMultiplyServiceImpl;

public class SumThenMultiplyTests {
    @Test
    public void multiplyTest() {
        SumThenMultiplyService sumThenMultiplyService = new SumThenMultiplyServiceImpl();
        assertEquals(sumThenMultiplyService.multiply(2, 3), 6);
    }
    @Test
    public void sumThenMultiplyTest() {
        SumService sumService = new SumServiceImpl();
        SumThenMultiplyService sumThenMultiplyService = new SumThenMultiplyServiceImpl();
        sumThenMultiplyService.setSumService(sumService);
        assertEquals(sumThenMultiplyService.sumThenMultiply(2, 3, 2), 10);
    }
}
