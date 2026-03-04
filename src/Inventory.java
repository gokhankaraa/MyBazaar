import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> stock;

    public Inventory() {
        this.stock = new HashMap<>();
    }

    public void addItem(String itemType, int quantity) {
        stock.put(itemType, stock.getOrDefault(itemType, 0) + quantity);
    }

    public void removeItem(String itemType) {
        if (stock.containsKey(itemType) && stock.get(itemType) > 0) {
            stock.put(itemType, stock.get(itemType) - 1);
        }
    }

    public int getStock(String itemType) {
        return stock.getOrDefault(itemType, 0);
    }

    public Map<String, Integer> getStockLevels() {
        return stock;
    }
}
