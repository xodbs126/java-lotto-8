package lotto.validator;

public class BonusNumberValidator implements InputValidator {

    @Override
    public void isValid(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해주세요.");
        }

        parseAndValidateNumber(input.trim());
    }

    private void parseAndValidateNumber(String numberStr) {
        try {
            Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

}