import parties.Customers;
import parties.Party;

public class CMDGetParties implements Command<Customers> {
    private Aggregator aggregator;

    public CMDGetParties(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @Override
    public Customers execute() {
        return aggregator.getCustomers();
    }
}
