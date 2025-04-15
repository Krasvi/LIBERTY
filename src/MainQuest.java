public class MainQuest {

    public static void initiateQuest(PlayerCharacter player) {
        System.out.println("You feel the weight of unseen eyes. The streets whisper of broken kings and buried runes.");
        System.out.println("The legacy of the Five Monarchs begins to stir around you.");
        player.getMemory().setFlag("mainQuestStarted", true);
    }

    public static void discoverOrbOfLegacy(PlayerCharacter player) {
        System.out.println("In the catacombs beneath Liberty, you find a strange orb pulsing with echoes of forgotten voices.");
        if (!player.getMemory().getFlag("mainQuestStarted")) {
            System.out.println("The orb does not respond. Something remains dormant within you.");
            return;
        }
        player.getMemory().setFlag("hasOrbOfLegacy", true);
        System.out.println("Visions overwhelm you—memories not your own. You are chosen. The will to truth now courses through you.");
    }

    public static void meetVellaLaikar(PlayerCharacter player) {
        if (player.getMemory().getFlag("hasOrbOfLegacy") && player.getMemory().hasMade("audience with Vella")) {
            System.out.println("Vella Laikar regards you silently. 'I have watched you. The orb found you worthy. What will you do with it?'");
            player.getMemory().setFlag("vellaAcknowledgesSuccessor", true);
        } else {
            System.out.println("Her agents watch from the rooftops. But she has not summoned you yet.");
        }
    }

    public static void rallyResistance(PlayerCharacter player) {
        System.out.println("You begin to gather those who question the monarchs. Some come for justice. Some come for revenge. Others come for truth.");
        player.getMemory().rememberDecision("formed resistance faction");
    }

    public static void confrontDemigod(String demigodName, PlayerCharacter player) {
        System.out.println("You stand before " + demigodName + ", one of the Five. Their eyes carry centuries of silence.");
        if (player.getMemory().getFlag("hasOrbOfLegacy")) {
            System.out.println(demigodName + " speaks: 'The world you see is a cage we forged. Do you still wish to break it?'");
        } else {
            System.out.println(demigodName + " turns away. 'You are not ready.'");
        }
    }

    public static void rewriteTheOrder(PlayerCharacter player) {
        if (player.getMemory().getFlag("vellaAcknowledgesSuccessor")) {
            System.out.println("You ascend the forgotten tower where the Rune of Order was once proclaimed. You raise the orb.");
            System.out.println("The sky fractures. A new truth is born—not pure, but yours.");
            player.getMemory().setFlag("rewroteOrder", true);
        } else {
            System.out.println("You reach for the throne, but the legacy resists you. The order is not yet yours to change.");
        }
    }
}
