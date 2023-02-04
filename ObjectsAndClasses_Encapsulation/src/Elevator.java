public class Elevator {


    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public void moveUp () {
        currentFloor = currentFloor +1;
    }
    public void moveDown () {
        currentFloor = currentFloor -1;
    }
    public void move (int floor) {
        if (floor < minFloor || floor > maxFloor) {
            System.out.println("Этаж указан неверно");
            return;
        }
        if (currentFloor < floor) {
            for (int i = currentFloor; currentFloor <= floor; moveUp()) {
                System.out.println("Текущий этаж: " + currentFloor);
            }
        }
        if (currentFloor > floor) {
            for (int i = currentFloor; currentFloor >= floor; moveDown()) {
                System.out.println("Текущий этаж: " + currentFloor);
            }
        }
    }
}
