package calculator.domain;

import calculator.exception.input.CalculatorException;

import static calculator.exception.input.CalculatorExceptionMessage.WRONG_CUSTOM_DELIMITER_FORMAT;

public class CustomDelimiterExtractor {

    private static final String CUSTOM_DELIMITER_PREFIX_FORMAT = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX_FORMAT = "\\n";
    private static final int CUSTOM_DELIMITER_BEGIN_INDEX = 2;
    private static final int NON_EXIST = -1;

    public String getCustomDelimiter(String stringWithDivisionMark) {
        if (stringWithDivisionMark.startsWith(CUSTOM_DELIMITER_PREFIX_FORMAT)) {
            return extractCustomDelimiter(stringWithDivisionMark);
        }
        throw new CalculatorException(WRONG_CUSTOM_DELIMITER_FORMAT);
    }

    private String extractCustomDelimiter(String stringWithDivisionMark) {
        int endIndex = stringWithDivisionMark.indexOf(CUSTOM_DELIMITER_SUFFIX_FORMAT);
        if (endIndex == NON_EXIST) {
            throw new CalculatorException(WRONG_CUSTOM_DELIMITER_FORMAT);
        }
        return stringWithDivisionMark.substring(CUSTOM_DELIMITER_BEGIN_INDEX, endIndex);
    }
}
