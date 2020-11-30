import menu.MenuItem;
import orders.OrderItem;

public class CMDSubmitOrder implements Command<Verification> {
    private Aggregator aggregator;
    private int item;
    private int tableId;

    public CMDSubmitOrder(Aggregator aggregator, int item, int tableId) {
        this.aggregator = aggregator;
        this.item = item;
        this.tableId = tableId;
    }

    @Override
    public Verification execute() {
        Verification verification = new Verification();
        if (tableId > 0 && tableId <= aggregator.getCustomers().getOrderingListSize()) {
            if (item > 0 && item <= aggregator.getMenu().getMenuSize()) {
                aggregator.getCustomers().searchItem(tableId).getTable().getOrders().add(new OrderItem(item));
                MenuItem menuItem = aggregator.getMenu().searchItem(item);
                int[] ingredients = menuItem.getPizza().getIngredients();
                for (int i : ingredients) {
                    aggregator.getInventory().stockItemDepletion(i);
                }
                verification.setMessage("\tYour order was placed successfully");
            } else {
                verification.setMessage("\tthe item selected does not exist or is not in the menu inventory");
            }
        } else {
            verification.setMessage("\tthe party selected does not exist");
        }
        return verification;
    }
}
