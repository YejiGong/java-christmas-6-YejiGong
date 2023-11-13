package christmas.Model;

import static christmas.Global.Constants.ORDER_LIMIT_VALUE;
import static christmas.Global.Exception.ILLEGAL_ORDER_INPUT;
import static christmas.Global.MenuType.DRINK;
import static christmas.Global.ResultPhrase.BEFORE_DISCOUNT_ORDER_PRICE;
import static christmas.Global.SubResultPhrase.MONEY_OUTPUT;

import christmas.Global.Menu;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private EventChecker eventChecker;

    public Order(EventChecker eventChecker) {
        this.eventChecker = eventChecker;
    }

    public HashMap<String, List<String>> order(int date, HashMap<String, Integer> orderMenu) {
        if (!isValidOrder(orderMenu)) {
            throw new IllegalArgumentException(ILLEGAL_ORDER_INPUT.getPhrase());
        }
        HashMap<String, List<String>> result = new HashMap<>();
        int priceSumOfOrder = getSumOfOrder(orderMenu);
        result.put(BEFORE_DISCOUNT_ORDER_PRICE.getPhrase(), List.of(MONEY_OUTPUT.getPhraseMoney(priceSumOfOrder)));
        result.putAll(eventChecker.eventCheck(date, priceSumOfOrder, orderMenu));
        return result;
    }

    private Boolean isValidOrder(HashMap<String, Integer> orderMenu) {
        return isExitMenus(orderMenu) && isMenuUnderLimit(orderMenu) && isNotOnlyDrink(orderMenu);
    }

    private Boolean isExitMenus(HashMap<String, Integer> orderMenu) {
        List<String> realOrderMenus = Arrays.stream(Menu.values()).map(menu -> menu.toString()).toList();
        for (String menu : orderMenu.keySet()) {
            if (!realOrderMenus.contains(menu)) {
                return false;
            }
        }
        return true;
    }

    private Boolean isMenuUnderLimit(HashMap<String, Integer> orderMenu) {
        return orderMenu.values().stream().mapToInt(Integer::intValue).sum() <= ORDER_LIMIT_VALUE;
    }

    private Boolean isNotOnlyDrink(HashMap<String, Integer> orderMenu) {
        List<String> MenuTypes = orderMenu.keySet().stream().map(menu -> Menu.valueOf(menu).type).distinct()
                .collect(Collectors.toList());
        return MenuTypes.size() > 1 || !(MenuTypes.size() == 1 && MenuTypes.get(0).equals(DRINK.name));
    }

    private int getSumOfOrder(HashMap<String, Integer> orderMenu) {
        int result = orderMenu.keySet().stream().mapToInt(menu -> Menu.valueOf(menu).price * orderMenu.get(menu)).sum();
        return result;
    }
}
