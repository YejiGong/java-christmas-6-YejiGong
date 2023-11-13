package christmas.Model;

import static christmas.Global.ResultPhrase.AFTER_DISCOUNT_ORDER_PRICE;
import static christmas.Global.ResultPhrase.WHOLE_BENEFIT_PRICE;
import static christmas.Global.SubResultPhrase.DISCOUNT_MONEY_OUTPUT;
import static christmas.Global.SubResultPhrase.MONEY_OUTPUT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventCheckerTest {
    static EventChecker eventChecker = new EventChecker();

    @DisplayName("이벤트 결과 테스트")
    @Test
    void eventCheckTest() {
        HashMap<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("티본스테이크", 1);
        orderMenu.put("바비큐립", 1);
        orderMenu.put("초코케이크", 2);
        orderMenu.put("제로콜라", 1);
        HashMap<String, List<String>> result = eventChecker.eventCheck(26, 142000, orderMenu);
        assertThat(
                result.get(WHOLE_BENEFIT_PRICE.getPhrase()).get(0).equals(DISCOUNT_MONEY_OUTPUT.getPhraseMoney(31246)));
        assertThat(
                result.get(AFTER_DISCOUNT_ORDER_PRICE.getPhrase()).get(0).equals(MONEY_OUTPUT.getPhraseMoney(135754)));
    }

}