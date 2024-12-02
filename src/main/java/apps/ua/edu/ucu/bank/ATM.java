package apps.ua.edu.ucu.bank;

import lombok.Getter;

public class ATM {

    static final int FIRST_NOTE = 100;
    static final int SECOND_NOTE = 50;
    static final int THIRD_NOTE = 5;

    private final Banknote firstTray;

    @Getter
    private int budget;

    public ATM(int budget) {

        this.budget = budget;

        firstTray = new Banknote(FIRST_NOTE);
        Banknote secondTray = new Banknote(SECOND_NOTE);
        Banknote thirdTray = new Banknote(THIRD_NOTE);
        
        firstTray.setNextItem(secondTray);
        secondTray.setNextItem(thirdTray);
    }

    public void process(int amount) {

        if (amount > budget) {
            throw new 
                IllegalArgumentException("ATM doesn't have enough money");
        }

        firstTray.process(amount);

        budget -= amount;
    }
}
