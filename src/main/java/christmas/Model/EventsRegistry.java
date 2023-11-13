package christmas.Model;

import java.util.ArrayList;
import java.util.List;

public class EventsRegistry {
    private static List<DiscountEvent> discountEventRegistry = new ArrayList<>();
    private static List<PresentationEvent> presentationEventRegistry = new ArrayList<>();
    private static List<EtcEvent> etcEventRegistry = new ArrayList<>();

    static {
        discountEventRegistry.add(new WeekendDiscount());
        discountEventRegistry.add(new WeeklyDiscount());
        discountEventRegistry.add(new ChristmasDiscount());
        discountEventRegistry.add(new SpecialDiscount());
        presentationEventRegistry.add(new ChampagnePresentationEvent());
        etcEventRegistry.add(new BadgeEtcEvent());
    }

    public List<DiscountEvent> getDiscountEventRegistry() {
        return discountEventRegistry;
    }

    public List<PresentationEvent> getPresentationEventRegistry() {
        return presentationEventRegistry;
    }

    public List<EtcEvent> getEtcEventRegistry() {
        return etcEventRegistry;
    }
}
