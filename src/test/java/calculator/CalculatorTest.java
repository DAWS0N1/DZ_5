package calculator;

import calculator.operation.*;
import calculator.parser.ArgsParser;
import calculator.parser.CalculatorStringParser;
import calculator.parser.CorrectionParser;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void subtractOperationTest() {
        Number subtractOperation = new SubtractOperation(12, 7).operate();
        Assert.assertEquals("Неправильно посчитана разность", 5, subtractOperation);
    }

    @Test
    public void divideOperationTest() {
        Number divideOperation = new DivideOperation(27, 3).operate();
        Assert.assertEquals("Неправильно посчитано частное", 9, divideOperation);
    }

    @Test
    public void divideOperationTestByZero() {
        final ArgsParser parser = new CorrectionParser();
        final CalculatorStringParser calculatorStringParser = new CalculatorStringParser(parser);
        final Calculator calculator = new Calculator(calculatorStringParser);
        Assert.assertEquals("Получен неверный результат", -1, calculator.calculate("9 / 0"));
        Assert.assertEquals("Получен неверный результат", 1, calculator.calculate("9 / 3"));
    }

    @Test
    public void sumOperationTest() {
        Number sumOperation = new SumOperation(27, 3).operate();
        Assert.assertEquals("Неправильно посчитана сумма", 30, sumOperation);
    }

    @Test
    public void multiplyOperationTest() {
        Number multiplyOperation = new MultiplyOperation(7, 8).operate();
        Assert.assertEquals("Неправильно посчитано частное", 56, multiplyOperation);
    }

    @Test
    public void testForCorrectCalculating() {
        final ArgsParser parser = new CorrectionParser();
        final CalculatorStringParser calculatorStringParser = new CalculatorStringParser(parser);
        final Calculator calculator = new Calculator(calculatorStringParser);
        Number result = calculatorStringParser.parse("9 + 3 + 3 + 9 / 3 + 2 - 10 + 4 * 4 + 1 - 3 + 2.7 * 3").operate();
        Assert.assertEquals("Неправильно посчитано уравнение", 32.1d, result);
    }

    @Test
    public void testForCorrectInputSymbols() {
        final ArgsParser parser = new CorrectionParser();
        final CalculatorStringParser calculatorStringParser = new CalculatorStringParser(parser);
        final Calculator calculator = new Calculator(calculatorStringParser);
        Assert.assertEquals("Получен неверный результат", -1, calculator.calculate("F / 0"));
        Assert.assertEquals("Получен неверный результат", -1, calculator.calculate("3 * ."));
        Assert.assertEquals("Получен неверный результат", -1, calculator.calculate("3 - \""));
        Assert.assertEquals("Получен неверный результат", 1, calculator.calculate("9 + 3"));
    }
}
