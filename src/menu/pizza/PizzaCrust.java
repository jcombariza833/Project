package menu.pizza;

public enum PizzaCrust {
    THIN("thin"),
    THICK("thick");

    private String crust;

    PizzaCrust(String crust) {
        this.crust = crust;
    }
}
