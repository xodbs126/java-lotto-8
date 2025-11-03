package lotto.domain;

import static lotto.constants.LottoConstants.SEPARATOR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.input.DivideValidator;
import lotto.validator.input.InputValidator;

public class InputParser {

    private final InputValidator numberValidator;
    private final InputValidator winningNumbersValidator;
    private final InputValidator bonusNumberValidator;
    private final DivideValidator divideValidator;

    public InputParser(InputValidator numberValidator,
                       InputValidator winningNumbersValidator,
                       InputValidator bonusNumberValidator, DivideValidator divideValidator) {
        this.numberValidator = numberValidator;
        this.winningNumbersValidator = winningNumbersValidator;
        this.bonusNumberValidator = bonusNumberValidator;
        this.divideValidator = divideValidator;
    }

    public Long convertToLong(String money) {
        numberValidator.isValid(money);
        divideValidator.isValid(money);
        return Long.parseLong(money);
    }

    public List<Integer> convertToNumbers(String winningNumbers) {
        winningNumbersValidator.isValid(winningNumbers);

        return Arrays.stream(winningNumbers.split(SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int convertToBonusNumber(String bonusNumber) {

        bonusNumberValidator.isValid(bonusNumber);
        return Integer.parseInt(bonusNumber.trim());
    }
}