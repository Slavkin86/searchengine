import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
/**        Elevator elevator = new Elevator (-3, 26);
        while (true) {
            System.out.println("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }**/

    Cargo cargo = new Cargo(new Dimensions(5, 5, 3),
            100, "Самара", true, "9586AF5412CN", true);
    Dimensions dimensions = new Dimensions(4, 3, 5);
    Cargo copy = cargo.setAddress("Москва");
        Cargo copy1 = cargo.setMass(150.50);
        System.out.println(copy.toString());
        System.out.println(copy1.toString());
    }
}
