import menu.Menu;
import menu.inventory.Inventory;

public class CMDGetInventory implements Command<Inventory> {
    private Aggregator aggregator;

    public CMDGetInventory(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @Override
    public Inventory execute() {
        return aggregator.getInventory();
    }
}
