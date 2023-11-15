package christmas.Model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ChampagnePresentationEventTest {
    static ChampagnePresentationEvent champagnePresentationEvent = new ChampagnePresentationEvent();

    @DisplayName("이름_출력_테스트")
    @Test
    void getNameTest() {
        assertThat(champagnePresentationEvent.getName()).isEqualTo("증정 이벤트");
    }

    @DisplayName("할인_금액_테스트")
    @ParameterizedTest
    @CsvSource(value = {"142000,1", "200000,1", "10000,0"})
    void getEventResult(int amount, int expect) {
        int result = champagnePresentationEvent.getEventResult(amount,
                new HashMap<>(Map.of("티본스테이크", 1, "바비큐립", 1, "초코케이크", 2, "제로콜라", 1)));
        assertThat(result).isEqualTo(expect);
    }

}