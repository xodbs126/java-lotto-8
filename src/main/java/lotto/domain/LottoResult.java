package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> statistics;

    public LottoResult() {
        this.statistics = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
    }

    public void add(Rank rank) {
        statistics.put(rank, statistics.get(rank) + 1);
    }

    public Map<Rank, Integer> getStatistics() {
        return statistics;
    }

    public long getTotalPrize() {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : statistics.entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }
        return totalPrize;
    }
}