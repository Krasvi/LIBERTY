public class OniLoreEvents {

    public static void halfbloodRampage(PlayerCharacter player) {
        System.out.println("A half-Oni loses control in the marketplace, driven by crystal thirst.");
        if (player.getGuildSystem().isMember("Oni Hunters")) {
            System.out.println("You subdue it without killing, earning honor from the noble caste.");
            player.getFactionSystem().changeReputation("Orderbound", 10);
        } else {
            System.out.println("You hesitate—guards arrive and kill the creature. Whispers follow you.");
            player.getFactionSystem().changeReputation("Orderbound", -5);
        }
    }

    public static void bloodCrystalOffer(PlayerCharacter player) {
        System.out.println("A rogue merchant offers you Oni-blood crystals: 'Pure fire. Addictive. Ancient.'");
        if (player.wisdom >= 7) {
            System.out.println("You refuse. Your resolve hardens. Others nod in approval.");
            player.getMemory().rememberDecision("refused crystal temptation");
        } else {
            System.out.println("You take one. The power surges... and leaves scars.");
            player.strength += 1;
            player.wisdom -= 1;
            player.getMemory().setFlag("used blood crystal", true);
        }
    }

    public static void duelWithPureblood(PlayerCharacter player) {
        System.out.println("A pureblood Oni noble challenges you: 'No halfbloods. No mongrels. Show me your worth.'");
        if (player.getLevel() >= 5 && player.strength >= 8) {
            System.out.println("You defeat the noble in fair combat. He kneels. 'Perhaps you are not beneath us.'");
            player.getFactionSystem().changeReputation("Orderbound", 15);
        } else {
            System.out.println("You are swiftly knocked aside. 'Return when you carry your legacy.'");
            player.takeDamage(12);
        }
    }

    public static void hiddenOniTomb(PlayerCharacter player) {
        System.out.println("Deep in the jungle, a forgotten Oni crypt breathes heat.");
        if (player.getMemory().getFlag("used blood crystal")) {
            System.out.println("The crypt responds to the taint in your veins. A demon awakens.");
            player.takeDamage(20);
        } else {
            System.out.println("The stones shift. You find a rune-sealed chest holding Oni relics.");
            player.restoreHP(10);
        }
    }

    public static void oniHunterInitiation(PlayerCharacter player) {
        if (!player.getGuildSystem().isMember("Oni Hunters")) {
            System.out.println("A veteran Oni Hunter watches you. 'Prove yourself. Join us, or be prey.'");
            if (player.getLevel() >= 3) {
                player.getGuildSystem().joinGuild("Oni Hunters");
                player.getMemory().rememberDecision("joined Oni Hunters");
            } else {
                System.out.println("You are deemed unready. The hunt continues without you.");
            }
        } else {
            System.out.println("You are already a member of the Oni Hunters. The mark is on your soul.");
        }
    }
}
