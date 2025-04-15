// RuneAbility.java

public class RuneAbility {
    private String name;
    private String description;
    private int mpCost;
    private int power; // positive = heal, negative = damage

    public RuneAbility(String name, String description, int mpCost, int power) {
        this.name = name;
        this.description = description;
        this.mpCost = mpCost;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMpCost() {
        return mpCost;
    }

    public boolean cast(PlayerCharacter caster, Character target) {
        if (caster.currentMP < mpCost) {
            System.out.println("Not enough MP to cast " + name + ".");
            return false;
        }

        caster.useMP(mpCost);

        if (power < 0) {
            int dmg = -power;
            target.takeDamage(dmg);
            System.out.println(caster.name + " casts " + name + " and deals " + dmg + " damage to " + target.name + ".");
        } else {
            target.restoreHP(power);
            System.out.println(caster.name + " casts " + name + " and heals " + target.name + " for " + power + " HP.");
        }

        return true;
    }
