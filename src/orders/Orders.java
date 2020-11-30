package orders;

import menu.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;

public class Orders {
    private ArrayList<OrderItem> orderItems;

    public Orders() {
        orderItems = new ArrayList<>();
    }

    public void add(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void deleteItem(int number) {
        orderItems.removeIf(item -> (item.getNumber() == number));
    }

    public int getOrdersSize() {
        return orderItems.size();
    }

    public Iterator<OrderItem> getIterator() {
        return orderItems.iterator();
    }
}
