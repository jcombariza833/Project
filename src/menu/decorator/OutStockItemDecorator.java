package menu.decorator;

public class OutStockItemDecorator extends MenuItemDecorator {
    public OutStockItemDecorator(ItemDescription itemDescription) {
        super(itemDescription);
    }

    @Override
    public String getItemDescription() {
        return super.getItemDescription() + "   [ OUT OF STOCK ]";
    }
}
