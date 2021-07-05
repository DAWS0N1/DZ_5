package calculator.operation;

public abstract class ArithmeticSecondOperation implements Operation {

    protected final Operation arg1;
    protected final Operation arg2;

    public ArithmeticSecondOperation(Number arg1, Number arg2) {
        this(new ConstOperation(arg1), new ConstOperation(arg2));
    }

    public ArithmeticSecondOperation(Operation arg1, Number arg2) {
        this(arg1, new ConstOperation(arg2));
    }

    public ArithmeticSecondOperation(Operation arg1, Operation arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    protected Number addNumber(Number a, Number b) {
        if (a instanceof Double || b instanceof Double)
            return a.doubleValue() + b.doubleValue();
        else if (a instanceof Float || b instanceof Float)
            return a.floatValue() + b.floatValue();
        else if (a instanceof Long || b instanceof Long)
            return a.longValue() + b.longValue();
        else
            return a.intValue() + b.intValue();
    }
}
