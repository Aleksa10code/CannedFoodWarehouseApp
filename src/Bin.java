import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Bin {

    private String type = "";
    private Set<Can> cans = new LinkedHashSet<>();

    public String getType() {
        return type;
    }

    public boolean addCan(Can can) {
        if (cans.isEmpty()) {
            type = can.getType();
        }

        if (!type.equals(can.getType())) {
            return false;
        }

        if (!isFull()) {
            cans.add(can);
            return true;
        }

        else {
            return false;
        }
    }

    public boolean isFull() {
        return cans.size() >= 10;
    }

   public boolean remove(Can can) {
        boolean remove = cans.remove(can);
        if (cans.isEmpty()) {
            type = "";
        }
        return remove;
   }

   public boolean removeById(int id) {
        boolean removed = cans.removeIf(can -> can.getId() == id);
        if (cans.isEmpty()) {
            type = "";
        }
        return removed;
   }

    public boolean removeExpiredBin() {
        boolean removed = cans.removeIf(can -> LocalDate.now().isAfter(can.getExpiry_date()));
        if (cans.isEmpty()) {
            type = "";
        }
        return removed;
    }

    @Override
    public String toString() {
        return type + " " + cans;
    }
}