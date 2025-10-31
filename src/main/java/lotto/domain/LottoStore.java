package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.LottoNumbers;

public class LottoStore {

    private static final Integer LOTTO_PRICE  =1000;
    private final LottoMachine lottoMachine;

    public LottoStore(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public Integer calculateCount(Integer money) {
        Integer count = money / LOTTO_PRICE;

        return count;
    }

    public Integer calculateMoney(Integer money) {
        Integer charge = money % LOTTO_PRICE;

        return charge;
    }


    public LottoDto purchase(Integer money) {
        List<LottoNumbers> purchasedLottos = new ArrayList<>();

        Integer lottoCount = calculateCount(money);
        Integer charge = calculateMoney(money);

        for (int count = 0; count < lottoCount; count++) {
            LottoNumbers lottoNumbers = lottoMachine.generateLotto();
            purchasedLottos.add(lottoNumbers);
        }

        return LottoDto.from(purchasedLottos, lottoCount, charge);
    }



}
