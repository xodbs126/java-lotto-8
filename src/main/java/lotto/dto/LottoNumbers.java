package lotto.dto;

import lotto.domain.Lotto;

public record LottoNumbers(Lotto lotto) {


    public static LottoNumbers from(Lotto lotto) {
        return new LottoNumbers(lotto);
    }
}
