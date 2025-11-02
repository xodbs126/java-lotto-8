package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.LottoNumbers;
import lotto.dto.WinningNumberDto;

public class LottoStore {

    private static final Integer LOTTO_PRICE  =1000;
    private final LottoMachine lottoMachine;

    public LottoStore(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public Long calculateCount(Long money) {
        Long count = money / LOTTO_PRICE;

        return count;
    }

    public Long calculateMoney(Long money) {
        Long charge = money % LOTTO_PRICE;

        return charge;
    }


    public LottoDto purchase(Long money) {
        List<LottoNumbers> purchasedLottos = new ArrayList<>();

        Long lottoCount = calculateCount(money);
        Long charge = calculateMoney(money);

        for (int count = 0; count < lottoCount; count++) {
            LottoNumbers lottoNumbers = lottoMachine.generateLotto();
            purchasedLottos.add(lottoNumbers);
        }

        return LottoDto.from(purchasedLottos, lottoCount, charge,money);
    }


    public LottoResult calculate(LottoDto purchasedLottos, WinningNumberDto winningNumbers) {


        LottoResult result = new LottoResult();

        List<Integer> winningNumberList = winningNumbers.winningNumbers();
        int bonusNum = winningNumbers.bonusNumber();

        for (LottoNumbers lottoNumbers : purchasedLottos.lottoNumbersList()) {

            Lotto lotto = lottoNumbers.lotto();

            int matchCount = lotto.getMatchCount(winningNumberList);
            boolean hasBonus = lotto.hasBonus(bonusNum);

            Rank rank = Rank.valueOf(matchCount, hasBonus);

            result.add(rank);
        }

        return result;
    }
}
