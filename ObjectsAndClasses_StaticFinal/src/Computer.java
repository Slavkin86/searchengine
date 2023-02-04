public class Computer {
    public final String veandor;
    public final String name;
    public double totalWeight;
    public Processor processor;
    public Ram ram;
    public Storage storage;
    public Screen screen;
    public Keyboard keyboard;

    public Computer(String veandor, String name, double totalWeight,
                    Processor processor, Ram ram, Storage storage,
                    Screen screen, Keyboard keyboard) {
        this.veandor = veandor;
        this.name = name;
        this.totalWeight = totalWeight;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.screen = screen;
        this.keyboard = keyboard;
    }


    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
    public double getTotalWeight () {
        return processor.getWeight() + keyboard.getWeight() + screen.getWeight() +
                storage.getWeight() + ram.getWeight();
    }
    public String toString() {
        return "Компьютер: " + veandor + " \n " +
                "Имя: " + name + "\n" +
                "Процессор: " + processor + "\n" +
                "ОЗУ: " + ram + "," + "\n" +
                "Жесткий диск: " + storage + "\n" +
                "Монитор: " + screen + " \n " +
                "Клавиатура: " + keyboard + " \n " +
                "Общий вес: " + getTotalWeight();
    }
}
