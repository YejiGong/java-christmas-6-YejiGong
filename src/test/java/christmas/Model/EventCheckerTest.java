package christmas.Model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.Domain.EventResult;
import christmas.Domain.Result;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventCheckerTest {
    static EventChecker eventChecker = new EventChecker(new EventsRegistry());

    @DisplayName("이벤트 결과 테스트")
    @Test
    void eventCheckTest() {
        HashMap<String, Integer> orderMenu = new HashMap<>();
        Result result = new Result();
        result.putOrderMenu("티본스테이크", 1);
        result.putOrderMenu("바비큐립", 1);
        result.putOrderMenu("초코케이크", 2);
        result.putOrderMenu("제로콜라", 1);
        result.addBeforeDiscountOrderPrice(142000);
        EventResult eventResult = eventChecker.eventCheck(26, result);
        assertThat(eventResult.getWholeBenefitPrice() == 31246);
        assertThat(eventResult.getAfterDiscountOrderPrice() == 135754);
    }

}