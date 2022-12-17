public class Screen {
    private final int diagonal;
    private final double weight;

    public Screen(ScreenType screenType, int diagonal, double weight) {
        this.diagonal = diagonal;
        this.weight = weight;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public double getWeight() {
        return weight;
    }
    public String toString() {
        return  "Диагональ: " + diagonal + " Дюймов " +
                "Вес: " + weight + " г. ";
    }
}
