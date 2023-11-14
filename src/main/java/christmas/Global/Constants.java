package christmas.Global;

import static christmas.Global.MenuType.DESSERT;
import static christmas.Global.MenuType.MAIN;

import java.text.DecimalFormat;

public class Constants {
    public static final int DATE_MIN_RANGE = 0;
    public static final int DATE_MAX_RANGE = 31;
    public static final String INPUT_SPLIT_VALUE = ",";
    public static final String MENU_SPLIT_VALUE = "-";
    public static final int ORDER_LIMIT_VALUE = 20;
    public static final DecimalFormat MONEY_FORMATTER = new DecimalFormat("###,###");
    public static final int EVENT_MINIMUM_PRICE = 10000;
    public static final int CHRISTMAS_EVENT_PERIOD_START_DAY = 1;
    public static final int CHRISTMAS_EVENT_PERIOD_END_DAY = 25;
    public static final int CHRISTMAS_EVENT_BASE_AMOUNT = 1000;
    public static final int CHRISTMAS_EVENT_DISCOUNT_AMOUNT = 100;
    public static final int EVENT_CRITERIA_YEAR = 2023;
    public static final int EVENT_CRITERIA_MONTH = 12;
    public static final String WEEKLY_EVENT_MENU_TYPE = DESSERT.name;
    public static final int WEEKLY_EVENT_DISCOUNT_AMOUNT = 2023;
    public static final String WEEKEND_EVENT_MENU_TYPE = MAIN.name;
    public static final int WEEKEND_EVENT_DISCOUNT_AMOUNT = 2023;
    public static final int SPECIAL_EVENT_DISCOUNT_AMOUNT = 1000;
    public static final int CHAMPAGNE_PRESENTATION_EVENT_CRITERIA_PRICE = 120000;
}
