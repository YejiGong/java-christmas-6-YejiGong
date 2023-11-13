package christmas.Model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialDiscountTest {

    static SpecialDiscount specialDiscount;

    @DisplayName("이름_출력_테스트")
    @Test
    void getNameTest() {
        assertThat(specialDiscount.getName()).isEqualTo("특별 할인");
    }

    @DisplayName("할인_금액_테스트")
    @Test
    void getEventResult() {
        assertThat(specialDiscount.getEventResult(3,
                new HashMap<>(Map.of("티본스테이크", 1, "바비큐립", 1, "초코케이크", 2, "제로콜라", 1)))).isEqualTo(1000);
    }

}