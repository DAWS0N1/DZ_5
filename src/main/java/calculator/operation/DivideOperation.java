package calculator.operation;

public class DivideOperation extends ArithmeticFirstOperation{
    public DivideOperation(Number arg1, Number arg2) {
        super(new ConstOperation(arg1), new ConstOperation(arg2));
    }

    public DivideOperation(Operation arg1, Number arg2) {
        super(arg1, new ConstOperation(arg2));
    }

    public DivideOperation(Operation arg1, Operation arg2) {
        super(arg1, arg2);
    }

    @Override
    public Number operate() {
        return addNumber(arg1.operate(), arg2.operate());
    }

    private Number addNumber(Number a, Number b) {
        if (a instanceof Double || b instanceof Double)
            return a.doubleValue() / b.doubleValue();
        else if (a instanceof Float || b instanceof Float)
            return a.floatValue() / b.floatValue();
        else if (a instanceof Long || b instanceof Long)
            return a.longValue() / b.longValue();
        else
            return a.intValue() / b.intValue();
    }
}
