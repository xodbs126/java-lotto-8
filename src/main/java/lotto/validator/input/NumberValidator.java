package lotto.validator.input;

public class NumberValidator implements InputValidator {

    @Override
    public void isValid(String money) {
        if (money == null || money.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 null입니다.");
        }
        try {
            Long.parseLong(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자여야 합니다: " + money, e);
        }
    }
}
