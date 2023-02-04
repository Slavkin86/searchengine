public class Dimensions {
    private final double width;
    private final double height;
    private final double lenght;

    public Dimensions(double width, double height, double lenght) {
        this.width = width;
        this.height = height;
        this.lenght = lenght;
    }
    public double cargoVolume() {
        return width * height * lenght;
    }
}
