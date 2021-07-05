package calculator;

import calculator.parser.ArgsParser;
import calculator.parser.CalculatorStringParser;
import calculator.parser.CorrectionParser;
import calculator.parser.MistakeParser;

public class Main {

    public static void main(String[] args) {
        String quest = "9 + 3 + 3 + 9 / 3 + 2 - 10 + 4 * 4 + 1";
        final ArgsParser parser = new CorrectionParser(new MistakeParser());
        final CalculatorStringParser calculatorStringParser = new CalculatorStringParser(parser);
        final Calculator calculator = new Calculator(calculatorStringParser);
        System.out.print(quest);
        calculator.calculate(quest);
    }
}
