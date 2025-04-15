public class Events {

    public static void mysteriousStatue(PlayerCharacter player) {
        System.out.println("You approach a moss-covered statue of forgotten design.");
        if (player.getMemory().hasMade("read forbidden glyphs")) {
            System.out.println("The statue hums softly... it recognizes your touch.");
        } else {
            System.out.println("The stone is cold and silent. Perhaps it waits for something.");
        }
        if (player.intelligence >= 8) {
            System.out.println("You discern symbols hidden in the cracks: 'Knowledge is sin. Sin is order.'");
            player.getMemory().rememberDecision("read statue inscription");
        }
    }

    public static void secretHallway(PlayerCharacter player) {
        if (player.wisdom > 6) {
            System.out.println("You notice faint runes along the base of the wall... there's a door here.");
            player.getMemory().rememberDecision("discovered hidden door");
        } else {
            System.out.println("The hallway seems long and plain.");
        }
    }

    public static void crumblingLibrary(PlayerCharacter player) {
        System.out.println("Books litter the broken floor. One whispers your name.");
        if (player.getMemory().getFlag("canReadAncient")) {
            System.out.println("You read it. It describes a future that hasn't happened yet.");
        } else {
            System.out.println("The script writhes as you look at it. You can't read it—yet.");
        }
    }

    public static void forbiddenPrayer(PlayerCharacter player) {
        System.out.println("An old monk beckons you to kneel at the statue of the First Lord.");
        if (player.charisma >= 7) {
            System.out.println("You repeat the words... convincingly. He smiles and hands you a sealed scroll.");
            player.getMemory().rememberDecision("deceived the faithful");
        } else {
            System.out.println("Your voice falters. He frowns and walks away.");
        }
    }

    public static void runeForge(PlayerCharacter player) {
        System.out.println("A glowing forge pulses with power. A rune shard floats above it.");
        if (player.getMemory().hasMade("earned blacksmith's trust")) {
            System.out.println("The blacksmith nods. 'You know what to do.' You claim the rune.");
            player.getMemory().setFlag("hasRuneOfFire", true);
        } else {
            System.out.println("The blacksmith bars your path. 'Not yet.'");
        }
    }

    public static void scholarEncounter(PlayerCharacter player) {
        System.out.println("A masked scholar offers to teach you the old tongue.");
        if (!player.getMemory().getFlag("knowsAncient")) {
            System.out.println("You begin your first lesson. It burns into your mind.");
            player.getMemory().setFlag("knowsAncient", true);
        } else {
            System.out.println("You already carry the weight of those syllables.");
        }
    }

    public static void cityMarket(PlayerCharacter player) {
        System.out.println("A merchant offers a rune-carved charm. 'Trade you... knowledge for safety.'");
        if (player.getKnowledgeLevel() > 3) {
            System.out.println("You agree. You lose 1 knowledge, but gain a blessed amulet.");
            player.increaseKnowledge(); // Simulate a shift in memory
        } else {
            System.out.println("'Too green,' he mutters. 'Come back when your eyes are older.'");
        }
    }

    public static void alleyEncounter(PlayerCharacter player) {
        System.out.println("A hooded figure whispers: 'You seek answers, yes? Follow.'");
        if (player.wisdom >= 7) {
            System.out.println("You sense no lie. You follow them into shadow.");
            player.getMemory().rememberDecision("entered the alley cult");
        } else {
            System.out.println("You hesitate. They vanish.");
        }
    }

    public static void archiveTrial(PlayerCharacter player) {
        System.out.println("You're invited to read a sealed document. It's illegal.");
        if (player.intelligence >= 9) {
            System.out.println("You memorize it instantly, and burn the original.");
            player.getMemory().setFlag("archive knowledge", true);
        } else {
            System.out.println("You try—but the words fade from your mind.");
        }
    }

    public static void dreamVision(PlayerCharacter player) {
        System.out.println("You awaken in a place made of mirrors. A reflection of yourself asks: 'Are you real?' ");
        if (player.getMemory().getFlag("knowsAncient")) {
            System.out.println("You answer in the old tongue. The dream shatters, but you awaken stronger.");
            player.restoreHP(10);
        } else {
            System.out.println("You say nothing. The dream fades.");
        }
    }

    public static void initiateTrial(PlayerCharacter player) {
        System.out.println("You are summoned to recite the Oath of Order.");
        if (player.getMemory().hasMade("spoken like a scholar")) {
            System.out.println("Your words echo with authority. You pass.");
        } else {
            System.out.println("You falter. Someone takes notes in the shadows.");
        }
    }

    public static void brokenTower(PlayerCharacter player) {
        System.out.println("You climb a broken tower. Lightning crackles at its peak.");
        if (player.wisdom >= 9) {
            System.out.println("You catch a glimpse of the stars beyond the rune grid.");
        } else {
            System.out.println("Only clouds greet your eyes.");
        }
    }

    public static void bloodDuel(PlayerCharacter player) {
        System.out.println("A challenger steps forth. 'Only strength is true.'");
        if (player.strength >= 10) {
            System.out.println("You win. He kneels. 'Truth walks with you.'");
        } else {
            System.out.println("He smirks. 'You’ll learn someday.'");
            player.takeDamage(15);
        }
    }

    public static void mirrorRoom(PlayerCharacter player) {
        System.out.println("You enter a chamber of mirrors. Each reflection whispers something different.");
        if (player.charisma >= 8) {
            System.out.println("You charm the right reflection—it tells you a secret.");
            player.getMemory().rememberDecision("heard mirror truth");
        }
    }

    public static void graveReading(PlayerCharacter player) {
        System.out.println("You find a grave with runes etched in reverse.");
        if (player.getMemory().getFlag("hasRuneOfFire")) {
            System.out.println("You trace the rune. The grave shifts. A book rises from the soil.");
        } else {
            System.out.println("The runes burn to the touch.");
        }
    }

    public static void duelOfWords(PlayerCharacter player) {
        System.out.println("A rhetor challenges you to a contest of philosophy.");
        if (player.charisma + player.intelligence >= 15) {
            System.out.println("You win the crowd’s favor. The rhetor vanishes in shame.");
        } else {
            System.out.println("Your words falter. The crowd turns away.");
        }
    }

    public static void scrollVault(PlayerCharacter player) {
        System.out.println("You enter a vault of ancient scrolls. A choice must be made: Truth or Power.");
        if (player.wisdom > player.charisma) {
            System.out.println("You take the scroll of truth. It sears your mind.");
            player.increaseKnowledge();
        } else {
            System.out.println("You take the scroll of power. Strength flows into you.");
            player.strength++;
        }
    }

    public static void fireWell(PlayerCharacter player) {
        System.out.println("A well of flame offers visions. You peer in.");
        if (player.getMemory().getFlag("hasRuneOfFire")) {
            System.out.println("The flames part. You see... a path not yet taken.");
        } else {
            System.out.println("Only fire and screams.");
        }
    }

    public static void forbiddenRite(PlayerCharacter player) {
        System.out.println("A hooded cultist offers a forbidden rite.");
        if (player.intelligence >= 10 && player.wisdom >= 8) {
            System.out.println("You perform the rite. You are changed. Something ancient stirs.");
            player.maxMP += 10;
        } else {
            System.out.println("You try. You black out, and awaken changed. Something is missing.");
            player.charisma--;
        }
    }
}
