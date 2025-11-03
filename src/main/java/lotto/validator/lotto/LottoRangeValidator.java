package lotto.validator.lotto;

import static lotto.constants.LottoConstants.LOTTO_END_NUM;
import static lotto.constants.LottoConstants.LOTTO_START_NUM;

import java.util.List;

public class LottoRangeValidator implements LottoValidator {
    @Override
    public void isValid(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_START_NUM || number > LOTTO_END_NUM) {
                throw new IllegalArgumentException(
                        "[ERROR] 로또 번호는 " + LOTTO_START_NUM + "부터 " + LOTTO_END_NUM + " 사이의 숫자여야 합니다.");
            }
        }
    }
}
