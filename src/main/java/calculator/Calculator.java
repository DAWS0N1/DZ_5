package calculator;

import calculator.operation.Operation;
import calculator.parser.CalculatorStringParser;

public class Calculator {

    private final static String START_RESULT_STRING = " = ";

    private CalculatorStringParser calculatorStringParser;

    public Calculator(CalculatorStringParser calculatorStringParser) {
        this.calculatorStringParser = calculatorStringParser;
    }

    public void calculate(String calcArgs) {
        final Operation operation = calculatorStringParser.parse(calcArgs);
        System.out.println(START_RESULT_STRING + operation.operate());
    }
}