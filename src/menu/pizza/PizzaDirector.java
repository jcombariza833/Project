package menu.pizza;

public class PizzaDirector {
    private PizzaBuilder builder;

    public void setPizzaBuilder(PizzaBuilder builder) {
        this.builder = builder;
    }

    public void makePizza(PizzaBuilder builder) {
        builder.addShape();
        builder.addCrust();
        builder.addIngredients();
    }
}