package christmas.Model;

import java.util.HashMap;

public class ChampagnePresentationEvent implements PresentationEvent {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getEventResult(int date, HashMap<String, Integer> orderMenu) {
        return 0;
    }
}
