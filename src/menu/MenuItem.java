package menu;

import menu.decorator.ItemDescription;
import menu.pizza.Pizza;

public class MenuItem implements ItemDescription {
    private int number;
    private String name;
    private float price;
    private Pizza pizza;

    public MenuItem(int number, String name, float price, Pizza pizza) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.pizza = pizza;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Pizza getPizza() {
        return pizza;
    }

    @Override
    public String toString() {
        return String.format("%d - %s .... $%.2f",getNumber(), getName(), getPrice());
    }

    @Override
    public String getItemDescription() {
        return String.format("%d - %s .... $%.2f",getNumber(), getName(), getPrice());
    }
}
