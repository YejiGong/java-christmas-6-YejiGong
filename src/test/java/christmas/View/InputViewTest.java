package christmas.View;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import christmas.Global.Exception;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    static InputView inputView = new InputView();

    @AfterEach
    void cleanUp() {
        Console.close();
    }

    @DisplayName("정상_날짜_입력_테스트")
    @Test
    void getLegalDateInput() {
        System.setIn(new ByteArrayInputStream("26".getBytes()));
        int result = inputView.getDateInput();
        assertThat(result == 26);
    }

    @DisplayName("비정상_날짜_입력_테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"32", "a", "\n"})
    void getIllegalDateInput(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
        assertThatThrownBy(() -> inputView.getDateInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Exception.ILLEGAL_DATE_INPUT.getPhrase());
    }

    @DisplayName("정상_메뉴_입력_테스트")
    @Test
    void getLegalMenuInput() {
        System.setIn(new ByteArrayInputStream("타파스-1,제로콜라-1".getBytes()));
        HashMap<String, Integer> result = inputView.getMenuInput();
        assertThat(result.keySet().containsAll(List.of("타파스", "제로콜라")));
        assertThat(result.get("타파스").equals(1));
        assertThat(result.get("제로콜라").equals(1));
    }

    @DisplayName("비정상_메뉴_입력_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"타파스-1*", "타파스-19;콜라-10", "타파스19,콜라100", "100", "\n", "타파스-19,타파스-11", "타파스-1;샴페인-1",
            "타파스-1,타파스-1"})
    void getIllegalMenuInput(String text) {
        System.setIn(new ByteArrayInputStream(text.getBytes()));
        assertThatThrownBy(() -> inputView.getMenuInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Exception.ILLEGAL_ORDER_INPUT.getPhrase());
    }

}