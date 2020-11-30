package menu.pizza;

public class SpecialPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public SpecialPizzaBuilder() {
        pizza = new Pizza();
    }

    @Override
    public void addShape() {
        pizza.setShape(PizzaShape.RECTANGULAR);
    }

    @Override
    public void addCrust() {
        pizza.setCrust(PizzaCrust.THICK);
    }

    @Override
    public void addIngredients() {
        pizza.setIngredients(new int[] {1,2,5,6,8,10,12,13});
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}
