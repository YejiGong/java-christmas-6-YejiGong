package christmas.Global;

public enum ResultPhrase {
    RESULT_PREVIEW_OUTPUT("12월 %d에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU("<주문 메뉴>"),

    BEFORE_DISCOUNT_ORDER_PRICE("<할인 전 총주문 금액>"),

    PRESENT_MENU("<증정 메뉴>"),
    BENEFIT_INFORMATION("<혜택 내역>"),

    WHOLE_BENEFIT_PRICE("<총혜택 금액>"),

    AFTER_DISCOUNT_ORDER_PRICE("<할인 후 예상 결제 금액>"),
    EVENT_BADGE_INFORMATION("<12월 이벤트 배지>");

    private final String phrase;

    private ResultPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return this.phrase;
    }

    public String getPhrase(int date) {
        return String.format(this.phrase, date);
    }


}
