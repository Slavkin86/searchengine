public class Processor {
    private final int frequency;
    private final int amountCore;
    private final String brand;
    private final double weight;

    public Processor(int frequency, int amountCore, String brand, double weight) {
        this.frequency = frequency;
        this.amountCore = amountCore;
        this.brand = brand;
        this.weight = weight;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getAmountCore() {
        return amountCore;
    }

    public String getBrand() {
        return brand;
    }

    public double getWeight() {
        return weight;
    }
    public String toString() {
        return  " Частота: " + frequency +
                " Количество ядер: " + amountCore +
                " Производитель: " + brand + " \n " +
                " Вес: " + weight + " г. ";
    }
}
