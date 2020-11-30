import menu.Menu;

public class CMDGetMenu implements Command<Menu> {
    private Aggregator aggregator;

    public CMDGetMenu(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @Override
    public Menu execute() {
        return aggregator.getMenu();
    }
}
