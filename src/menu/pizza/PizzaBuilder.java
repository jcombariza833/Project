package menu.pizza;

public interface PizzaBuilder {
    void addShape();
    void addCrust();
    void addIngredients();
    Pizza getPizza();
}