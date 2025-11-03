package lotto.validator.lotto;

import static lotto.constants.LottoConstants.LOTTO_COUNT;

import java.util.List;

public class LottoCountValidator implements LottoValidator{
    @Override
    public void isValid(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 "+LOTTO_COUNT+"개여야 합니다.");
        }
    }
}
