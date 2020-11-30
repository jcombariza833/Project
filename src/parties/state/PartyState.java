package parties.state;

import parties.Party;

public abstract class PartyState {
    private Party context;

    public PartyState(Party context) {
        this.context = context;
    }

    public PartyState( PartyState state) {
        setContext(state.getContext());
    }

    public static PartyState InitialState(Party pts) {
        return new WaitingState(pts);
    }

    public Party getContext() {
        return context;
    }

    public void setContext(Party context) {
        this.context = context;
    }

    public void askForService() {
        transitionState();
    }

    public abstract void transitionState();
}
