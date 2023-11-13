package christmas.Model;

import java.util.HashMap;

public interface DiscountEvent {
    public String getName();

    public int getEventResult(int date, HashMap<String, Integer> orderMenu);
}
