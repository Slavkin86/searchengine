public class Arithmetic {
    private int a = 5;
    private int b = 5;

    public Arithmetic() {

    }

    public void Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum() {
        return this.a + this.b;
    }
    public int mult() {
        return this.a * this.b;
    }
    public int max() {
        return this.a > this.b ? this.a : this.b;
    }
    public int min() {
        return this.a < this.b ? this.a : this.b;
    }
}

