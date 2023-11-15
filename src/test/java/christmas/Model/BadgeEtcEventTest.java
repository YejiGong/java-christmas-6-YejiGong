package christmas.Model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BadgeEtcEventTest {
    static BadgeEtcEvent badgeEtcEvent = new BadgeEtcEvent();

    @DisplayName("할인_금액_테스트")
    @ParameterizedTest
    @CsvSource(value = {"31246,산타", "20000,산타", "10000,트리", "5000,별"})
    void getEventResult(int amount, String badge) {
        String result = badgeEtcEvent.getEventResult(amount);
        assertThat(result).isEqualTo(badge);
    }

}