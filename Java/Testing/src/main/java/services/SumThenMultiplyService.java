package services;

public interface SumThenMultiplyService {
    SumService getSumService();
    void setSumService(SumService sumService);
    int multiply(int a, int b);
    int sumThenMultiply(int a, int b, int multiplier);
}
