package calculator.parser;

public class MistakeParser implements ArgsParser {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHABET_RUS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    private ArgsParser argsParser;

    public MistakeParser() {
    }

    public MistakeParser(ArgsParser argsParser) {
        this.argsParser = argsParser;
    }

    @Override
    public String[] parse(String calcArgs) {
        final String joining = String.join("", calcArgs);
        for (String arg : joining.split("")) {
            if (ALPHABET.contains(arg) || ALPHABET_RUS.contains(arg)) {
                throw new RuntimeException("Недопустимый символ " + arg);
            }
        }
        return argsParser.parse(calcArgs);
    }
}
