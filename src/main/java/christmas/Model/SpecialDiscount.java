package christmas.Model;

import static christmas.Global.Constants.SPECIAL_EVENT_DISCOUNT_AMOUNT;

import java.util.HashMap;
import java.util.List;

public class SpecialDiscount implements DiscountEvent {
    private List<Integer> daysOfSpecialEvent = List.of(3, 10, 17, 24, 25, 31);

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getEventResult(int date, HashMap<String, Integer> orderMenu) {
        if (checkInEvent(date)) {
            return getDiscountAmount(orderMenu);
        }
        return 0;
    }

    private boolean checkInEvent(int date) {
        return daysOfSpecialEvent.contains(date);
    }

    private int getDiscountAmount(HashMap<String, Integer> orderMenu) {
        return SPECIAL_EVENT_DISCOUNT_AMOUNT;
    }
}
