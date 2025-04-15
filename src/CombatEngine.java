public class CombatEngine {
    public static void engage(PlayerCharacter player, NPC enemy) {
        System.out.println("\nYou engage in combat with " + enemy.getName() + "!");

        while (player.currentHP > 0 && enemy.currentHP > 0) {
            int playerDmg = player.strength + (int)(Math.random() * 5);
            enemy.takeDamage(playerDmg);
            System.out.println(player.name + " strikes " + enemy.name + " for " + playerDmg + " damage.");

            if (enemy.currentHP <= 0) {
                System.out.println(enemy.name + " falls.");
                player.gainExp(50);
                return;
            }

            int enemyDmg = enemy.strength + (int)(Math.random() * 4);
            player.takeDamage(enemyDmg);
            System.out.println(enemy.name + " hits back for " + enemyDmg + " damage.");

            if (player.currentHP <= 0) {
                System.out.println("You have been defeated.");
                return;
            }
        }
    }
}
