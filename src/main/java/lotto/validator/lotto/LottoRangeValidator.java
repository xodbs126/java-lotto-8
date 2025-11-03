package lotto.validator.lotto;

import java.util.List;

public class LottoRangeValidator implements LottoValidator {
    @Override
    public void isValid(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
