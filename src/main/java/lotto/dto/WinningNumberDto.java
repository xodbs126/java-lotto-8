package lotto.dto;

import java.util.List;

public record WinningNumberDto(List<Integer> winningNumbers, int bonusNumber) {

    public static WinningNumberDto from(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumberDto(winningNumbers, bonusNumber);
    }
}
