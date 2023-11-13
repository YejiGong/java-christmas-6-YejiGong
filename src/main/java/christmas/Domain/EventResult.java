package christmas.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventResult {
    private HashMap<String, Integer> presentMenu;
    private HashMap<String, Integer> benefitInformation;
    private int wholeBenefitPrice;
    private int afterDiscountOrderPrice;
    private List<String> eventBadge;

    public EventResult() {
        this.presentMenu = new HashMap<>();
        this.benefitInformation = new HashMap<>();
        this.wholeBenefitPrice = 0;
        this.afterDiscountOrderPrice = 0;
        this.eventBadge = new ArrayList<>();
    }

    public void putPresentMenu(String menu, int value) {
        this.presentMenu.put(menu, value);
    }

    public void putBenefitInformation(String information, int value) {
        this.benefitInformation.put(information, value);
    }

    public void addWholeBenefitPrice(int price) {
        this.wholeBenefitPrice += price;
    }

    public void addAfterDiscountOrderPrice(int price) {
        this.afterDiscountOrderPrice += price;
    }

    public void addEventBadge(String badge) {
        this.eventBadge.add(badge);
    }


    public Map<String, Integer> getPresentMenu() {
        return Collections.unmodifiableMap(presentMenu);
    }

    public Map<String, Integer> getBenefitInformation() {
        return Collections.unmodifiableMap(benefitInformation);
    }

    public int getWholeBenefitPrice() {
        return wholeBenefitPrice;
    }

    public int getAfterDiscountOrderPrice() {
        return afterDiscountOrderPrice;
    }

    public List<String> getEventBadge() {
        return Collections.unmodifiableList(eventBadge);
    }
}
