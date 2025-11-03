package lotto;

import java.util.List;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.controller.LottoController;
import lotto.domain.InputParser;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.validator.input.BonusNumberValidator;
import lotto.validator.input.DivideValidator;
import lotto.validator.input.InputValidator;
import lotto.validator.input.NumberValidator;
import lotto.validator.input.WinningNumbersValidator;
import lotto.validator.lotto.LottoCountValidator;
import lotto.validator.lotto.LottoDuplicatedValidator;
import lotto.validator.lotto.LottoRangeValidator;
import lotto.validator.lotto.LottoValidator;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(lottoStore(), inputParser(), inputView(), outputView());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private LottoStore lottoStore() {
        return new LottoStore(lottoMachine());
    }

    private LottoMachine lottoMachine() {
        return new LottoMachine(lottoValidators());
    }

    private InputParser inputParser() {
        return new InputParser(
                numberValidator(),
                winningNumbersValidator(),
                bonusNumberValidator(),
                divideValidator()
        );
    }

    private List<LottoValidator> lottoValidators() {
        return List.of(
                new LottoCountValidator(),
                new LottoDuplicatedValidator(),
                new LottoRangeValidator()
        );
    }

    private InputValidator numberValidator() {
        return new NumberValidator();
    }

    private InputValidator winningNumbersValidator() {
        return new WinningNumbersValidator();
    }

    private InputValidator bonusNumberValidator() {
        return new BonusNumberValidator();
    }

    private DivideValidator divideValidator() {
        return new DivideValidator();
    }
}
