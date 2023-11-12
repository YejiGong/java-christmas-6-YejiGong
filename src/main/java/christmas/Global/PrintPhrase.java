package christmas.Global;

public enum PrintPhrase {
    GREETING("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    VISIT_INPUT_NOTICE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    MENU_ORDER_INPUT_NOTICE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1)");


    private final String phrase;

    private PrintPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return this.phrase;
    }

}
