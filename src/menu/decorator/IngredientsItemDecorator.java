package menu.decorator;

import menu.MenuItem;
import menu.inventory.Inventory;

import java.util.StringJoiner;

public class IngredientsItemDecorator extends MenuItemDecorator {
    private Inventory inventory;
    private int[] ingredients;

    public IngredientsItemDecorator(ItemDescription itemDescription, Inventory inventory, int[] ingredients) {
        super(itemDescription);
        this.inventory = inventory;
        this.ingredients = ingredients;
    }

    @Override
    public String getItemDescription() {
        StringBuilder ingredients = new StringBuilder("(");
        StringJoiner list = new StringJoiner(", ");

        for (int i: this.ingredients) {
            list.add(inventory.searchItem(i).getName());
        }
        ingredients.append(list);
        ingredients.append(")");

        return super.getItemDescription() + "\n\t\t\t" + ingredients + "\n";
    }
}
