package services;

import org.junit.Assert;
import org.junit.Test;
import services.implementation.SumServiceImpl;

public class SumServiceTests {
    @Test
    public void sumTest() {
        int a = 2;
        int b = 2;
        SumService sumService = new SumServiceImpl();
        Assert.assertEquals(sumService.sum(a, b), 4);
    }
}
