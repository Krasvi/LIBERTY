import java.util.HashMap;
import java.util.Map;

public class GuildSystem {

    private Map<String, Boolean> memberships = new HashMap<>();

    public GuildSystem() {
        // Predefined guilds
        memberships.put("Oni Hunters", false);
        memberships.put("Serpent Slayers", false);
        memberships.put("Golem Reclaimers", false);
        memberships.put("Wyrm Singers", false);
        memberships.put("Duskbound Exorcists", false);
    }

    public void joinGuild(String guild) {
        if (memberships.containsKey(guild)) {
            memberships.put(guild, true);
            System.out.println("You have been initiated into the guild: " + guild);
        } else {
            System.out.println("Unknown guild: " + guild);
        }
    }

    public boolean isMember(String guild) {
        return memberships.getOrDefault(guild, false);
    }

    public void listGuilds() {
        System.out.println("-- Guild Memberships --");
        for (Map.Entry<String, Boolean> entry : memberships.entrySet()) {
            System.out.println(entry.getKey() + ": " + (entry.getValue() ? "Member" : "Not Joined"));
        }
    }
}
