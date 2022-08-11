import java.time.LocalDate;

public class Can {
    /**
     * id (Integer, a unique identifier)
     * type (String)
     * expiry date (LocalDate, is the ISO format yyyy-MM-dd, e.g. 2022-04-30)
     */

    static int uniqId = 0;
    private final int id;
    private String type;
    private LocalDate expiry_date;

    public Can(String type, LocalDate expiry_date) {
        id = uniqId++;
        this.type = type;
        this.expiry_date = expiry_date;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public LocalDate getExpiry_date() {
        return expiry_date;
    }

    @Override
    public String toString() {
        return id + " " + type + " " + expiry_date;
    }

}
