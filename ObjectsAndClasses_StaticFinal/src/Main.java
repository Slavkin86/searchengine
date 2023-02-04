public class Main {
    public static void main(String[] args) {

        Processor processor = new Processor(0, 0, "intel", 0);
        Ram ram = new Ram(RamType.DDR3, 0, 0);
        Storage storage = new Storage(StorageType.HDD, 0, 0);
        Screen screen = new Screen(ScreenType.TN, 0, 0);
        Keyboard keyboard = new Keyboard(KeyboardType.WIRED, false, 0.0);

        Computer HP = new Computer("HP", "T1000", 0, processor, ram,
                storage, screen, keyboard);
        HP.setProcessor(new Processor(3200, 4, "intel", 150));
        HP.setRam(new Ram(RamType.DDR3, 16, 20));
        HP.setStorage(new Storage(StorageType.HDD, 512, 350));
        HP.setScreen(new Screen(ScreenType.IPS, 20, 2500));
        HP.setKeyboard(new Keyboard(KeyboardType.WIRED, false, 200.5));
        System.out.println(HP + "\n");

        Computer Asus = new Computer("Asus", "MP-1254", 0, processor, ram,
                storage, screen, keyboard);
        Asus.setProcessor(new Processor(3500, 8, "AMD", 250));
        Asus.setRam(new Ram(RamType.DDR4, 16, 25));
        Asus.setStorage(new Storage(StorageType.SSD, 512, 150));
        Asus.setScreen(new Screen(ScreenType.TN, 24, 2000.50));
        Asus.setKeyboard(new Keyboard(KeyboardType.WIRELESS, true, 220.5));
        System.out.println(Asus + "\n");
    }
}