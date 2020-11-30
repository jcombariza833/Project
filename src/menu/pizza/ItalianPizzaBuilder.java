package menu.pizza;

public class ItalianPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public ItalianPizzaBuilder() {
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
        pizza.setIngredients(new int[] { 1,4,8,11,12 });
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}
