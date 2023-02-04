public class Ram {

    private final int volume;
    private final double weight;

    public Ram(RamType ramType, int volume, double weight) {
        this.volume = volume;
        this.weight = weight;
    }

    public int getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }
    public String toString() {
        return  " Обьем: " + volume + " Гб. " +
                " Вес: " + weight + " г. ";
    }
}
