package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_COUNT;
import static lotto.constants.LottoConstants.LOTTO_END_NUM;
import static lotto.constants.LottoConstants.LOTTO_START_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.dto.LottoNumbers;
import lotto.validator.lotto.LottoValidator;

public class LottoMachine {

    private final List<LottoValidator> lottoValidator;

    public LottoMachine(List<LottoValidator> lottoValidator) {
        this.lottoValidator = lottoValidator;
    }

    /***
     * 로또 숫자 오름차순 정렬
     * @param lottoNumbers
     */
    private static void sortNumbers(List<Integer> lottoNumbers) {
        lottoNumbers.sort(Comparator.naturalOrder());
    }

    public LottoNumbers generateLotto() {
        List<Integer> lottoNumbers = generateNumbers();
        Lotto lotto = new Lotto(lottoNumbers, lottoValidator); //
        return LottoNumbers.from(lotto);
    }

    /***
     * 로또 숫자 발행
     * @return
     */
    public List<Integer> generateNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUM, LOTTO_END_NUM, LOTTO_COUNT);

        List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);

        sortNumbers(sortedLottoNumbers);

        return sortedLottoNumbers;
    }


}
