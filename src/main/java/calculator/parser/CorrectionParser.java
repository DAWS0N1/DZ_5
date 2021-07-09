package calculator.parser;

public class CorrectionParser implements ArgsParser {

    public CorrectionParser() {
    }

    @Override
    public String[] parse(String args) {
        return args.split("\\s");
    }
}
