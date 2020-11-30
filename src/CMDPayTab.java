import menu.MenuItem;
import orders.OrderItem;
import parties.Customers;
import parties.Party;
import tables.TableItem;
import tables.Tables;

public class CMDPayTab implements Command<Verification> {
    private Aggregator aggregator;
    private int partyId;

    public CMDPayTab(Aggregator aggregator, int partyId) {
        this.aggregator = aggregator;
        this.partyId = partyId;
    }

    @Override
    public Verification execute() {

        Verification verification = new Verification();
        if (partyId > 0 && partyId <= aggregator.getCustomers().getOrderingListSize()) {
            Customers customers = aggregator.getCustomers();
            Tables tables = aggregator.getTables();

            Party party = customers.searchItem(partyId);
            customers.deleteItem(partyId);

            int[] associatedTables = party.getTable().getTables();

            for (int t: associatedTables) {
                tables.add(new TableItem(t));
            }
            verification.setMessage("The order was payed successfully");
        } else {
            verification.setMessage("\tthe party selected does not exist");
        }
        return verification;
    }
}
