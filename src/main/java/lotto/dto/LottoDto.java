package lotto.dto;

import java.util.List;

public record LottoDto(List<LottoNumbers> lottoNumbersList, Long count, Long charge, Long inputMoney) {

    public static LottoDto from(List<LottoNumbers> purchasedLottos, Long count, Long charge, Long inputMoney) {
        return new LottoDto(purchasedLottos, count, charge, inputMoney);
    }

}
