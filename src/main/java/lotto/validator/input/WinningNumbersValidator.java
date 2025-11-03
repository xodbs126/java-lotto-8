package lotto.validator.input;

import static lotto.constants.LottoConstants.SEPARATOR;

import java.util.HashSet;
import java.util.Set;

public class WinningNumbersValidator implements InputValidator {


    @Override
    public void isValid(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해주세요.");
        }
        String[] numbers = input.split(SEPARATOR);

        validateNumberFormatAndRangeAndDuplication(numbers);
    }

    private void validateNumberFormatAndRangeAndDuplication(String[] numbers) {
        Set<Integer> lottoNumbers = new HashSet<>();
        for (String numberStr : numbers) {
            int number = parseAndValidateNumber(numberStr.trim());
            lottoNumbers.add(number);
        }
    }

    private int parseAndValidateNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

}