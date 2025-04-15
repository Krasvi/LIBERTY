public class PlayerCharacter extends Character {
    private int level;
    private int exp;
    private int knowledgeLevel;
    private PlayerMemory memory;

    public PlayerCharacter(String name, String major, String runeAffinity, String background,
                           int maxHP, int maxMP, int strength, int intelligence, int charisma, int wisdom) {
        super(name, major, runeAffinity, background, maxHP, maxMP, strength, intelligence, charisma, wisdom);
        this.level = 1;
        this.exp = 0;
        this.knowledgeLevel = 0;
        this.memory = new PlayerMemory();
    }

    public void gainExp(int amount) {
        exp += amount;
        if (exp >= 100) {
            levelUp();
            exp = 0;
        }
    }

    private void levelUp() {
        level++;
        maxHP += 10;
        maxMP += 5;
        strength++;
        intelligence++;
        System.out.println(name + " has leveled up to Level " + level + "!");
    }

    public void increaseKnowledge() {
        knowledgeLevel++;
    }

    public int getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public int getLevel() {
        return level;
    }

    public PlayerMemory getMemory() {
        return memory;
    }

    @Override
    public void displayStats() {
        super.displayStats();
        System.out.println("Level: " + level + " | EXP: " + exp + " | Knowledge: " + knowledgeLevel);
    }
}
