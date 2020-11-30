package menu.pizza;

public class FourCheesePizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public FourCheesePizzaBuilder() {
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
        pizza.setIngredients(new int[] { 1,3,4,5,6 });
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}
