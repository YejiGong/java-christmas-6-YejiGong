package christmas.Model;

import static christmas.Global.Constants.EVENT_MINIMUM_PRICE;

import christmas.Domain.EventResult;
import christmas.Domain.Result;
import java.util.HashMap;
import java.util.List;

public class EventChecker {
    private EventResult eventResult;
    private EventsRegistry eventsRegistry;

    public EventChecker(EventsRegistry eventsRegistry) {
        this.eventResult = new EventResult();
        this.eventsRegistry = eventsRegistry;
    }


    public EventResult eventCheck(int date, Result result) {
        if (checkEventAvailable(result.getBeforeDiscountOrderPrice())) {
            checkBenefitAvailableEvent(date, result.getBeforeDiscountOrderPrice(),
                    new HashMap<>(result.getOrderMenu()));
        }
        return eventResult;
    }

    private Boolean checkEventAvailable(int sumOfPrice) {
        return sumOfPrice >= EVENT_MINIMUM_PRICE;
    }

    private void checkBenefitAvailableEvent(int date, int sumOfPrice, HashMap<String, Integer> orderMenu) {
        checkDiscountEvent(date, orderMenu);
        checkPresentationEvent(sumOfPrice, orderMenu);
        checkEtcEvent(eventResult.getWholeBenefitPrice());
    }

    private void checkDiscountEvent(int date, HashMap<String, Integer> orderMenu) {
        List<DiscountEvent> discountEvents = eventsRegistry.getDiscountEventRegistry();
        for (DiscountEvent event : discountEvents) {
            int discountResult = event.getEventResult(date, orderMenu);
            eventResult.putBenefitInformation(event.getName(), discountResult);
            eventResult.addAfterDiscountOrderPrice(discountResult);
            eventResult.addWholeBenefitPrice(discountResult);
        }
    }

    private void checkPresentationEvent(int sumOfPrice, HashMap<String, Integer> orderMenu) {
        List<PresentationEvent> presentationEvents = eventsRegistry.getPresentationEventRegistry();
        for (PresentationEvent event : presentationEvents) {
            int discountResult = event.getEventResult(sumOfPrice, orderMenu);
            if (discountResult > 0) {
                eventResult.putPresentMenu(event.getPresentName(), discountResult);
                eventResult.putBenefitInformation(event.getName(), discountResult * event.getPresentPrice());
                eventResult.addWholeBenefitPrice(discountResult * event.getPresentPrice());
            }
        }
    }

    private void checkEtcEvent(int benefitPrice) {
        List<EtcEvent> etcEvents = eventsRegistry.getEtcEventRegistry();
        for (EtcEvent event : etcEvents) {
            String result = event.getEventResult(benefitPrice);
            if (!result.isEmpty()) {
                eventResult.addEventBadge(result);
            }
        }
    }
}
