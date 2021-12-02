package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(String number) {
        this(Integer.parseInt(number));
    }

    public LottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException(
                    String.format("로또는 %d부터 %d까지의 숫자만을 선택할 수 있습니다.",
                            MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
