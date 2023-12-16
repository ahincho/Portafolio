package services.implementation;

import services.SumService;
import services.SumThenMultiplyService;

public class SumThenMultiplyServiceImpl implements SumThenMultiplyService {
    private SumService sumService;
    @Override
    public SumService getSumService() {
        return this.sumService;
    }
    @Override
    public void setSumService(SumService sumService) {
        this.sumService = sumService;
    }
    @Override
    public int multiply(int a, int b) {
        return a * b;
    }
    @Override
    public int sumThenMultiply(int a, int b, int multiplier) {
        return this.sumService.sum(a, b) * multiplier;
    }
}
