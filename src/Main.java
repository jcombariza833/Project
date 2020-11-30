public class Main {
    public static void main(String[] args) {
        Aggregator aggregator = new Aggregator();
        Invoker invoker = new Invoker(aggregator);
        SystemInterface.setInvoker(invoker);

        UserInterface ui = new UserInterface();
        ui.start();
    }
}
