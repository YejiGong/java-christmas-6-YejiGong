package christmas.Model;

import static christmas.Global.Exception.ILLEGAL_ORDER_INPUT;
import static christmas.Global.SubResultPhrase.MONEY_OUTPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.DTO.ResultDTO;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
    static Order order = new Order(new EventChecker(new EventsRegistry()));

    @DisplayName("정상_주문_테스트")
    @Test
    void legalOrderTest() {
        HashMap<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("티본스테이크", 1);
        orderMenu.put("바비큐립", 1);
        orderMenu.put("초코케이크", 2);
        orderMenu.put("제로콜라", 1);
        ResultDTO result = order.order(26, orderMenu);
        assertThat(result.getBeforeDiscountOrderPrice()).contains(MONEY_OUTPUT.getPhraseMoney(142000));
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