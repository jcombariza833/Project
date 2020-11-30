import menu.Menu;
import menu.inventory.Inventory;
import parties.Customers;

public class Invoker {
    private Aggregator aggregator;

    public Invoker(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    public Menu getMenu(){
        return new CMDGetMenu(aggregator).execute();
    }

    public Inventory getInventory(){
        return new CMDGetInventory(aggregator).execute();
    }

    public Customers getParties(){
        return new CMDGetParties(aggregator).execute();
    }

    public Verification placeOrder(int item, int tableId){
        return new CMDSubmitOrder(aggregator,item, tableId).execute();
    }

    public Tab getTab(int partyId){
        return new CMDGetTap(aggregator,partyId).execute();
    }

    public Verification requestTable(int people){
        return new CMDRequestTable(aggregator,people).execute();
    }

    public Verification payTab(int partyId){
        return new CMDPayTab(aggregator,partyId).execute();
    }
}
