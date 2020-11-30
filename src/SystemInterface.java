import menu.Menu;
import menu.MenuItem;
import menu.decorator.IngredientsItemDecorator;
import menu.decorator.ItemDescription;
import menu.decorator.MenuItemDecorator;
import menu.decorator.OutStockItemDecorator;
import menu.inventory.Inventory;
import menu.inventory.StockItem;
import orders.OrderItem;
import parties.Customers;
import parties.Party;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class SystemInterface {
    private static Invoker invoker;

    public static void setInvoker(Invoker invoker) {
        SystemInterface.invoker = invoker;
    }

    public static String[] getMenu() {
        Menu menu = invoker.getMenu();
        Inventory inventory = invoker.getInventory();
        Iterator<Map.Entry<Integer, MenuItem>> iMenu = menu.getIterator();

        String[] items = new String[menu.getMenuSize()];
        int index = 0;
        
        while (iMenu.hasNext()) {
            Map.Entry dictionary = iMenu.next();
            MenuItem item = (MenuItem) dictionary.getValue();
            ItemDescription decorator = item;
            int[] ingredients = item.getPizza().getIngredients();

            boolean isOutOfStock = false;
            for (int i: ingredients) {
                isOutOfStock = !inventory.isItemInStock(i);
                if(isOutOfStock) break;
            }

            if (isOutOfStock) {
                decorator = new OutStockItemDecorator(decorator);
            }

            decorator = new IngredientsItemDecorator(decorator, inventory, ingredients);

            String output = String.format("\t%s",decorator.getItemDescription());
            items[index++] = output;
        }

        return items;
    }

    public static String[] getInventory() {
        Inventory inventory = invoker.getInventory();
        Iterator<Map.Entry<Integer, StockItem>> i = inventory.getIterator();

        String[] items = new String[inventory.getInventorySize()];
        int index = 0;

        while (i.hasNext()) {
            Map.Entry dictionary = i.next();
            StockItem item = (StockItem) dictionary.getValue();
            String output = String.format("\t%d - %s : %d", item.getNumber(), item.getName(), item.getAmount());
            items[index++] = output ;
        }

        return items;
    }

    public static String[] getParties() {
        Customers customers = invoker.getParties();
        Iterator<Party> i = customers.getIterator();

        String[] items = new String[customers.getOrderingListSize()];
        int index = 0;

        while (i.hasNext()) {
            Party item = i.next();
            String output = String.format("\t%d - %d people - %s", item.getNumber(), item.getPeople(), item.getTable().tableDescription());
            items[index++] = output ;
        }

        return items;
    }

    public static String[] getTab(int partyId) {
        Tab tab = invoker.getTab(partyId);
        if(tab == null) return new String[] {" The party does not exist"};

        String[] items = new String[tab.getItemsSize() + 1];
        Iterator<MenuItem> iterator = tab.getIterator();

        int index = 0;
        float total =0.0f;

        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            items[index++] = String.format("\t%sf", item);;
            total = total + item.getPrice();
        }

        items[index] = String.format("\tTOTAL: .... $%.2f", total);

        return items;
    }

    public static String[] placeOrder(int item, int tableId) {
        Verification verification = invoker.placeOrder(item, tableId);

        return new String[]{ verification.getMessage() };
    }

    public static String[] payTab(int tableId) {
        Verification verification = invoker.payTab(tableId);

        return new String[]{ verification.getMessage() };
    }

    public static String[] requestTable(int people) {
        Verification verification = invoker.requestTable(people);

        return new String[]{ verification.getMessage() };
    }
}
