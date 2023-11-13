package christmas.Model;

import static christmas.Global.Exception.ILLEGAL_ORDER_INPUT;
import static christmas.Global.ResultPhrase.AFTER_DISCOUNT_ORDER_PRICE;
import static christmas.Global.ResultPhrase.BEFORE_DISCOUNT_ORDER_PRICE;
import static christmas.Global.ResultPhrase.BENEFIT_INFORMATION;
import static christmas.Global.ResultPhrase.EVENT_BADGE_INFORMATION;
import static christmas.Global.ResultPhrase.ORDER_MENU;
import static christmas.Global.ResultPhrase.PRESENT_MENU;
import static christmas.Global.ResultPhrase.WHOLE_BENEFIT_PRICE;
import static christmas.Global.SubResultPhrase.MONEY_OUTPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
    static Order order = new Order(new EventChecker());

    @DisplayName("정상_주문_테스트")
    @Test
    void legalOrderTest() {
        HashMap<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("티본스테이크", 1);
        orderMenu.put("바비큐립", 1);
        orderMenu.put("초코케이크", 2);
        orderMenu.put("제로콜라", 1);
        HashMap<String, List<String>> result = order.order(26, orderMenu);
        assertThat(result.keySet()).contains(ORDER_MENU.getPhrase(), BEFORE_DISCOUNT_ORDER_PRICE.getPhrase(),
                PRESENT_MENU.getPhrase(), BENEFIT_INFORMATION.getPhrase(),
                WHOLE_BENEFIT_PRICE.getPhrase(), AFTER_DISCOUNT_ORDER_PRICE.getPhrase(),
                EVENT_BADGE_INFORMATION.getPhrase());
        assertThat(result.get(BEFORE_DISCOUNT_ORDER_PRICE.getPhrase()).get(0)).isEqualTo(
                MONEY_OUTPUT.getPhraseMoney(142000));
    }

    @DisplayName("비정상_주문_테스트")
    @Test
    void illegalOrderTest() {
        HashMap<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("티본스테이크", 21);
        assertThatThrownBy(() -> order.order(26, orderMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_ORDER_INPUT.getPhrase());
    }
}