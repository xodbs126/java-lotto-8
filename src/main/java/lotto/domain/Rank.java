package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOURTH(4, false, 50000L),
    FIFTH(3, false, 5000L),
    MISS(0, false, 0L);

    private final int count;
    private final boolean needBonusNumber;
    private final long prize;

    Rank(int count, boolean needBonusNumber, long prize) {
        this.count = count;
        this.needBonusNumber = needBonusNumber;
        this.prize = prize;
    }

    public static Rank valueOf(int count, boolean hasBonus) {
        if (count == 6) {
            return FIRST;
        }
        if (count == 5 && hasBonus) {
            return SECOND;
        }
        if (count == 5) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.count == count && !rank.needBonusNumber)
                .findFirst()
                .orElse(MISS);
    }


    public long getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }
}