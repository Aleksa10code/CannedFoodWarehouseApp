import java.time.LocalDate;

public class WarehouseApp {
    public static void main(String[] args) {

    Warehouse warehouse = new Warehouse();
    warehouse.addNew("Cola", LocalDate.now().plusYears(1));
    warehouse.addNew("Cola", LocalDate.now().plusYears(2));
    warehouse.addNew("Fanta", LocalDate.now().minusDays(1));
    System.out.println(warehouse);

    // Remove by ID
    warehouse.remove(1);

    System.out.println(warehouse);

    // Remove by expiration date
    warehouse.removeExpired();

    System.out.println(warehouse);
    }
}
