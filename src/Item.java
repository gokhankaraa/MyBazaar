public abstract class Item {
    private static int itemCount = 0;
    private int id;
    private double price;

    public Item(double price) {
        this.id = ++itemCount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
