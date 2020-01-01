package rootpackage;

public class SutClass {

    private final Calculator calculator;

    public SutClass(Calculator calculator) {
        this.calculator = calculator;
    }

    public int calculate(int num1, int num2) {
        return calculator.doVeryComplicatedCalculations(num1, num2);
    }
}
