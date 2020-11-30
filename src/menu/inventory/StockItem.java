package menu.inventory;

public class StockItem {
    private int number;
    private String name;
    private int amount;

    public StockItem(int number, String name, int amount) {
        this.number = number;
        this.name = name;
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void useItem() {
        if(amount > 0)
            amount--;
    }
}
