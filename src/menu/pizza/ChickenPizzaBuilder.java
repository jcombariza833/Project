package menu.pizza;

public class ChickenPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public ChickenPizzaBuilder() {
        pizza = new Pizza();
    }

    @Override
    public void addShape() {
        pizza.setShape(PizzaShape.ROUNDED);
    }

    @Override
    public void addCrust() {
        pizza.setCrust(PizzaCrust.THIN);
    }

    @Override
    public void addIngredients() {
        pizza.setIngredients(new int[] { 1,2,7,13 });
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}
