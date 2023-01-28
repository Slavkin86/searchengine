import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        final String regexEmail = "[A-Za-z0-9]+([._-]?[A-Za-z0-9]+)*" +
                "@[A-Za-z0-9]+([._-]?[A-Za-z0-9]+)*\\.[a-z]{2,4}";
        final String regexPhone = "\\+79[0-9]{9}";

        String[] components = data.split("\\s+");
        if (components.length != 4 || components[2].length() < 5 || components[2].length() > 25 ||
                !components[2].matches(regexEmail) || !components[3].matches(regexPhone)) {
            throw new IllegalArgumentException();
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}