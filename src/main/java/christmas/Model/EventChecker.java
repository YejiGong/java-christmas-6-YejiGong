package christmas.Model;

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
        checkBenefitAvailableEvent(date, result.getBeforeDiscountOrderPrice(), new HashMap<>(result.getOrderMenu()));
        return eventResult;
    }

    private void checkBenefitAvailableEvent(int date, int sumOfPrice, HashMap<String, Integer> orderMenu) {
        checkDiscountEvent(date, orderMenu);
        checkPresentationEvent(date, orderMenu);
        checkEtcEvent(date, sumOfPrice);
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

    private void checkPresentationEvent(int date, HashMap<String, Integer> orderMenu) {
        List<PresentationEvent> presentationEvents = eventsRegistry.getPresentationEventRegistry();
        for (PresentationEvent event : presentationEvents) {
            int discountResult = event.getEventResult(date, orderMenu);
            eventResult.putBenefitInformation(event.getName(), discountResult);
            eventResult.addWholeBenefitPrice(discountResult);

        }
    }

    private void checkEtcEvent(int date, int sumOfPrice) {
        List<EtcEvent> etcEvents = eventsRegistry.getEtcEventRegistry();
        for (EtcEvent event : etcEvents) {
            eventResult.addEventBadge(event.getEventResult(date, sumOfPrice));
        }
    }
}
