package services.implementation;

import services.SumService;

public class SumServiceImpl implements SumService {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
