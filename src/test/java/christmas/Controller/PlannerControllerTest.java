package christmas.Controller;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import christmas.Model.EventChecker;
import christmas.Model.EventsRegistry;
import christmas.Model.Order;
import christmas.View.InputView;
import christmas.View.OutputView;
import christmas.View.View;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlannerControllerTest {

    static View view = new View(new InputView(), new OutputView());
    static Order order = new Order(new EventChecker(new EventsRegistry()));
    static OutputStream out;
    static PlannerController plannerController = new PlannerController(view, order);


    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void cleanUp() {
        Console.close();
    }

    @DisplayName("정상적인 주문")
    @Test
    void LegalOrder() {
        System.setIn(new ByteArrayInputStream("26\n타파스-1\n제로콜라-1".getBytes()));
        plannerController.run();
        assertThat(out.toString().trim()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
        );
    }

    @DisplayName("비정상적인 주문")
    @ParameterizedTest
    @ValueSource(strings = {"39\n27\n제로콜라-1\n타파스-1", "27\n타파스-21\n타파스-1", "27\n재로콜라-1\n제로콜라-1\n타파스-1"})
    void IllegalOrder(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
        plannerController.run();
        assertThat(out.toString().trim()).contains(
                "[ERROR]",
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
        );
    }
}