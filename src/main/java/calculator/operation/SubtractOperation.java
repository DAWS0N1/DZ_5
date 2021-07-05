package calculator.operation;

public class SubtractOperation extends ArithmeticSecondOperation {
    public SubtractOperation(Number arg1, Number arg2) {
        super(new ConstOperation(arg1), new ConstOperation(arg2));
    }

    public SubtractOperation(Operation arg1, Number arg2) {
        super(arg1, new ConstOperation(arg2));
    }

    public SubtractOperation(Operation arg1, Operation arg2) {
        super(arg1, arg2);
    }

    @Override
    public Number operate() {
        return addNumber(arg1.operate(), negate(arg2.operate()));
    }

    private Number negate(Number a) {
        if (a instanceof Double)
            return -a.doubleValue();
        else if (a instanceof Float)
            return -a.floatValue();
        else if (a instanceof Long)
            return -a.longValue();
        else
            return -a.intValue();
    }
}
