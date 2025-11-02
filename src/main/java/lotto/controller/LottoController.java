package lotto.controller;

import java.util.List;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.domain.InputParser;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.dto.LottoDto;
import lotto.dto.WinningNumberDto;

public class LottoController {

    private final LottoStore lottoStore;
    private final InputParser inputParser;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoStore lottoStore, InputParser inputParser,
                           InputView inputView, OutputView outputView) {
        this.lottoStore = lottoStore;
        this.inputParser = inputParser;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {

        LottoDto purchasedLottos = buyLottos();

        outputView.printPurchasedLottos(purchasedLottos);
        WinningNumberDto winningNumbers = drawingWinningNumbers();

        LottoResult result = lottoStore.calculate(purchasedLottos, winningNumbers);
        outputView.printResult(purchasedLottos.inputMoney(), result);
    }

    private LottoDto buyLottos() {
        while (true) {
            try {
                String money = inputView.inputMoney();
                Long inputMoney = inputParser.convertToLong(money);
                return lottoStore.purchase(inputMoney);

            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private WinningNumberDto drawingWinningNumbers() {
        while (true) {
            try {
                String StringWinningNumbers = inputView.inputWinningNumbers();
                List<Integer> winningNumbers = inputParser.convertToNumbers(StringWinningNumbers);

                String StringBonusNumber = inputView.inputBonusNumber();
                int bonusNumber = inputParser.convertToBonusNumber(StringBonusNumber);

                return WinningNumberDto.from(winningNumbers, bonusNumber);

            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
