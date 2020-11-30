package parties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Customers {
    private PriorityQueue<Party> waitingQueue;
    private ArrayList<Party> orderingList;
    private int identifier = 1;

    public Customers() {
        this.waitingQueue = new PriorityQueue<>(5, new PartyComparator());
        this.orderingList = new ArrayList<>();
    }

    public void addToWaitingList(Party party) {
        waitingQueue.add(party);
    }

    public Party dequeueWaitingParty() {
        return  waitingQueue.poll();
    }

    public Party getWaitingParty() {
        return  waitingQueue.peek();
    }

    public void add(Party party) {
        orderingList.add(party);
    }

    public void deleteItem(int number) {
        orderingList.removeIf(item -> (item.getNumber() == number));
    }

    public Party searchItem(int number) {
        return orderingList.get(number - 1);
    }

    public int getOrderingListSize() {
        return orderingList.size();
    }

    public Iterator<Party> getIterator() {
        return orderingList.iterator();
    }

    public int getWaitingListSize() {
        return waitingQueue.size();
    }

    public Iterator<Party> getWaitingIterator() {
        return waitingQueue.iterator();
    }

    public int getIdentifier() {
        return identifier++;
    }
}
