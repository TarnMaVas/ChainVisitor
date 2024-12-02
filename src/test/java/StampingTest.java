import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import apps.ua.edu.ucu.stamping.Group;
import apps.ua.edu.ucu.stamping.Signature;
import apps.ua.edu.ucu.stamping.Task;

public class StampingTest {
    private Task firstTask;
    private Task secondTask;
    private Signature firstSignature;
    private Signature secondSignature;
    private Group group;

    @BeforeEach
    public void setUp() {
        firstTask = () -> {
            System.out.println("Executing First Task");
        };

        secondTask = () -> {
            System.out.println("Executing Second Task");
        };

        firstSignature = new Signature(firstTask);
        secondSignature = new Signature(secondTask);

    }


    @Test
    public void testAddSignature() {

        group = new Group();

        group.addSignature(firstSignature);
        group.addSignature(secondSignature);

        Assertions.assertEquals(2, group.getSignatures().size());
    }

    @Test
    public void testApplyGroup() {

        group = new Group();

        group.addSignature(firstSignature);
        group.addSignature(secondSignature);

        group.apply();

        Assertions.
            assertEquals(group.getGroupId(), firstSignature.getGroupId());
        Assertions.
            assertEquals(group.getGroupId(), secondSignature.getGroupId());
    }

    @Test
    public void testSignatureInvoke() {

        group = new Group();

        firstSignature.invoke();
        secondSignature.invoke();
    }
}
