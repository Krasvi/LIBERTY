public class PhilosophyEvents {

    public static void bookBurningPlaza(PlayerCharacter player) {
        System.out.println("You arrive at the center of Liberty where flames devour ancient scrolls.");
        if (player.getWisdom() > 6) {
            System.out.println("You recognize some of the runes being burned—histories long buried.");
            player.getMemory().rememberDecision("witnessed book burning");
        } else {
            System.out.println("You see only smoke and shame.");
        }
    }

    public static void inquisitionTrial(PlayerCharacter player) {
        System.out.println("A robed judge gestures to the prisoner beside him. 'What is her crime?' he asks.");
        if (player.getMemory().hasMade("witnessed book burning")) {
            System.out.println("You speak of suppression. The judge’s eyes narrow. You are marked.");
            player.getMemory().setFlag("suspected heretic", true);
        } else {
            System.out.println("You claim ignorance. The crowd nods. The trial proceeds.");
        }
    }

    public static void crypticSage(PlayerCharacter player) {
        System.out.println("A hunched sage greets you. 'All seek truth. Few survive it. Shall I ask you one question?'");
        if (player.getWisdom() >= 8 || player.getKnowledgeLevel() >= 3) {
            System.out.println("You answer: 'Truth is not comfort.' He smiles. 'Then you may live.'");
        } else {
            System.out.println("You hesitate. He screams and throws a blade of light. You dodge just in time.");
            player.takeDamage(10);
        }
    }

    public static void forgottenScriptures(PlayerCharacter player) {
        System.out.println("In a chapel’s ruins, you find a locked tome glowing faintly.");
        if (player.getMemory().getFlag("knowsAncient")) {
            System.out.println("You read its words: 'The five became one, then became none.'");
            player.increaseKnowledge();
        } else {
            System.out.println("You open it—only blindness greets you. You slam it shut.");
            player.useMP(5);
        }
    }

    public static void VellaInvitation(PlayerCharacter player) {
        System.out.println("A masked courier delivers you a letter with a wax seal of the City: 'Vella calls.'");
        if (player.getMemory().getFlag("suspected heretic")) {
            System.out.println("You are escorted in silence to the edge of the city... where she waits.");
            player.getMemory().rememberDecision("audience with Vella");
        } else {
            System.out.println("You are deemed unready. The letter burns in your hand.");
        }
    }
}
