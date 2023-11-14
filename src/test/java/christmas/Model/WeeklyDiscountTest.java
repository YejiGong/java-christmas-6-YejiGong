package christmas.Model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WeeklyDiscountTest {

    static WeeklyDiscount weeklyDiscount = new WeeklyDiscount();

    @DisplayName("이름_출력_테스트")
    @Test
    void getNameTest() {
        assertThat(weeklyDiscount.getName()).isEqualTo("평일 할인");
    }

    @DisplayName("할인_금액_테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,4046", "2,0"})
    void getEventResult(int date, int expectDiscountValue) {
        assertThat(weeklyDiscount.getEventResult(date,
                new HashMap<>(Map.of("티본스테이크", 1, "바비큐립", 1, "초코케이크", 2, "제로콜라", 1)))).isEqualTo(expectDiscountValue);
    }
}