package christmas.Global;

import static christmas.Global.MenuType.APPETIZER;
import static christmas.Global.MenuType.DESSERT;
import static christmas.Global.MenuType.DRINK;
import static christmas.Global.MenuType.MAIN;

public enum Menu {
    양송이수프(APPETIZER.name, 6000),
    타파스(APPETIZER.name, 5500),
    시저샐러드(APPETIZER.name, 8000),
    티본스테이크(MAIN.name, 55000),
    바비큐립(MAIN.name, 54000),
    해산물파스타(MAIN.name, 35000),
    크리스마스파스타(MAIN.name, 25000),
    초코케이크(DESSERT.name, 15000),
    아이스크림(DESSERT.name, 5000),
    제로콜라(DRINK.name, 3000),
    레드와인(DRINK.name, 60000),
    샴페인(DRINK.name, 25000);

    public final String type;
    public final int price;

    private Menu(String type, int price) {
        this.type = type;
        this.price = price;
    }

}
