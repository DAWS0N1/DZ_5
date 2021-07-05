package calculator.parser;

public class CorrectionParser implements ArgsParser {

    private ArgsParser argsParser;

    public CorrectionParser() {
    }

    public CorrectionParser(ArgsParser argsParser) {
        this.argsParser = argsParser;
    }

    @Override
    public String[] parse(String args) {
        return args.split("\\s");
    }
}
