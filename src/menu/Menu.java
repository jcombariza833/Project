package menu;

import menu.pizza.*;
import observer.Observer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Menu {
    private HashMap<Integer, MenuItem> menuItems;
    private PizzaDirector director;

    public Menu() {
        menuItems = new HashMap<>();
        director = new PizzaDirector();
        populateMenu();
    }

    public void add(MenuItem menuItem) {
        menuItems.put(menuItem.getNumber(), menuItem);
    }

    public void deleteItem(int number) {
        menuItems.remove(number);
    }

    public MenuItem searchItem(int number) {
        return menuItems.get(number);
    }

    public int getMenuSize() {
        return menuItems.size();
    }

    public Iterator<Map.Entry<Integer, MenuItem>> getIterator() {
        return menuItems.entrySet().iterator();
    }

    private void populateMenu() {
        add(new MenuItem(1,"Chicken Pizza", 7.50f, createPizza(1)));
        add(new MenuItem(2, "Four Cheeses Pizza", 8.00f, createPizza(2)));
        add(new MenuItem(3,"Italian Pizza", 7.50f, createPizza(3)));
        add(new MenuItem(4,"Pepperoni Pizza", 8.00f, createPizza(4)));
        add(new MenuItem(5,"Premium Pizza", 10.00f, createPizza(5)));
        add(new MenuItem(6,"Special Pizza", 10.00f, createPizza(6)));
    }

    private Pizza createPizza(int id) {
        PizzaBuilder builder = null;

        switch (id) {
            case 1: builder = new ChickenPizzaBuilder(); break;
            case 2: builder = new FourCheesePizzaBuilder(); break;
            case 3: builder = new ItalianPizzaBuilder(); break;
            case 4: builder = new PepperoniPizzaBuilder(); break;
            case 5: builder = new PremiumPizzaBuilder(); break;
            case 6: builder = new SpecialPizzaBuilder(); break;
        }

        director.makePizza(builder);

        return builder.getPizza();
    }
}
