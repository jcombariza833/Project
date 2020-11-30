package menu.inventory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Inventory {
    private HashMap<Integer, StockItem> stock;

    public Inventory() {
        stock = new HashMap<>();
        populateMenu();
    }

    public void addStockItem(StockItem item) {
        stock.put(item.getNumber(),item);
    }

    public void deleteItem(int number) {
        stock.remove(number);
    }

    public StockItem searchItem(int number) {
        return stock.get(number);
    }

    public void stockItemDepletion(int number) {
        StockItem item = searchItem(number);
        item.useItem();
        addStockItem(item);
    }

    public boolean isItemInStock(int number) {
        StockItem item = searchItem(number);
        return item.getAmount() != 0;
    }

    public Iterator<Map.Entry<Integer, StockItem>> getIterator() {
        return stock.entrySet().iterator();
    }

    public int getInventorySize() {
        return stock.size();
    }

    private void populateMenu() {
        addStockItem(new StockItem(1,"Pizza Dough",20));
        addStockItem(new StockItem(2,"Tomato sauce",10));
        addStockItem(new StockItem(3,"Mozzarella cheese",10));
        addStockItem(new StockItem(4,"Parmesan cheese",10));
        addStockItem(new StockItem(5,"Fontina cheese",10));
        addStockItem(new StockItem(6,"Feta cheese",10));
        addStockItem(new StockItem(7,"Mushrooms",10));
        addStockItem(new StockItem(8,"Italian sausage",10));
        addStockItem(new StockItem(9,"Pesto",10));
        addStockItem(new StockItem(10,"Pepperoni",10));
        addStockItem(new StockItem(11,"Onions",10));
        addStockItem(new StockItem(12,"Ham",10));
        addStockItem(new StockItem(13,"Chicken",10));
    }
}
