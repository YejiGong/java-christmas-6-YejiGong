package christmas.Model;

import static christmas.Global.ResultPhrase.AFTER_DISCOUNT_ORDER_PRICE;
import static christmas.Global.ResultPhrase.BENEFIT_INFORMATION;
import static christmas.Global.ResultPhrase.EVENT_BADGE_INFORMATION;
import static christmas.Global.ResultPhrase.PRESENT_MENU;
import static christmas.Global.ResultPhrase.WHOLE_BENEFIT_PRICE;
import static christmas.Global.SubResultPhrase.BENEFIT_VALUE_NUMBER;
import static christmas.Global.SubResultPhrase.DISCOUNT_MONEY_OUTPUT;
import static christmas.Global.SubResultPhrase.MONEY_OUTPUT;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventChecker {
    private HashMap<String, List<String>> result;
    private Price price;

    public EventChecker() {
        this.result = new HashMap<>();
        result.put(PRESENT_MENU.getPhrase(), new ArrayList<>());
        result.put(BENEFIT_INFORMATION.getPhrase(), new ArrayList<>());
        result.put(WHOLE_BENEFIT_PRICE.getPhrase(), new ArrayList<>());
        result.put(AFTER_DISCOUNT_ORDER_PRICE.getPhrase(), new ArrayList<>());
        result.put(EVENT_BADGE_INFORMATION.getPhrase(), new ArrayList<>());
        this.price = new Price();
    }

    private class Price {
        private int benefitPrice;
        private int discountPrice;

        public Price() {
            this.benefitPrice = 0;
            this.discountPrice = 0;
        }

        public void updateBenefitPrice(int amount) {
            this.benefitPrice += amount;
        }

        public void updateDiscountPrice(int amount) {
            this.discountPrice += amount;
        }

        public void setResult(int sumOfPrice) {
            result.put(WHOLE_BENEFIT_PRICE.getPhrase(),
                    List.of(DISCOUNT_MONEY_OUTPUT.getPhraseMoney(this.benefitPrice)));
            result.put(AFTER_DISCOUNT_ORDER_PRICE.getPhrase(),
                    List.of(MONEY_OUTPUT.getPhraseMoney(sumOfPrice - this.discountPrice)));
        }
    }

    public HashMap<String, List<String>> eventCheck(int date, int sumOfPrice, HashMap<String, Integer> orderMenu) {
        checkBenefitAvailableEvent(date, orderMenu);
        price.setResult(sumOfPrice);
        return result;
    }

    private void checkBenefitAvailableEvent(int date, HashMap<String, Integer> orderMenu) {
        checkDiscountEvent(date, orderMenu);
        checkPresentationEvent(date, orderMenu);
        checkEtcEvent(date, orderMenu);
    }

    private HashMap<String, List<String>> checkDiscountEvent(int date, HashMap<String, Integer> orderMenu)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EventsRegistry eventsRegistry = new EventsRegistry();
        DiscountEvent discountEvent;
        List<Class<? extends DiscountEvent>> discountEvents = eventsRegistry.getDiscountEventRegistry();
        for (Class<? extends DiscountEvent> event : discountEvents) {
            discountEvent = event.getDeclaredConstructor().newInstance();
            int discountResult = discountEvent.getEventResult(date, orderMenu);
            result.put(BENEFIT_INFORMATION.getPhrase(),
                    BENEFIT_VALUE_NUMBER.getPhrase(discountEvent.getName(), event.getEventResult(date, orderMenu)));
            price.updateDiscountPrice(discountResult);
            price.updateBenefitPrice(discountResult);
        }
    }

    private HashMap<String, List<String>> checkPresentationEvent(int date, HashMap<String, Integer> orderMenu)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EventsRegistry eventsRegistry = new EventsRegistry();
        PresentationEvent presentationEvent;
        List<Class<? extends PresentationEvent>> presentationEvents = eventsRegistry.getPresentationEventRegistry();
        for (Class<? extends PresentationEvent> event : presentationEvents) {
            presentationEvent = event.getDeclaredConstructor().newInstance();
            int discountResult = presentationEvents.getEventResult(date, orderMenu);
            result.put(BENEFIT_INFORMATION.getPhrase(),
                    BENEFIT_VALUE_NUMBER.getPhrase(presentationEvent.getName(), discountResult));
            price.updateBenefitPrice(discountResult);

        }
    }

    private HashMap<String, List<String>> checkEtcEvent(int date, HashMap<String, Integer> orderMenu)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EventsRegistry eventsRegistry = new EventsRegistry();
        EtcEvent etcEvent;
        List<Class<? extends EtcEvent>> etcEvents = eventsRegistry.getEtcEventRegistry();
        for (Class<? extends EtcEvent> event : etcEvents) {
            etcEvent = event.getDeclaredConstructor().newInstance();
            result.put(etcEvent.getEventPhrase(), etcEvent.getEventResult(date, orderMenu));
        }
    }
}
