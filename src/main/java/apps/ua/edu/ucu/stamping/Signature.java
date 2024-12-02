package apps.ua.edu.ucu.stamping;

import lombok.Getter;
import lombok.Setter;

public class Signature {

    private final Task task;

    @Setter @Getter
    private String groupId;

    public Signature(Task task) {
        this.task = task;
        this.groupId = "";
    }

    public void invoke() {
        task.execute();
        
        if (groupId.isEmpty()) {
            System.out.println("This signature is not part of any group");
            return;
        }

        System.out.println("Its group id is " + groupId);
    }

    public void accept(Visitor visitor) {
        visitor.visitSignature(this);
    }
}