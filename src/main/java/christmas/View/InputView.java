package christmas.View;

import static christmas.Global.Constants.DATE_MAX_RANGE;
import static christmas.Global.Constants.DATE_MIN_RANGE;
import static christmas.Global.Constants.INPUT_SPLIT_VALUE;
import static christmas.Global.Constants.MENU_SPLIT_VALUE;
import static christmas.Global.Exception.ILLEGAL_DATE_INPUT;
import static christmas.Global.Exception.ILLEGAL_ORDER_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern isNumberMatch = Pattern.compile("\\d+");

    public int getDateInput() {
        String input = Console.readLine();
        if (!isValidDate(input)) {
            throw new IllegalArgumentException(ILLEGAL_DATE_INPUT.getPhrase());
        }
        return Integer.parseInt(input);
    }

    private Boolean isValidDate(String input) {
        return isNumber(input) && isDateInRange(Integer.parseInt(input));
    }

    private Boolean isNumber(String input) {
        return isNumberMatch.matcher(input).matches();
    }

    private Boolean isDateInRange(int date) {
        return date >= DATE_MIN_RANGE && date <= DATE_MAX_RANGE;
    }

    public HashMap<String, Integer> getMenuInput() {
        String input = Console.readLine();
        return getMenuValue(getSplitMenus(input));
    }

    private List<String> getSplitMenus(String input) {
        if (!isValidMenusInput(input)) {
            throw new IllegalArgumentException(ILLEGAL_ORDER_INPUT.getPhrase());
        }
        return Arrays.stream(input.split(INPUT_SPLIT_VALUE)).toList();
    }

    private Boolean isValidMenusInput(String input) {
        return input.split(INPUT_SPLIT_VALUE).length > 1 || isValidMenuNumberPairInput(input);
    }

    private HashMap<String, Integer> getMenuValue(List<String> splitMenus) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String menuNumberPair : splitMenus) {
            if (!isValidMenuNumberPairInput(menuNumberPair)) {
                throw new IllegalArgumentException(ILLEGAL_ORDER_INPUT.getPhrase());
            }
            String menu = menuNumberPair.split(MENU_SPLIT_VALUE)[0];
            int number = Integer.parseInt(menuNumberPair.split(MENU_SPLIT_VALUE)[1]);
            if (result.containsKey(menu)) {
                throw new IllegalArgumentException(ILLEGAL_ORDER_INPUT.getPhrase());
            }
            result.put(menu, number);
        }
        return result;
    }

    private Boolean isValidMenuNumberPairInput(String input) {
        return input.split(MENU_SPLIT_VALUE).length == 2 && isNumber(input.split(MENU_SPLIT_VALUE)[1]);
    }


}
