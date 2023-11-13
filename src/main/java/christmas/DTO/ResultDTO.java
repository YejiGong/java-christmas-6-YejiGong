package christmas.DTO;

import static christmas.Global.SubResultPhrase.BENEFIT_VALUE_NUMBER;
import static christmas.Global.SubResultPhrase.DISCOUNT_MONEY_OUTPUT;
import static christmas.Global.SubResultPhrase.MENU_VALUE_NUMBER;
import static christmas.Global.SubResultPhrase.MONEY_OUTPUT;

import java.util.HashMap;
import java.util.List;

public class ResultDTO {
    private HashMap<String, Integer> orderMenu;
    private int beforeDiscountOrderPrice;
    private HashMap<String, Integer> presentMenu;
    private HashMap<String, Integer> benefitInformation;
    private int wholeBenefitPrice;
    private int afterDiscountOrderPrice;
    private List<String> eventBadge;

    public ResultDTO(HashMap<String, Integer> orderMenu, int beforeDiscountOrderPrice,
                     HashMap<String, Integer> presentMenu,
                     HashMap<String, Integer> benefitInformation, int wholeBenefitPrice, int afterDiscountOrderPrice,
                     List<String> eventBadge) {
        this.orderMenu = orderMenu;
        this.beforeDiscountOrderPrice = beforeDiscountOrderPrice;
        this.presentMenu = presentMenu;
        this.benefitInformation = benefitInformation;
        this.wholeBenefitPrice = wholeBenefitPrice;
        this.afterDiscountOrderPrice = afterDiscountOrderPrice;
        this.eventBadge = eventBadge;
    }


    public String getOrderMenu() {
        StringBuilder sb = new StringBuilder();
        for (String menu : orderMenu.keySet()) {
            sb.append(MENU_VALUE_NUMBER.getPhrase(menu, orderMenu.get(menu)));
            sb.append("\n");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public String getBeforeDiscountOrderPrice() {
        return MONEY_OUTPUT.getPhraseMoney(beforeDiscountOrderPrice);
    }

    public String getPresentMenu() {
        if (presentMenu.isEmpty()) {
            return "없음";
        }
        StringBuilder sb = new StringBuilder();
        for (String menu : presentMenu.keySet()) {
            sb.append(MENU_VALUE_NUMBER.getPhrase(menu, presentMenu.get(menu)));
            sb.append("\n");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public String getBenefitInformation() {
        if (benefitInformation.isEmpty()) {
            return "없음";
        }
        StringBuilder sb = new StringBuilder();
        for (String benefit : benefitInformation.keySet()) {
            sb.append(BENEFIT_VALUE_NUMBER.getPhraseMoney(benefit, benefitInformation.get(benefit)));
            sb.append("\n");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public String getWholeBenefitPrice() {
        if (wholeBenefitPrice == 0) {
            return MONEY_OUTPUT.getPhraseMoney(wholeBenefitPrice);
        }
        return DISCOUNT_MONEY_OUTPUT.getPhraseMoney(wholeBenefitPrice);
    }

    public String getAfterDiscountOrderPrice() {
        return MONEY_OUTPUT.getPhraseMoney(afterDiscountOrderPrice);
    }

    public String getEventBadge() {
        if (eventBadge.isEmpty()) {
            return "없음";
        }
        StringBuilder sb = new StringBuilder();
        for (String badge : eventBadge) {
            sb.append(badge);
            sb.append("\n");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
