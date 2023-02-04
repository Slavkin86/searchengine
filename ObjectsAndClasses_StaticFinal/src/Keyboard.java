public class Keyboard {
    private final boolean backLight;
    private final Double weight;

    public Double getWeight() {
        return weight;
    }

    public Keyboard(KeyboardType keyboardType, boolean backLight, Double weight) {
        this.backLight = backLight;
        this.weight = weight;
    }
    public String toString() {
        return  " Подсветка " + backLight +
                " Вес " + weight + " г. ";
    }
}
