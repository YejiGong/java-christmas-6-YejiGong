package christmas.Model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasDiscountTest {
    static ChristmasDiscount christmasDiscount = new ChristmasDiscount();

    @DisplayName("이름_출력_테스트")
    @Test
    void getNameTest() {
        assertThat(christmasDiscount.getName()).isEqualTo("크리스마스 디데이 할인");
    }

    @DisplayName("할인_금액_테스트")
    @Test
    void getEventResult() {
        assertThat(christmasDiscount.getEventResult(3,
                new HashMap<>(Map.of("티본스테이크", 1, "바비큐립", 1, "초코케이크", 2, "제로콜라", 1)))).isEqualTo(1200);
    }

}