package christmas.View;

import static christmas.Global.PrintPhrase.GREETING;
import static christmas.Global.PrintPhrase.MENU_ORDER_INPUT_NOTICE;
import static christmas.Global.PrintPhrase.VISIT_INPUT_NOTICE;
import static christmas.Global.ResultPhrase.AFTER_DISCOUNT_ORDER_PRICE;
import static christmas.Global.ResultPhrase.BEFORE_DISCOUNT_ORDER_PRICE;
import static christmas.Global.ResultPhrase.BENEFIT_INFORMATION;
import static christmas.Global.ResultPhrase.EVENT_BADGE_INFORMATION;
import static christmas.Global.ResultPhrase.ORDER_MENU;
import static christmas.Global.ResultPhrase.PRESENT_MENU;
import static christmas.Global.ResultPhrase.WHOLE_BENEFIT_PRICE;
import static christmas.Global.SubResultPhrase.BENEFIT_VALUE_NUMBER;
import static christmas.Global.SubResultPhrase.DISCOUNT_MONEY_OUTPUT;
import static christmas.Global.SubResultPhrase.MENU_VALUE_NUMBER;
import static christmas.Global.SubResultPhrase.MONEY_OUTPUT;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ViewTest {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static OutputStream out;
    static View view = new View(inputView, outputView);

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void cleanUp() {
        Console.close();
    }

    @DisplayName("안내 문구 출력")
    @Test
    void putGreetings() {
        view.putGreetings();
        assertThat(out.toString().trim()).contains(GREETING.getPhrase());
    }

    @DisplayName("방문 날짜 입력 받기 테스트")
    @Test
    void getVisitDateTest() {
        System.setIn(new ByteArrayInputStream("26".getBytes()));
        int result = view.getVisitDate();
        assertThat(result == 26);
        assertThat(out.toString().trim()).contains(VISIT_INPUT_NOTICE.getPhrase());
    }

    @DisplayName("메뉴 입력 받기 테스트")
    @Test
    void getOrderTest() {
        System.setIn(new ByteArrayInputStream("타파스-1,제로콜라-1".getBytes()));
        HashMap<String, Integer> result = view.getMenuOrder();
        assertThat(result.keySet()).contains("타파스", "제로콜라");
        assertThat(result.get("타파스") == 1);
        assertThat(result.get("제로콜라") == 1);
        assertThat(out.toString().trim()).contains(MENU_ORDER_INPUT_NOTICE.getPhrase());
    }

    @DisplayName("주문 결과 테스트")
    @Test
    void printOrderResultTest() {
        HashMap<String, List<String>> result = new HashMap<>();
        result.put(ORDER_MENU.getPhrase(), List.of(MENU_VALUE_NUMBER.getPhrase("티본스테이크", 1)));
        result.put(BEFORE_DISCOUNT_ORDER_PRICE.getPhrase(), List.of(MONEY_OUTPUT.getPhraseMoney(142000)));
        result.put(PRESENT_MENU.getPhrase(), List.of(MENU_VALUE_NUMBER.getPhrase("샴페인", 1)));
        result.put(BENEFIT_INFORMATION.getPhrase(), List.of(BENEFIT_VALUE_NUMBER.getPhraseMoney("크리스마스 디데이", 1200)));
        result.put(WHOLE_BENEFIT_PRICE.getPhrase(), List.of(DISCOUNT_MONEY_OUTPUT.getPhraseMoney(31246)));
        result.put(AFTER_DISCOUNT_ORDER_PRICE.getPhrase(), List.of(MONEY_OUTPUT.getPhraseMoney(135754)));
        result.put(EVENT_BADGE_INFORMATION.getPhrase(), List.of("산타"));
        view.printOrderResult(26, result);
        assertThat(out.toString().trim()).contains(
                "<주문 메뉴>",
                "티본스테이크 1개",
                "<할인 전 총주문 금액>",
                "142,000원",
                "<증정 메뉴>",
                "샴페인 1개",
                "<혜택 내역>",
                "크리스마스 디데이 할인: -1,200원",
                "<총혜택 금액>",
                "-31,246원",
                "<할인 후 예상 결제 금액>",
                "135,754원",
                "<12월 이벤트 배지>",
                "산타"
        );


    }
}