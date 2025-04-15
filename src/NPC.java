// NPC.java

public class NPC extends Character {
    private String faction;
    private String[] dialogueLines;

    public NPC(String name, String major, String runeAffinity, String background,
               int maxHP, int maxMP, int strength, int intelligence, int charisma, int wisdom,
               String faction, String[] dialogueLines) {
        super(name, major, runeAffinity, background, maxHP, maxMP, strength, intelligence, charisma, wisdom);
        this.faction = faction;
        this.dialogueLines = dialogueLines;
    }

    public String getFaction() {
        return faction;
    }

    public void speak() {
        for (String line : dialogueLines) {
            System.out.println(name + ": \"" + line + "\"");
        }
    }
}
