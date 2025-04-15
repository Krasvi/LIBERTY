public class PlayerCharacter extends Character {
    private int level;
    private int exp;
    private int knowledgeLevel;
    private PlayerMemory memory;
    private FactionSystem factionSystem;
    private GuildSystem guildSystem;

    public PlayerCharacter(String name, String major, String runeAffinity, String background,
                           int maxHP, int maxMP, int strength, int intelligence, int charisma, int wisdom) {
        super(name, major, runeAffinity, background, maxHP, maxMP, strength, intelligence, charisma, wisdom);
        this.level = 1;
        this.exp = 0;
        this.knowledgeLevel = 0;
        this.memory = new PlayerMemory();
        this.factionSystem = new FactionSystem();
        this.guildSystem = new GuildSystem();
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getRuneAffinity() {
        return runeAffinity;
    }

    public String getBackground() {
        return background;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public PlayerMemory getMemory() {
        return memory;
    }

    public FactionSystem getFactionSystem() {
        return factionSystem;
    }

    public void setFactionSystem(FactionSystem fs) {
        this.factionSystem = fs;
    }

    public GuildSystem getGuildSystem() {
        return guildSystem;
    }

    public void setGuildSystem(GuildSystem gs) {
        this.guildSystem = gs;
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

    @Override
    public void displayStats() {
        super.displayStats();
        System.out.println("Level: " + level + " | EXP: " + exp + " | Knowledge: " + knowledgeLevel);
        factionSystem.printAllFactions();
        guildSystem.listGuilds();
    }
}
