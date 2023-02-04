public class Basket {

    private static int count = 0;
    private String items;
    private int totalPrice;
    private int limit;
    private double totalWeight;
    private static int totalCount;
    private static int totalCost;


    public Basket() {
        this.items = "";
        this.totalPrice = 0;
        this.totalWeight = 0.0;
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice, int totalWeight) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        this.totalWeight = (double)totalWeight;
    }

    public static int getCount() {

        return count;
    }

    public static void increaseCount(int count) {

        Basket.count = Basket.count + count;
    }

    public void add(String name, int price, int count) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (this.totalPrice + count * price >= this.limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        } else {
            this.items = this.items + "\n" + name + " - " + count + " шт. - " + price + "руб. - " + weight * (double)count + "гр.";
            this.totalPrice += count * price;
            this.totalWeight += weight * (double)count;
            totalCost = totalCost + price * count;
            totalCount = totalCount + count;
        }

    }

    public void clear() {
        this.items = "";
        this.totalPrice = 0;
    }
    public static int getTotalCount() {
        return totalCount;
    }
    public static int getTotalCost() {
        return totalCost;
    }
    public int getTotalPrice() {
        return this.totalPrice;
    }
    public double getTotalWeight() {
        return this.totalWeight;
    }

    public boolean contains(String name) {
        return this.items.contains(name);
    }
    public static double getMiddleCost() {
        return (double) totalCost / totalCount;
    }
    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
