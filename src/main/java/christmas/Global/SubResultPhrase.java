package christmas.Global;

import static christmas.Global.Constants.MONEY_FORMATTER;

public enum SubResultPhrase {
    MENU_VALUE_NUMBER("%s %d개"),
    MONEY_OUTPUT("%s원"),
    BENEFIT_VALUE_NUMBER("%s 할인: -%s원"),
    DISCOUNT_MONEY_OUTPUT("-%s원");
    private final String phrase;

    private SubResultPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase(String menu, int number) {
        return String.format(this.phrase, menu, number);
    }

    public String getPhraseMoney(int money) {
        return String.format(this.phrase, MONEY_FORMATTER.format(money));
    }

    public String getPhraseMoney(String benefit, int money) {
        return String.format(this.phrase, benefit, MONEY_FORMATTER.format(money));
    }

}
