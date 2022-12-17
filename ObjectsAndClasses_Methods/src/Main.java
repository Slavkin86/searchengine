public class Main {
    public static void main(String[] args) {
        Basket basket = new  Basket();
        basket.add("Хлеб", 25, 5, 250);
        basket.add("Колбаса", 250, 5, 100);
        basket.add("Сыр", 350, 15, 50);
        basket.print("Корзина 1:");
        System.out.println("Общая стоимость корзины : " + basket.getTotalPrice());
        System.out.println();
        Basket basket1 = new Basket();
        basket1.add("Мясо", 400, 2, 500);
        basket1.add("Вода", 50, 3, 1500);
        basket1.add("Сок", 100, 2, 1000);
        basket1.print("Корзина 2:");
        System.out.println("Общая стоимость корзины: " + basket1.getTotalPrice());
        System.out.println();
        System.out.println("Общая стоимость корзин: " + Basket.getTotalCost() + " руб. " +
                "\n Общий вес корзин: " + (basket.getTotalWeight() + basket1.getTotalWeight()) + " г. "
                + "\n Общее количество товаров: " + Basket.getTotalCount()
                + "\n Средняя стоимость товара: " + Basket.getMiddleCost());

     //   boolean a = true;
     //   boolean b = true;
     //   Arithmetic arithmetic = new Arithmetic();
     //   arithmetic.sum();
     //   arithmetic.mult();
     //   arithmetic.max();
     //   arithmetic.min();
     //   System.out.println(arithmetic.sum());
     //   System.out.println(arithmetic.mult());
     //   System.out.println(arithmetic.max());
     //   System.out.println(arithmetic.min());
    }
}
