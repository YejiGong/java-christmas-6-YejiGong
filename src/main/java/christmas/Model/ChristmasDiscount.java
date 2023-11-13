package christmas.Model;

import static christmas.Global.Constants.CHRISTMAS_EVENT_BASE_AMOUNT;
import static christmas.Global.Constants.CHRISTMAS_EVENT_DISCOUNT_AMOUNT;
import static christmas.Global.Constants.CHRISTMAS_EVENT_PERIOD_END_DAY;
import static christmas.Global.Constants.CHRISTMAS_EVENT_PERIOD_START_DAY;

import java.util.HashMap;

public class ChristmasDiscount implements DiscountEvent {

    @Override
    public String getName() {
        return "크리스마스 디데이 할인";
    }

    @Override
    public int getEventResult(int date, HashMap<String, Integer> orderMenu) {
        if (checkInEventPeriod(date)) {
            return getDiscountAmount(date);
        }
        return 0;
    }

    private Boolean checkInEventPeriod(int date) {
        return date >= CHRISTMAS_EVENT_PERIOD_START_DAY && CHRISTMAS_EVENT_PERIOD_END_DAY <= date;
    }

    private int getDiscountAmount(int date) {
        return CHRISTMAS_EVENT_BASE_AMOUNT + (CHRISTMAS_EVENT_DISCOUNT_AMOUNT * (date - 1));
    }
}
