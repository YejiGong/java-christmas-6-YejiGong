package christmas.Model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeEtcEventTest {
    static BadgeEtcEvent badgeEtcEvent = new BadgeEtcEvent();

    @DisplayName("할인_금액_테스트")
    @Test
    void getEventResult() {
        String result = badgeEtcEvent.getEventResult(31246);
        assertThat(result).isEqualTo("산타");
    }

}