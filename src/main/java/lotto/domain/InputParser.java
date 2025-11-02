package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.InputValidator; // 인터페이스만 import

public class InputParser {

    private final InputValidator numberValidator;
    private final InputValidator winningNumbersValidator;
    private final InputValidator bonusNumberValidator;

    public InputParser(InputValidator numberValidator,
                       InputValidator winningNumbersValidator,
                       InputValidator bonusNumberValidator) {
        this.numberValidator = numberValidator;
        this.winningNumbersValidator = winningNumbersValidator;
        this.bonusNumberValidator = bonusNumberValidator;
    }

    public Long convertToLong(String money) {
        numberValidator.isValid(money);
        return Long.parseLong(money);
    }

    public List<Integer> convertToNumbers(String winningNumbers) {
        winningNumbersValidator.isValid(winningNumbers);

        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int convertToBonusNumber(String bonusNumber) {

        bonusNumberValidator.isValid(bonusNumber);
        return Integer.parseInt(bonusNumber.trim());
    }
}