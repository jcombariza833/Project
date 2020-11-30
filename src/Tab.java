import menu.Menu;
import menu.MenuItem;
import orders.OrderItem;
import orders.Orders;

import java.util.ArrayList;
import java.util.Iterator;

public class Tab {
    private ArrayList<MenuItem> menuItems;

    public Tab(Menu menu, Orders orders) {
        this.menuItems = getMenuItems(menu,orders);
    }

    public int getItemsSize() {
        return menuItems.size();
    }

    public Iterator<MenuItem> getIterator() {
        return menuItems.iterator();
    }

    private ArrayList<MenuItem> getMenuItems(Menu menu, Orders orders) {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        Iterator<OrderItem> iterator = orders.getIterator();

        while (iterator.hasNext()) {
            int orderInMenu = iterator.next().getNumber();
            MenuItem item = menu.searchItem(orderInMenu);
            menuItems.add(item);
        }

        return  menuItems;
    }
}
