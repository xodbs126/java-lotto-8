package lotto.View;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.dto.LottoDto;
import lotto.dto.LottoNumbers;

public class OutputView {

    public void printPurchasedLottos(LottoDto purchasedLottos) {
        System.out.println("\n" + purchasedLottos.count() + "개를 구매했습니다.");

        for (LottoNumbers lottoNumbers : purchasedLottos.lottoNumbersList()) {

            List<Integer> numbers = lottoNumbers.lotto().getNumbers();

            System.out.println(numbers);
        }
    }

    public void printResult(Long inputMoney, LottoResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> statistics = result.getStatistics();

        List<Rank> printOrder = List.of(
                Rank.FIFTH,
                Rank.FOURTH,
                Rank.THIRD,
                Rank.SECOND,
                Rank.FIRST
        );

        for (Rank rank : printOrder) {
            System.out.println(formatRankString(rank, statistics.get(rank)));
        }

        long totalPrize = result.getTotalPrize();

        double profitRate = ((double) totalPrize / inputMoney) * 100.0;

        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profitRate));
    }

    private String formatRankString(Rank rank, int count) {

        String prize = String.format("%,d", rank.getPrize());

        String description = rank.getCount() + "개 일치";

        if (rank == Rank.SECOND) {
            description += ", 보너스 볼 일치";
        }

        return String.format("%s (%s원) - %d개", description, prize, count);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
