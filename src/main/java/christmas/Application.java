package christmas;

import christmas.Controller.PlannerController;
import christmas.Model.EventChecker;
import christmas.Model.EventsRegistry;
import christmas.Model.Order;
import christmas.View.InputView;
import christmas.View.OutputView;
import christmas.View.View;

public class Application {
    public static void main(String[] args) {
        View view = new View(new InputView(), new OutputView());
        Order order = new Order(new EventChecker(new EventsRegistry()));
        PlannerController plannerController = new PlannerController(view, order);
        plannerController.run();
        // TODO: 프로그램 구현
    }
}
