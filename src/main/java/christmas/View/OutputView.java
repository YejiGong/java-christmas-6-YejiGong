package christmas.View;

import java.util.List;

public class OutputView {
    public void print(String input) {
        System.out.println(input);
    }

    public void printMultipleLine(List<String> inputs) {
        for (String input : inputs) {
            System.out.println(input);
        }
    }


}
