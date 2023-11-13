package christmas.Model;

import java.util.ArrayList;
import java.util.List;

public class EventsRegistry {
    private static List<Class<? extends DiscountEvent>> discountEventRegistry = new ArrayList<>();
    private static List<Class<? extends PresentationEvent>> presentationEventRegistry = new ArrayList<>();
    private static List<Class<? extends EtcEvent>> etcEventRegistry = new ArrayList<>();

    static {
        discountEventRegistry.add(WeekendDiscount.class);
        discountEventRegistry.add(WeeklyDiscount.class);
        discountEventRegistry.add(ChristmasDiscount.class);
        discountEventRegistry.add(SpecialDiscount.class);
        presentationEventRegistry.add(ChampagnePresentationEvent.class);
        etcEventRegistry.add(BadgeEtcEvent.class);
    }

    public List<Class<? extends DiscountEvent>> getDiscountEventRegistry() {
        return discountEventRegistry;
    }

    public List<Class<? extends PresentationEvent>> getPresentationEventRegistry() {
        return presentationEventRegistry;
    }

    public List<Class<? extends EtcEvent>> getEtcEventRegistry() {
        return etcEventRegistry;
    }
}
