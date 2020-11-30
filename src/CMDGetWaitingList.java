import parties.Customers;

public class CMDGetWaitingList implements Command<Customers> {
    private Aggregator aggregator;

    public CMDGetWaitingList(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @Override
    public Customers execute() {
        return aggregator.getCustomers();
    }
}
