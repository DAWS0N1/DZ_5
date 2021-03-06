package calculator;

import calculator.operation.Operation;
import calculator.parser.CalculatorStringParser;

public class Calculator {

    private final static String START_RESULT_STRING = " = ";

    private final CalculatorStringParser calculatorStringParser;

    public Calculator(CalculatorStringParser calculatorStringParser) {
        this.calculatorStringParser = calculatorStringParser;
    }

    public int calculate(String calcArgs) {
        try {
            final Operation operation = calculatorStringParser.parse(calcArgs);
            System.out.println(START_RESULT_STRING + operation.operate());
        } catch (ArithmeticException e) {
            System.err.println("Нельзя делить на ноль!");
            return -1;
        } catch (NumberFormatException e) {
            System.err.println("Вместо числа введен некорректный символ!");
            return -1;
        }
        return 1;
    }
}
