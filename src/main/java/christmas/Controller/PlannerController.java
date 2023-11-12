package christmas.Controller;

import christmas.Model.Order;
import christmas.View.View;
import java.util.HashMap;

public class PlannerController {
    private View view;
    private Order order;

    public PlannerController(View view, Order order) {
        this.view = view;
        this.order = order;
    }

    public void run() {
        int date = getDate();
        HashMap<String, Integer> orderMenu = getMenu();
        HashMap<String, String> orderResult = getOrder(orderMenu);
        View.printOrderResult(date, orderResult);
    }

    private int getDate() {
        try {
            int date = View.getVisitDate();
            return date;
        } catch (IllegalArgumentException e) {
            View.printError(e.getMessage());
            return getDate();
        }
    }

    private HashMap<String, Integer> getMenu() {
        try {
            HashMap<String, Integer> orderMenu = View.getMenuOrder();
            return orderMenu;
        } catch (IllegalArgumentException e) {
            View.printError(e.getMessage());
            return getMenu();
        }
    }

    private HashMap<String, String> getOrder(HashMap<String, Integer> orderMenu) {
        try {
            HashMap<String, String> orderResult = Order.order(orderMenu);
            return orderResult;
        } catch (IllegalArgumentException e) {
            View.printError(e.getMessage());
            return getOrder(getMenu());
        }
    }
}
