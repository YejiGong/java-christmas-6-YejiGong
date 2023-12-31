package christmas.Controller;

import christmas.DTO.ResultDTO;
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
        view.putGreetings();
        int date = getDate();
        HashMap<String, Integer> orderMenu = getMenu();
        ResultDTO orderResult = getOrder(date, orderMenu);
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

    private ResultDTO getOrder(int date, HashMap<String, Integer> orderMenu) {
        try {
            ResultDTO resultDTO = order.order(date, orderMenu);
            return resultDTO;
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            return getOrder(date, getMenu());
        }
    }
}
