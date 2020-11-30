package menu.pizza;

public class PepperoniPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public PepperoniPizzaBuilder() {
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
        pizza.setIngredients(new int[] { 1,2,8,10 });
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}
