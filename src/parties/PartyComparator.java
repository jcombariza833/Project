package parties;

import java.util.Comparator;

public class PartyComparator implements Comparator<Party> {
    @Override
    public int compare(Party party1, Party party2) {
        if (party1.getPeople() < party2.getPeople())
            return 1;
        else if (party1.getPeople() > party2.getPeople())
            return -1;
        return 0;
    }
}
