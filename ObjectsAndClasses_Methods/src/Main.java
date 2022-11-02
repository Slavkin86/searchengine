public class Main {
    public Main() {
    }
    public static void main(String[] args) {
        boolean a = true;
        boolean b = true;
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.sum();
        arithmetic.mult();
        arithmetic.max();
        arithmetic.min();
        System.out.println(arithmetic.sum());
        System.out.println(arithmetic.mult());
        System.out.println(arithmetic.max());
        System.out.println(arithmetic.min());
    }
}
