import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

public class Warehouse {

    Bin[] bins = new Bin[10];

    public Warehouse() {
        for (int i = 0; i < bins.length; i++) {
            bins[i] = new Bin();
        }
    }

    public void addNew(String type, LocalDate expiryDate) {
        // TODO pronaci odgovarajuci bin na osnovu type-a. I dodati konzervu.
        Bin binForType = null;
        // pronaci po type
        for (Bin bin : bins) {
            if (type.equals(bin.getType()) && !bin.isFull()) {
                binForType = bin;
                break;
            }
        }

        // ako nema odgovarajuci type
        if (binForType == null) {
            for (Bin bin : bins) {
                if (bin.getType().isEmpty()) {
                    binForType = bin;
                    break;
                }
            }
        }

        // ako nemamo ni praznih binova
        if (binForType == null) {
            System.out.println("Nije moguce ubaciti konzervu");
        }

        else {
            binForType.addCan(new Can(type, expiryDate));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Warehouse: \n");
        for (Bin bin : bins) {
            stringBuilder.append(bin).append("\n");
        }
        return stringBuilder.toString();
    }

    public boolean remove(int id) {
        for (Bin bin : bins) {
            if(bin.removeById(id - 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeExpired() {
        boolean removed = false;
        for (int i = 0; i < bins.length; i++) {
            boolean removedInBin = bins[i].removeExpiredBin();
            if (removedInBin) {
                removed = true;
            }
        }
        return removed;
        //    Stream.of(bins).forEach(Bin::removeExpired);
    }

    public boolean removedExpired() {
        boolean removed = false;
        for (int i = 0; i < bins.length; i++) {
            boolean removedInBin = bins[i].removeExpiredBin();
            if (removedInBin) {
                removed = true;
            }
        }
        return removed;
    }
}