package menu.decorator;

public abstract class MenuItemDecorator implements ItemDescription {
    protected ItemDescription itemDescription;

    public MenuItemDecorator(ItemDescription itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Override
    public String getItemDescription() {
        return itemDescription.getItemDescription();
    }
}
