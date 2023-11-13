package christmas.Model;

import static christmas.Global.Constants.CHAMPAGNE_PRESENTATION_EVENT_CRITERIA_PRICE;
import static christmas.Global.Menu.샴페인;

import java.util.HashMap;

public class ChampagnePresentationEvent implements PresentationEvent {
    @Override
    public String getName() {
        return "증정 이벤트";
    }

    @Override
    public String getPresentName() {
        return 샴페인.name();
    }

    @Override
    public int getPresentPrice() {
        return 샴페인.price;
    }

    @Override
    public int getEventResult(int amount, HashMap<String, Integer> orderMenu) {
        ;
        if (isTargetOfEvent(amount)) {
            return getPresentationMenuAmount(amount);
        }
        return 0;
    }

    private boolean isTargetOfEvent(int amount) {
        return amount >= CHAMPAGNE_PRESENTATION_EVENT_CRITERIA_PRICE;
    }

    private int getPresentationMenuAmount(int amount) {
        return 1;
    }
}
