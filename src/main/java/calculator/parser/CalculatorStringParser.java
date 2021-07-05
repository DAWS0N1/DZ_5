package calculator.parser;

import calculator.operation.*;

import java.util.ArrayList;
import java.util.List;

public class CalculatorStringParser {

    private final ArgsParser parser;

    public CalculatorStringParser(ArgsParser parser) {
        this.parser = parser;
    }

    public Operation parse(String args) {
        final String[] parserArgs = parser.parse(args);
        List<String> secondArgs = new ArrayList<>();
        firstQueue(parserArgs, secondArgs);
        final Number firstNumber = convertToNumber(secondArgs.get(0));
        Operation result = new ConstOperation(firstNumber);

        for (int i = 1; i < secondArgs.size(); i += 2) {
            String arg = secondArgs.get(i);
            if (isOperation(arg)) {
                final Number nextNumber = convertToNumber(secondArgs.get(i + 1));
                if (arg.equals("+"))
                    result = new SumOperation(result, nextNumber);
                else if (arg.equals("-"))
                    result = new SubtractOperation(result, nextNumber);
            } else
                throw new RuntimeException("Некорректный массив");
        }
        return result;
    }

    private boolean isOperation(String arg) {
        return arg.equals("*") || arg.equals("/") || arg.equals("+") || arg.equals("-");
    }

    private Number convertToNumber(String arg) {
        Number result;
        if (arg.contains("."))
            result = Double.valueOf(arg);
        else
            result = Long.valueOf(arg);
        return result;
    }

    private void firstQueue(String[] parserArgs, List<String> secondArgs) {
        for (int i = 1; i < parserArgs.length; i += 2) {
            String arg = parserArgs[i];
            if (isOperation(arg)) {
                final Number prevNumber = convertToNumber(parserArgs[i - 1]);
                final Number nextNumber = convertToNumber(parserArgs[i + 1]);
                if (arg.equals("*"))
                    secondArgs.add(String.valueOf(new MultiplyOperation(prevNumber, nextNumber).operate()));
                else if (arg.equals("/"))
                    secondArgs.add(String.valueOf(new DivideOperation(prevNumber, nextNumber).operate()));
                if (i > 2) {
                    String prevArg = parserArgs[i - 2];
                    if ((arg.equals("+") || arg.equals("-")) && !(prevArg.equals("*") || prevArg.equals("/"))) {
                        secondArgs.add(String.valueOf(prevNumber));
                        secondArgs.add(arg);
                    } else if ((arg.equals("+") || arg.equals("-")) && (prevArg.equals("*") || prevArg.equals("/"))) {
                        secondArgs.add(arg);
                    }
                } else {
                    if (arg.equals("+") || arg.equals("-"))
                        secondArgs.add(String.valueOf(prevNumber));
                    secondArgs.add(arg);
                }
            } else
                throw new RuntimeException("Некорректный массив");
        }

        if (parserArgs[parserArgs.length - 2].equals("+") || parserArgs[parserArgs.length - 2].equals("-"))
            secondArgs.add(parserArgs[parserArgs.length - 1]);

    }
}
