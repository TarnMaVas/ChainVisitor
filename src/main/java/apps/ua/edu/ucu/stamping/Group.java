package apps.ua.edu.ucu.stamping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;

@Getter
public class Group {
    private final List<Signature> signatures;
    private final String groupId;

    public Group() {
        this.signatures = new ArrayList<>();
        this.groupId = UUID.randomUUID().toString();
    }

    public void addSignature(Signature signature) {
        this.signatures.add(signature);
    }

    public void apply() {
        GroupVisitor visitor = new GroupVisitor(groupId);

        for (Signature signature : signatures) {
            signature.accept(visitor);
            signature.invoke();
        }
    }

    public String getGroupId() {
        return groupId;
    }
}
