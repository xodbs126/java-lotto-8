package lotto.dto;

import java.util.List;
import lotto.Lotto;

public record LottoNumbers(Lotto lotto) {


    public static LottoNumbers from(Lotto lotto) {
        return new LottoNumbers(lotto);
    }
}
