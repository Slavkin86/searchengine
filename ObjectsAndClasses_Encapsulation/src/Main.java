import java.util.Scanner;

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
    cargo.setAddress("Москва");
    cargo.setDemensions(dimensions);
    cargo.setMass(200);
        System.out.println(cargo);
    }
}
