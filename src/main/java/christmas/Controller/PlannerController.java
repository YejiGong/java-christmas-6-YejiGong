package christmas.Controller;

import christmas.Model.Order;
import christmas.View.View;
import java.util.HashMap;
import java.util.List;

public class PlannerController {

    private View view;
    private Order order;

    public PlannerController(View view, Order order) {
        this.view = view;
        this.order = order;
    }

    public void run() {
        view.putGreetings();
        int date = getDate();
        HashMap<String, Integer> orderMenu = getMenu();
        HashMap<String, List<String>> orderResult = getOrder(orderMenu);
        view.printOrderResult(date, orderResult);
    }

    private int getDate() {
        try {
            int date = view.getVisitDate();
            return date;
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            return getDate();
        }
    }

    private HashMap<String, Integer> getMenu() {
        try {
            HashMap<String, Integer> orderMenu = view.getMenuOrder();
            return orderMenu;
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            return getMenu();
        }
    }

    private HashMap<String, List<String>> getOrder(HashMap<String, Integer> orderMenu) {
        try {
            HashMap<String, List<String>> orderResult = order.order(orderMenu);
            return orderResult;
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            return getOrder(getMenu());
        }
    }
}
