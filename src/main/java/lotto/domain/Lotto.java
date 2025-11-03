package lotto.domain;

import java.util.List;
import lotto.validator.lotto.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers, List<LottoValidator> lottoValidator) {
        validate(numbers, lottoValidator);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers, List<LottoValidator> lottoValidator) {
        for (LottoValidator validator : lottoValidator) {
            validator.isValid(numbers);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getCount(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean needBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

}
