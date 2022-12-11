public class Cargo {
    private final Dimensions dimensions;
    private final double mass;
    private final String address;

    private final boolean mayFlip;
    private final String regNumber;
    private final boolean isFragile;

    public Cargo(Dimensions dimensions, double mass, String address, boolean mayFlip, String regNumber, boolean isFragile) {
        this.dimensions = dimensions;
        this.mass = mass;
        this.address = address;
        this.mayFlip = mayFlip;
        this.regNumber = regNumber;
        this.isFragile = isFragile;
    }
    public Cargo setAddress(String address) {
        return new Cargo(dimensions, mass, address, mayFlip, regNumber, isFragile);
    }
    public Cargo setDemensions(Dimensions dimensions) {
        return new Cargo(dimensions, mass, address, mayFlip, regNumber, isFragile);
    }
    public Cargo setMass(double mass) {
        return new Cargo(dimensions, mass, address, mayFlip, regNumber, isFragile);
    }
    public Dimensions getDimensions() {
        return dimensions;
    }
    public double getMass() {
        return mass;
    }
    public String getAddress() {
        return address;
    }

    public String getRegNumber() {
        return regNumber;
    }
    public boolean isMayFlip() {
        return mayFlip;
    }

    public boolean isFragile() {
        return isFragile;
    }
    public String toString() {
        return ("габариты - " + dimensions.toString() + "\n" +
                "Масса - " + getMass() + "кг" + "\n" +
                "Адрес доставки - " + getAddress() + "\n" +
                "Регистрационный номер - " + getRegNumber() + "\n" +
                isMayFlip() + "\n" + isFragile());
    }
}
