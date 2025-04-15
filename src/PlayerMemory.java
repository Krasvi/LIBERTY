// PlayerMemory.java

import java.util.*;

public class PlayerMemory {
    private Set<String> decisionsMade = new HashSet<>();
    private Map<String, Boolean> flags = new HashMap<>();

    public void rememberDecision(String key) {
        decisionsMade.add(key);
    }

    public boolean hasMade(String key) {
        return decisionsMade.contains(key);
    }

    public void setFlag(String flag, boolean value) {
        flags.put(flag, value);
    }

    public boolean getFlag(String flag) {
        return flags.getOrDefault(flag, false);
    }
}
