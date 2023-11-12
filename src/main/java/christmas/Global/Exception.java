package christmas.Global;

public enum Exception {
    ILLEGAL_DATE_INPUT("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ILLEGAL_ORDER_INPUT("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String errorPhrase;

    private Exception(String errorPhrase) {
        this.errorPhrase = errorPhrase;
    }

    public String getPhrase() {
        return this.errorPhrase;
    }
}
