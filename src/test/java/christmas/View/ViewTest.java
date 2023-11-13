package christmas.View;

import static christmas.Global.PrintPhrase.GREETING;
import static christmas.Global.PrintPhrase.MENU_ORDER_INPUT_NOTICE;
import static christmas.Global.PrintPhrase.VISIT_INPUT_NOTICE;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import christmas.DTO.ResultDTO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        ResultDTO resultDTO = new ResultDTO(new HashMap<>(Map.of("티본스테이크", 1)), 142000, new HashMap<>(Map.of("샴페인", 1)),
                new HashMap<>(Map.of("크리스마스 디데이 할인", 1200)), 31246, 135754, List.of("산타"));
        view.printOrderResult(26, resultDTO);
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