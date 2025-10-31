package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import lotto.dto.LottoNumbers;

public class LottoMachine {

    public LottoNumbers generateLotto() {
        List<Integer> lottoNumbers = generateNumbers();
        Lotto lotto = new Lotto(lottoNumbers);
        return LottoNumbers.from(lotto);
    }

    /***
     * 로또 숫자 발행
     * @return
     */
    public List<Integer> generateNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortNumbers(lottoNumbers);

        return lottoNumbers;
    }

    /***
     * 로또 숫자 오름차순 정렬
     * @param lottoNumbers
     */
    private static void sortNumbers(List<Integer> lottoNumbers) {
        lottoNumbers.sort(Comparator.naturalOrder());
    }



}
