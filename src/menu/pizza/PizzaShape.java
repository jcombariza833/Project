package menu.pizza;

public enum PizzaShape {
    RECTANGULAR("rectangular"),
    ROUNDED("rounded");

    private String shape;

    PizzaShape(String shape) {
        this.shape = shape;
    }
}
