package apps.ua.edu.ucu.bank;

import lombok.Getter;
import lombok.Setter;

public class Banknote {

    @Setter @Getter
    private Banknote nextItem;
    private final int banknoteNominale;

    public Banknote(int banknoteNominale) {
        this.banknoteNominale = banknoteNominale;
    }

    public Banknote(Banknote nextItem, int banknoteNominale) {
        this.nextItem = nextItem;
        this.banknoteNominale = banknoteNominale;
    }

    public void process(int amount) {
        int quantity = amount / banknoteNominale;
        int rest = amount % banknoteNominale;

        if (nextItem != null) {
            nextItem.process(rest);
        } else if (rest != 0) {
            throw new IllegalArgumentException("This amount can't be issued");
        }

        if (quantity != 0) {
            System.out.println("Number of " + banknoteNominale + "-notes: " + quantity);
        }

    }
}
