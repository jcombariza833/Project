import parties.Party;
import tables.CompositeTable;
import tables.TableItem;
import tables.Tables;

public class CMDRequestTable implements Command<Verification> {
    private Aggregator aggregator;
    private int people;

    public CMDRequestTable(Aggregator aggregator, int people) {
        this.aggregator = aggregator;
        this.people = people;
    }

    @Override
    public Verification execute() {
        Verification verification = new Verification();
        Tables tables = aggregator.getTables();
        if(tables.isTablesAvailable() && (tables.getTablesSize()*TableItem.MAX_SEATS > people)) {

            TableItem table = tables.getTable();
            CompositeTable cTable=  tableAssignation(people,table);

            Party party = new Party(people);
            party.setNumber(aggregator.getCustomers().getIdentifier());
            party.setTable(cTable);

            aggregator.getCustomers().add(party);
            verification.setMessage(cTable.tableDescription());

        } else {
            aggregator.getCustomers().addToWaitingList(new Party(people));
            verification.setMessage("Party is in the waiting list");
        }
        return verification;
    }

    private CompositeTable tableAssignation(int people, TableItem tableItem) {
        CompositeTable cTable=  new CompositeTable(tableItem);
        int tablePeople = TableItem.MAX_SEATS;
        while (tablePeople <= people) {
            cTable.addTable(aggregator.getTables().getTable());
            tablePeople += TableItem.MAX_SEATS;
        }

        return cTable;
    }
}
