package lotto;

import java.util.List;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.controller.LottoController;
import lotto.domain.InputParser;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.validator.input.BonusNumberValidator;
import lotto.validator.input.InputValidator;
import lotto.validator.input.NumberValidator;
import lotto.validator.input.WinningNumbersValidator;
import lotto.validator.lotto.LottoValidator;
import lotto.validator.lotto.LottoCountValidator;
import lotto.validator.lotto.LottoDuplicatedValidator;
import lotto.validator.lotto.LottoRangeValidator;

public class Application {
    public static void main(String[] args) {

        InputValidator numberValidator = new NumberValidator();
        InputValidator winningNumbersValidator = new WinningNumbersValidator();
        InputValidator bonusNumberValidator = new BonusNumberValidator();

        LottoCountValidator lottoCountValidator = new LottoCountValidator();
        LottoDuplicatedValidator lottoDuplicatedValidator = new LottoDuplicatedValidator();
        LottoRangeValidator lottoRangeValidator = new LottoRangeValidator();

        List<LottoValidator> lottoValidators = List.of(lottoCountValidator, lottoDuplicatedValidator,
                lottoRangeValidator);

        LottoMachine lottoMachine = new LottoMachine(lottoValidators);

        InputParser inputParser = new InputParser(numberValidator, winningNumbersValidator, bonusNumberValidator
        );

        LottoStore lottoStore = new LottoStore(lottoMachine);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoController lottoController = new LottoController(lottoStore, inputParser, inputView, outputView);

        lottoController.play();
    }
}
