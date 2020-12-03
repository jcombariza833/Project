package tables;

import observer.Observer;
import observer.Subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Tables implements Subject {
    private Stack<TableItem> tables;
    private ArrayList<Observer> observers;
    public final static int MAX_PEOPLE = 20;

    public Tables() {
        this.tables = new Stack<>();
        observers = new ArrayList<>();
        populateTables();
    }

    public void add(TableItem table) {
        tables.push(table);
        send();
    }

    public TableItem getTable() {
        return tables.pop();
    }

    public boolean isTablesAvailable(){
        return !tables.empty();
    }

    public int getTablesSize() {
        return tables.size();
    }

    public Iterator<TableItem> getIterator() {
        return tables.iterator();
    }

    private void populateTables() {
        tables.push(new TableItem(1));
        tables.push(new TableItem(2));
        tables.push(new TableItem(3));
        tables.push(new TableItem(4));
        tables.push(new TableItem(5));
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void send() {
        observers.forEach((Observer::update));
    }
}
