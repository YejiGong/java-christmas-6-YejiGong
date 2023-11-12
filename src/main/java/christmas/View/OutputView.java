package christmas.View;

import static christmas.Global.Constants.MONEY_UNIT;

import java.text.DecimalFormat;
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

    public void printMoney(int input) {
        StringBuilder sb = new StringBuilder();
        sb.append(convertIntToMoney(input));
        sb.append(MONEY_UNIT);
        System.out.println(sb.toString());
    }

    private String convertIntToMoney(int input) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(input);
    }
}
