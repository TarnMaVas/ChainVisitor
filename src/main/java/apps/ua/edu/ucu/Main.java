package apps.ua.edu.ucu;

import apps.ua.edu.ucu.bank.ATM;
import apps.ua.edu.ucu.stamping.Group;
import apps.ua.edu.ucu.stamping.NormalTask;
import apps.ua.edu.ucu.stamping.Signature;
import apps.ua.edu.ucu.stamping.Task;

public class Main {

    private static final int BUDGET = 1000;
    private static final int TRIAL_AMOUNT = 205;

    public static void main(String[] args) {

        // Task1
        ATM atm = new ATM(BUDGET);
        atm.process(TRIAL_AMOUNT);

        System.out.println();

        // Task2
        Task firstTask = new NormalTask();
        
        Signature firstSignature = new Signature(firstTask);
        Signature secondSignature = new Signature(firstTask);

        firstSignature.invoke();
        secondSignature.invoke();

        System.out.println("\n --- Now grouping them --- \n");
        
        Group group = new Group();
        group.addSignature(firstSignature);
        group.addSignature(secondSignature);

        group.apply();
        

    }
}