package christmas.Model;

import christmas.Global.Badge;

public class BadgeEtcEvent implements EtcEvent {

    @Override
    public String getEventResult(int benefitAmount) {
        String result = "";
        for (Badge badge : Badge.values()) {
            if (benefitAmount >= badge.price) {
                result = badge.name();
            }
        }
        return result;
    }
}
