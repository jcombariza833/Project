package parties;

import orders.Orders;
import parties.state.PartyState;
import tables.BookedTable;
import tables.CompositeTable;

public class Party {
    private int number;
    private int people;

    private CompositeTable table;

    private PartyState state;

    public Party(int people) {
        this.people = people;
        this.state = PartyState.InitialState(this);
    }

    public PartyState getState() {
        return state;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTable(CompositeTable table) {
        this.table = table;
    }

    public CompositeTable getTable() {
        return table;
    }

    public int getPeople() {
        return people;
    }
}
