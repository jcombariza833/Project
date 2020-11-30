package parties.state;

import parties.Party;

public class WaitingState extends PartyState {

    public WaitingState(Party context) {
        super(context);
    }

    public WaitingState(PartyState state) {
        super(state);
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }

    @Override
    public void transitionState() {

    }
}
