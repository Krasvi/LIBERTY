import java.util.HashMap;
import java.util.Map;

public class FactionSystem {

    private Map<String, Integer> reputation = new HashMap<>();

    public FactionSystem() {
        // Predefined factions
        reputation.put("Inquisition", 0);
        reputation.put("Guild of Ash", 0);
        reputation.put("Seekers of Vella", 0);
        reputation.put("Orderbound", 0);
        reputation.put("Whispering Court", 0);
    }

    public void joinFaction(String name) {
        if (!reputation.containsKey(name)) {
            reputation.put(name, 50); // New faction joined at neutral
        }
        System.out.println("You have joined the faction: " + name);
    }

    public void changeReputation(String faction, int amount) {
        int current = reputation.getOrDefault(faction, 0);
        reputation.put(faction, current + amount);
        System.out.println("Your reputation with " + faction + " is now: " + reputation.get(faction));
    }

    public int getReputation(String faction) {
        return reputation.getOrDefault(faction, 0);
    }

    public boolean isAlly(String faction) {
        return getReputation(faction) >= 75;
    }

    public boolean isEnemy(String faction) {
        return getReputation(faction) <= -50;
    }

    public boolean hasJoined(String faction) {
        return reputation.containsKey(faction);
    }

    public void printAllFactions() {
        System.out.println("--- Faction Reputations ---");
        for (Map.Entry<String, Integer> entry : reputation.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Integration utility for player
    public static void attachToPlayer(PlayerCharacter player) {
        player.setFactionSystem(new FactionSystem());
    }
}
