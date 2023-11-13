package christmas.Model;

import static christmas.Global.Constants.EVENT_CRITERIA_MONTH;
import static christmas.Global.Constants.EVENT_CRITERIA_YEAR;
import static christmas.Global.Constants.WEEKEND_EVENT_DISCOUNT_AMOUNT;
import static christmas.Global.Constants.WEEKEND_EVENT_MENU_TYPE;

import christmas.Global.Menu;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;

public class WeekendDiscount implements DiscountEvent {
    @Override
    public String getName() {
        return "주말 할인";
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
        return day.compareTo(DayOfWeek.FRIDAY) >= 0 && day.compareTo(DayOfWeek.SATURDAY) <= 0;
    }

    private int getDiscountAmount(HashMap<String, Integer> orderMenu) {
        int num = orderMenu.keySet().stream().filter(val -> Menu.valueOf(val).type.equals(WEEKEND_EVENT_MENU_TYPE))
                .mapToInt(val -> orderMenu.get(val)).sum();
        return num * WEEKEND_EVENT_DISCOUNT_AMOUNT;
    }
}
