package tables;

import orders.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class CompositeTable implements BookedTable {
    private List<BookedTable> childTables;
    private TableItem parent;
    private Orders orders;

    public CompositeTable(TableItem parent) {
        this.parent = parent;
        childTables = new ArrayList<BookedTable>();
        orders = new Orders();
    }

    public void addTable(BookedTable table) {
        childTables.add(table);
    }

    public void removeTable(BookedTable table) {
        childTables.remove(table);
    }

    public int[] getTables() {
        int[] table = new int[childTables.size() + 1];
        int index = 1;
        for (BookedTable tableItem: childTables) {
            table[index++] = Integer.parseInt(tableItem.tableDescription());
        }
        table[0] = Integer.parseInt(parent.tableDescription());

        return table;
    }

    public Orders getOrders() {
        return orders;
    }

    @Override
    public String tableDescription() {
        StringJoiner children = new StringJoiner(", ");
        for (BookedTable tableItem: childTables) {
            children.add(tableItem.tableDescription());
        }
        children.add(parent.getNumber() + "");
        return "Assigned tables: " + children ;
    }
}
