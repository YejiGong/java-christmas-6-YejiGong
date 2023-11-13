package christmas.Model;

import static christmas.Global.Constants.EVENT_CRITERIA_MONTH;
import static christmas.Global.Constants.EVENT_CRITERIA_YEAR;
import static christmas.Global.Constants.WEEKLY_EVENT_DISCOUNT_AMOUNT;
import static christmas.Global.Constants.WEEKLY_EVENT_MENU_TYPE;

import christmas.Global.Menu;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;

public class WeeklyDiscount implements DiscountEvent {
    @Override
    public String getName() {
        return "평일 할인";
    }

    @Override
    public int getEventResult(int date, HashMap<String, Integer> orderMenu) {
        if (checkInEvent(date)) {
            return getDiscountAmount(orderMenu);
        }
        return 0;
    }

    private boolean checkInEvent(int date) {
        DayOfWeek day = LocalDate.of(EVENT_CRITERIA_YEAR, EVENT_CRITERIA_MONTH, date).getDayOfWeek();
        return day.compareTo(DayOfWeek.SUNDAY) == 0 || day.compareTo(DayOfWeek.THURSDAY) <= 0;
    }

    private int getDiscountAmount(HashMap<String, Integer> orderMenu) {
        int num = orderMenu.keySet().stream().filter(val -> Menu.valueOf(val).type.equals(WEEKLY_EVENT_MENU_TYPE))
                .mapToInt(val -> orderMenu.get(val)).sum();
        return num * WEEKLY_EVENT_DISCOUNT_AMOUNT;
    }
}
