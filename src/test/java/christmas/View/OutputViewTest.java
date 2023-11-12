package christmas.View;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OutputViewTest {
    static OutputView outputView = new OutputView();
    static OutputStream out;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("출력 테스트")
    @Test
    void printTest() {
        outputView.print("any string");
        Assertions.assertThat(out.toString().trim()).contains("any string");
    }

    @DisplayName("리스트 출력 테스트")
    @Test
    void printMultipleLineTest() {
        outputView.printMultipleLine(List.of("타파스 1개", "제로콜라 1개"));
        Assertions.assertThat(out.toString().trim()).contains("타파스 1개", "제로콜라 1개");
    }

    @DisplayName("금액 출력 테스트")
    @ParameterizedTest()
    @CsvSource(value = {"8500:8,500원", "10000:10,000원", "100000:100,000원", "1000000:1,000,000원"}, delimiterString = ":")
    void printMoneyTest(int input, String expect) {
        outputView.printMoney(input);
        Assertions.assertThat(out.toString().trim()).contains(expect);
    }

}