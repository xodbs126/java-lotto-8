package lotto.domain;

import java.util.List;
import lotto.dto.LottoNumbers;

public record LottoDto(List<LottoNumbers> lottoNumbersList, Integer count, Integer charge) {

    public static LottoDto from(List<LottoNumbers> purchasedLottos, Integer count, Integer charge) {
        return new LottoDto(purchasedLottos, count, charge);
    }

}
