package christmas.View;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


}