import menu.Menu;
import menu.inventory.Inventory;
import observer.Observer;
import orders.Orders;
import parties.Customers;
import parties.Party;
import tables.CompositeTable;
import tables.TableItem;
import tables.Tables;

public class Aggregator implements Observer {
    private Menu menu;
    private Orders orders;
    private Inventory inventory;
    private Customers customers;
    private Tables tables;

    public Aggregator() {
        this.menu = new Menu();
        this.orders = new Orders();
        this.inventory = new Inventory();
        this.customers = new Customers();
        this.tables = new Tables();
        tables.register(this);
    }

    public Menu getMenu() {
        return menu;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Customers getCustomers() {
        return customers;
    }

    public Tables getTables() {
        return tables;
    }

    @Override
    public void update() {
        Tables tables = getTables();
        Party party = getCustomers().getWaitingParty();
        int people = party.getPeople();

        if(tables.isTablesAvailable() && (tables.getTablesSize()* TableItem.MAX_SEATS > people)) {

            TableItem table = tables.getTable();
            CompositeTable cTable=  tableAssignation(people,table);

            Party dequeueParty = getCustomers().dequeueWaitingParty();
            party.setNumber(getCustomers().getIdentifier());
            party.setTable(cTable);

            getCustomers().add(dequeueParty);
        }
    }

    private CompositeTable tableAssignation(int people, TableItem tableItem) {
        CompositeTable cTable=  new CompositeTable(tableItem);
        int tablePeople = TableItem.MAX_SEATS;
        while (tablePeople < people) {
            cTable.addTable(getTables().getTable());
            tablePeople += TableItem.MAX_SEATS;
        }

        return cTable;
    }
}
