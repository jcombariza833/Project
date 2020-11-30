package menu.pizza;

public class PremiumPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public PremiumPizzaBuilder() {
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
        pizza.setIngredients(new int[] {1,3,4,7,8,9,10});
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}
