package calculator.operation;

public abstract class ArithmeticFirstOperation implements Operation {

    protected final Operation arg1;
    protected final Operation arg2;

    public ArithmeticFirstOperation(Number arg1, Number arg2) {
        this(new ConstOperation(arg1), new ConstOperation(arg2));
    }

    public ArithmeticFirstOperation(Operation arg1, Number arg2) {
        this(arg1, new ConstOperation(arg2));
    }

    public ArithmeticFirstOperation(Operation arg1, Operation arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }
}
