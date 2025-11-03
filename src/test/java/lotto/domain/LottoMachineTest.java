package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.validator.lotto.LottoDuplicatedValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import lotto.dto.LottoNumbers;
import lotto.validator.lotto.LottoCountValidator;
import lotto.validator.lotto.LottoRangeValidator;
import lotto.validator.lotto.LottoValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest extends NsTest {

    private LottoMachine lottoMachine;
    private List<LottoValidator> validators;

    @BeforeEach
    void setUp() {
        validators = List.of(
                new LottoCountValidator(),
                new LottoDuplicatedValidator(),
                new LottoRangeValidator()
        );

        lottoMachine = new LottoMachine(validators);
    }

    @Test
    @DisplayName("로또 번호 정렬처리해야함")
    void 로또번호_정렬처리() {
        List<Integer> unsortedNumbers = List.of(6, 5, 4, 3, 2, 1);

        List<Integer> expectedSortedNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoNumbers resultDto = lottoMachine.generateLotto();
                    assertThat(resultDto).isNotNull();
                    Lotto generatedLotto = resultDto.lotto();
                    assertThat(generatedLotto).isNotNull();
                    List<Integer> actualNumbers = generatedLotto.getNumbers();
                    assertThat(actualNumbers).isEqualTo(expectedSortedNumbers);
                },
                unsortedNumbers
        );
    }

    @Override
    protected void runMain() {

    }
}