package lotto.validator.lotto;

import java.util.List;

public class LottoCountValidator implements LottoValidator{
    @Override
    public void isValid(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
