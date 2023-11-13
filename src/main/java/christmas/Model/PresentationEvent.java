package christmas.Model;

import java.util.HashMap;

public interface PresentationEvent {
    public String getName();

    public String getPresentName();

    public int getPresentPrice();

    public int getEventResult(int date, HashMap<String, Integer> orderMenu);
}
