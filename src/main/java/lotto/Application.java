package lotto;

import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.controller.LottoController;
import lotto.domain.InputParser;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.validator.BonusNumberValidator;
import lotto.validator.InputValidator;
import lotto.validator.NumberValidator;
import lotto.validator.WinningNumbersValidator;

public class Application {
    public static void main(String[] args) {

        InputValidator numberValidator = new NumberValidator();
        InputValidator winningNumbersValidator = new WinningNumbersValidator();
        InputValidator bonusNumberValidator = new BonusNumberValidator();

        LottoMachine lottoMachine = new LottoMachine();

        InputParser inputParser = new InputParser(numberValidator, winningNumbersValidator, bonusNumberValidator
        );

        LottoStore lottoStore = new LottoStore(lottoMachine);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoController lottoController = new LottoController(lottoStore, inputParser, inputView, outputView);

        lottoController.play();
    }
}
