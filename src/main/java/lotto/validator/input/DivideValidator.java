package lotto.validator.input;

import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoConstants.MIN_PRICE;


public class DivideValidator implements InputValidator {

    @Override
    public void isValid(String input) {

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해주세요.");
        }
        long money;
        try {
            money = Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.", e);
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_PRICE + "원 단위로 입력해야 합니다.");
        }

        if (money <= MIN_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 "+MIN_PRICE+"원보다 커야 합니다.");
        }
    }
}