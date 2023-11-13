package christmas.Domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Result {
    private HashMap<String, Integer> orderMenu;
    private int beforeDiscountOrderPrice;


    public Result() {
        this.orderMenu = new HashMap<>();
        this.beforeDiscountOrderPrice = 0;

    }

    public void putOrderMenu(String menu, int value) {
        this.orderMenu.put(menu, value);
    }

    public void addBeforeDiscountOrderPrice(int price) {
        this.beforeDiscountOrderPrice += price;
    }

    public Map<String, Integer> getOrderMenu() {
        return Collections.unmodifiableMap(orderMenu);
    }

    public int getBeforeDiscountOrderPrice() {
        return beforeDiscountOrderPrice;
    }

}
