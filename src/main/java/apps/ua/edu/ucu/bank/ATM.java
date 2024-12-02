package apps.ua.edu.ucu.bank;

import lombok.Getter;

public class ATM {
    private final Banknote firstTray;

    @Getter
    private int budget;

    public ATM(int budget) {

        this.budget = budget;

        firstTray = new Banknote(100);
        Banknote SecondTray = new Banknote(50);
        Banknote ThirdTray = new Banknote(5);
        
        firstTray.setNextItem(SecondTray);
        SecondTray.setNextItem(ThirdTray);
    }

    public void process(int amount) {

        if (amount > budget) {
            throw new IllegalArgumentException("ATM doesn't have enough money");
        }

        firstTray.process(amount);

        budget -= amount;
    }
}
