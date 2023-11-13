package christmas.Model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChampagnePresentationEventTest {
    static ChampagnePresentationEvent champagnePresentationEvent;

    @DisplayName("이름_출력_테스트")
    @Test
    void getNameTest() {
        assertThat(champagnePresentationEvent.getName()).isEqualTo("주말 할인");
    }

    @DisplayName("할인_금액_테스트")
    @Test
    void getEventResult() {
        Optional<HashMap<String, Integer>> result = champagnePresentationEvent.getEventResult(142000,
                new HashMap<>(Map.of("티본스테이크", 1, "바비큐립", 1, "초코케이크", 2, "제로콜라", 1)));
        assertThat(result.get().size()).isEqualTo(1);
        assertThat(result.get().get("샴페인")).isEqualTo(1);
    }

}