import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import apps.ua.edu.ucu.bank.ATM;

public class ATMTest {
    private static final int INITIAL_BUDGET = 1000;
    private static final int VALID_AMOUNT = 205;
    private static final int INVALID_AMOUNT = 1200;
    private static final int EXACT_AMOUNT = 1000;
    private static final int EXPECTED_REMAINING_BUDGET = 795;

    private ATM atm;

    @BeforeEach
    public void setUp() {
        atm = new ATM(INITIAL_BUDGET);
    }

    @Test
    public void testProcessValidAmount() {
        atm.process(VALID_AMOUNT);
        Assertions.assertEquals(EXPECTED_REMAINING_BUDGET, atm.getBudget());
    }

    @Test
    public void testProcessInvalidAmount() {
        Exception exception = Assertions.
        assertThrows(IllegalArgumentException.class, () -> {
            atm.process(INVALID_AMOUNT);
        });
        Assertions.
        assertEquals("ATM doesn't have enough money", exception.getMessage());
    }

    @Test
    public void testProcessExactAmount() {
        atm.process(EXACT_AMOUNT);
        Assertions.assertEquals(0, atm.getBudget());
    }
}