public class Manager implements Employee {

    private int salary = (int) (Math.random() * 40000) + 40000;

    private int sales;

    public Manager() {
        sales = (int) (Math.random() * (140000 - 115000) + 115000);
        salary += sales * 0.005;
    }

    @Override
    public int getMonthSalary() {

        return salary;
    }
    public int getSales() {
        return sales;
    }
}


