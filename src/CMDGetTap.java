import menu.Menu;
import menu.MenuItem;
import orders.OrderItem;
import orders.Orders;

public class CMDGetTap implements Command<Tab> {
    private Aggregator aggregator;
    private int tableId;

    public CMDGetTap(Aggregator aggregator, int tableId) {
        this.aggregator = aggregator;
        this.tableId = tableId;
    }

    @Override
    public Tab execute() {
        if (tableId > 0 && tableId <= aggregator.getCustomers().getOrderingListSize()) {
            Menu menu = aggregator.getMenu();
            Orders orders = aggregator.getCustomers().searchItem(tableId).getTable().getOrders();
            return new Tab(menu,orders);
        } else {
            return null;
        }
    }
}
