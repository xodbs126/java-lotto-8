package lotto.validator.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoDuplicatedValidator implements LottoValidator {
    @Override
    public void isValid(List<Integer> numbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        if (lottoNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
