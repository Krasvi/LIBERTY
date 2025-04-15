// Core character with stats and base logic
public class Character {
    protected String name;
    protected String major;
    protected String runeAffinity;
    protected String background;

    protected int maxHP, currentHP;
    protected int maxMP, currentMP;
    protected int strength, intelligence, charisma, wisdom;

    public Character(String name, String major, String runeAffinity, String background,
                     int maxHP, int maxMP, int strength, int intelligence, int charisma, int wisdom) {
        this.name = name;
        this.major = major;
        this.runeAffinity = runeAffinity;
        this.background = background;
        this.maxHP = this.currentHP = maxHP;
        this.maxMP = this.currentMP = maxMP;
        this.strength = strength;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.wisdom = wisdom;
    }

    public void takeDamage(int dmg) {
        currentHP -= dmg;
        if (currentHP < 0) currentHP = 0;
    }

    public void restoreHP(int amt) {
        currentHP = Math.min(currentHP + amt, maxHP);
    }

    public void useMP(int amt) {
        currentMP = Math.max(currentMP - amt, 0);
    }

    public void restoreMP(int amt) {
        currentMP = Math.min(currentMP + amt, maxMP);
    }

    public void displayStats() {
        System.out.println("== " + name + " ==");
        System.out.println("Major: " + major);
        System.out.println("Rune Affinity: " + runeAffinity);
        System.out.println("HP: " + currentHP + "/" + maxHP + " | MP: " + currentMP + "/" + maxMP);
        System.out.println("STR: " + strength + " | INT: " + intelligence +
                " | CHA: " + charisma + " | WIS: " + wisdom);
    }
}
