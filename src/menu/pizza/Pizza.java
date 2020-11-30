package menu.pizza;

public class Pizza {
    private PizzaShape shape;
    private PizzaCrust crust;
    private int[] ingredients;

    public Pizza() {
        shape = PizzaShape.ROUNDED;
        crust = PizzaCrust.THIN;
        ingredients = new int[] {1,3,12};
    }

    public void setShape(PizzaShape shape) {
        this.shape = shape;
    }

    public void setCrust(PizzaCrust crust) {
        this.crust = crust;
    }

    public void setIngredients(int[] ingredients) {
        this.ingredients = ingredients;
    }

    public int[] getIngredients() {
        return ingredients;
    }
}