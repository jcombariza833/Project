package tables;

import java.util.ArrayList;
import java.util.List;

public class TableItem implements BookedTable {
    public final static int MAX_SEATS = 4;
    private int number;

    public TableItem(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String tableDescription() {
        return "" + number;
    }
}
