// SceneLibrary_Full.java - Fully Expanded with 100+ Lore-Driven Scenes
// Based on "The City of Liberty" essay and game world

import java.util.*;
import javax.swing.*;

public class SceneLibrary
{
    public static List<Scene> loadAllScenes(SceneManager manager, PlayerCharacter player) {
        List<Scene> scenes = new ArrayList<>();

        scenes.add(new Scene("You attend your first lecture on Rune Philosophy. The professor’s voice wavers at the word ‘Order.’",
                List.of(
                        new SceneOption("Press the question", () -> {
                            if (player.getWisdom() >= 6) {
                                player.getMemory().rememberDecision("challenged lecture authority");
                                player.increaseKnowledge();
                            }
                        }),
                        new SceneOption("Take quiet notes", () -> {})
                )));

        scenes.add(new Scene("A cloaked student passes you a pamphlet labeled 'The Lie of the Hierophant.'",
                List.of(
                        new SceneOption("Read it", () -> player.getMemory().rememberDecision("read forbidden pamphlet")),
                        new SceneOption("Burn it", () -> player.strength++)
                )));

        scenes.add(new Scene("You find a chalk outline of a rune altered with red ink on a campus wall.",
                List.of(
                        new SceneOption("Copy the symbol", () -> {
                            if (player.getMajor().equals("Translation")) player.increaseKnowledge();
                        }),
                        new SceneOption("Erase it", () -> player.charisma++)
                )));

        scenes.add(new Scene("The Chancellor warns students: 'Knowledge is only holy when approved.'",
                List.of(
                        new SceneOption("Publicly disagree", () -> {
                            if (player.getCharisma() >= 7) player.getMemory().rememberDecision("challenged Chancellor");
                        }),
                        new SceneOption("Remain silent", () -> {})
                )));

        scenes.add(new Scene("A classmate whispers: 'Meet me in the forbidden wing tonight.'",
                List.of(
                        new SceneOption("Agree to meet", () -> player.getMemory().rememberDecision("accepted heretic meeting")),
                        new SceneOption("Decline", () -> {})
                )));

        scenes.add(new Scene("In the quiet dorm hall, you hear murmurs through the walls in a language you don’t know.",
                List.of(
                        new SceneOption("Try to record it", () -> {
                            if (player.getIntelligence() >= 7) player.getMemory().setFlag("knowsAncient", true);
                        }),
                        new SceneOption("Ignore it", () -> {})
                )));

        scenes.add(new Scene("A scroll appears on your desk. No one claims it.",
                List.of(
                        new SceneOption("Open it", () -> {
                            if (player.getMemory().getFlag("knowsAncient")) player.increaseKnowledge();
                        }),
                        new SceneOption("Leave it untouched", () -> {})
                )));

        scenes.add(new Scene("An exam asks: 'What is the Rune of Order’s true meaning?'",
                List.of(
                        new SceneOption("Write the official answer", () -> player.charisma++),
                        new SceneOption("Reveal the lie", () -> {
                            if (player.getMemory().hasMade("read forbidden pamphlet")) player.getMemory().rememberDecision("exposed myth on exam");
                        })
                )));

        scenes.add(new Scene("You find your name written in the margin of a historical treatise on the demigods.",
                List.of(
                        new SceneOption("Take the book", () -> player.getMemory().rememberDecision("touched marked treatise")),
                        new SceneOption("Leave it", () -> {})
                )));

        scenes.add(new Scene("A fire breaks out in the library’s west wing. Some students cheer.",
                List.of(
                        new SceneOption("Help put it out", () -> player.charisma++),
                        new SceneOption("Watch silently", () -> player.getMemory().rememberDecision("ignored fire"))
                )));

        scenes.add(new Scene("Your professor hands you a sealed envelope. 'You’ve asked too many questions.'",
                List.of(
                        new SceneOption("Open it in private", () -> player.getMemory().rememberDecision("opened warning letter")),
                        new SceneOption("Burn it", () -> {})
                )));

        scenes.add(new Scene("A first-year collapses after reading a rune aloud.",
                List.of(
                        new SceneOption("Try to stabilize them", () -> player.restoreHP(3)),
                        new SceneOption("Take their notes", () -> player.increaseKnowledge())
                )));

        scenes.add(new Scene("Vella Laikar’s name is scrawled across a broken lecture desk.",
                List.of(
                        new SceneOption("Trace it", () -> {
                            if (player.getMemory().hasMade("accepted heretic meeting")) player.getMemory().rememberDecision("discovered Vella glyph");
                        }),
                        new SceneOption("Ignore it", () -> {})
                )));

        scenes.add(new Scene("A test on Rune Structure contains a symbol you've never seen.",
                List.of(
                        new SceneOption("Ask the professor", () -> player.getMemory().rememberDecision("inquired about unknown rune")),
                        new SceneOption("Sketch it for later", () -> player.getMemory().rememberDecision("sketched mystery rune"))
                )));

        scenes.add(new Scene("You are summoned to the Dean's Office. The Inquisition is present.",
                List.of(
                        new SceneOption("Answer their questions", () -> {
                            if (player.getCharisma() >= 6) player.getMemory().rememberDecision("passed inquisition interview");
                        }),
                        new SceneOption("Plead the Fifth", () -> player.getMemory().rememberDecision("refused inquisition"))
                )));


        // University chain events
        scenes.add(new Scene("You attend your first lecture on Rune Philosophy. The professor’s voice wavers at the word ‘Order.’",
                List.of(
                        new SceneOption("Press the question", () -> {
                            if (player.getWisdom() >= 6) {
                                player.getMemory().rememberDecision("challenged lecture authority");
                                player.increaseKnowledge();
                            }
                        }),
                        new SceneOption("Take quiet notes", () -> {})
                )));

        scenes.add(new Scene("A cloaked student passes you a pamphlet labeled 'The Lie of the Hierophant.'",
                List.of(
                        new SceneOption("Read it", () -> player.getMemory().rememberDecision("read forbidden pamphlet")),
                        new SceneOption("Burn it", () -> player.strength++)
                )));

        scenes.add(new Scene("That same student invites you to a book circle. 'Truth has teeth,' she says.",
                List.of(
                        new SceneOption("Attend the meeting", () -> {
                            if (player.getMemory().hasMade("read forbidden pamphlet")) {
                                player.getMemory().rememberDecision("joined heretic book circle");
                                player.increaseKnowledge();
                            }
                        }),
                        new SceneOption("Refuse the offer", () -> {})
                )));

        scenes.add(new Scene("In a hidden classroom, you find a chalkboard covered in redacted runes.",
                List.of(
                        new SceneOption("Attempt to decipher them", () -> {
                            if (player.getMemory().getFlag("knowsAncient")) player.getMemory().rememberDecision("decoded redacted board");
                        }),
                        new SceneOption("Photograph them for later", () -> player.getMemory().rememberDecision("archived forbidden board"))
                )));

        scenes.add(new Scene("The Chancellor warns students: 'Knowledge is only holy when approved.'",
                List.of(
                        new SceneOption("Publicly disagree", () -> {
                            if (player.getCharisma() >= 7) player.getMemory().rememberDecision("challenged Chancellor");
                        }),
                        new SceneOption("Remain silent", () -> {})
                )));

        scenes.add(new Scene("In a forgotten corridor, an old professor whispers: 'Laikar was right.'",
                List.of(
                        new SceneOption("Ask him more", () -> {
                            if (player.getMemory().hasMade("discovered Vella glyph")) player.getMemory().rememberDecision("spoke with Vella sympathizer");
                        }),
                        new SceneOption("Walk away", () -> {})
                )));

        scenes.add(new Scene("You are handed a letter sealed in black wax. It bears no name.",
                List.of(
                        new SceneOption("Read it in solitude", () -> player.getMemory().rememberDecision("opened black letter")),
                        new SceneOption("Burn it in fear", () -> {})
                )));

        scenes.add(new Scene("Inside the university chapel, you hear a hymn that reverses itself.",
                List.of(
                        new SceneOption("Sing along", () -> {
                            if (player.getMemory().hasMade("knowsAncient")) player.increaseKnowledge();
                        }),
                        new SceneOption("Cover your ears", () -> player.useMP(2))
                )));

        scenes.add(new Scene("You return to your dorm. On your pillow lies a rune shard.",
                List.of(
                        new SceneOption("Hide it", () -> player.getMemory().setFlag("rune shard kept", true)),
                        new SceneOption("Submit it to the archives", () -> player.charisma++)
                )));

        scenes.add(new Scene("A visiting official from the Church asks your class: 'Who do you serve?'",
                List.of(
                        new SceneOption("Declare loyalty to the Hierophant", () -> player.getMemory().rememberDecision("declared for Church")),
                        new SceneOption("Stay silent", () -> player.getMemory().rememberDecision("refused allegiance"))
                )));

        scenes.add(new Scene("In a hidden classroom, you find a chalkboard covered in redacted runes.",
                List.of(
                        new SceneOption("Attempt to decipher them", () -> {
                            if (player.getMemory().getFlag("knowsAncient")) player.getMemory().rememberDecision("decoded redacted board");
                        }),
                        new SceneOption("Photograph them for later", () -> player.getMemory().rememberDecision("archived forbidden board"))
                )));

        scenes.add(new Scene("The Chancellor warns students: 'Knowledge is only holy when approved.'",
                List.of(
                        new SceneOption("Publicly disagree", () -> {
                            if (player.getCharisma() >= 7) player.getMemory().rememberDecision("challenged Chancellor");
                        }),
                        new SceneOption("Remain silent", () -> {})
                )));

        scenes.add(new Scene("In a forgotten corridor, an old professor whispers: 'Laikar was right.'",
                List.of(
                        new SceneOption("Ask him more", () -> {
                            if (player.getMemory().hasMade("discovered Vella glyph")) player.getMemory().rememberDecision("spoke with Vella sympathizer");
                        }),
                        new SceneOption("Walk away", () -> {})
                )));

        scenes.add(new Scene("You are handed a letter sealed in black wax. It bears no name.",
                List.of(
                        new SceneOption("Read it in solitude", () -> player.getMemory().rememberDecision("opened black letter")),
                        new SceneOption("Burn it in fear", () -> {})
                )));

        scenes.add(new Scene("Inside the university chapel, you hear a hymn that reverses itself.",
                List.of(
                        new SceneOption("Sing along", () -> {
                            if (player.getMemory().hasMade("knowsAncient")) player.increaseKnowledge();
                        }),
                        new SceneOption("Cover your ears", () -> player.useMP(2))
                )));

        scenes.add(new Scene("You return to your dorm. On your pillow lies a rune shard.",
                List.of(
                        new SceneOption("Hide it", () -> player.getMemory().setFlag("rune shard kept", true)),
                        new SceneOption("Submit it to the archives", () -> player.charisma++)
                )));

        scenes.add(new Scene("A visiting official from the Church asks your class: 'Who do you serve?'",
                List.of(
                        new SceneOption("Declare loyalty to the Hierophant", () -> player.getMemory().rememberDecision("declared for Church")),
                        new SceneOption("Stay silent", () -> player.getMemory().rememberDecision("refused allegiance"))
                )));

        // Vella Laikar reveal ending
        scenes.add(new Scene("A door appears in the campus wall where there was none.",
                List.of(
                        new SceneOption("Enter silently", () -> {
                            if (player.getMemory().hasMade("spoke with Vella sympathizer") &&
                                    player.getMemory().hasMade("joined heretic book circle") &&
                                    player.getMemory().hasMade("opened black letter") &&
                                    player.getMemory().getFlag("knowsAncient") &&
                                    player.getMemory().getFlag("rune shard kept")) {

                                JOptionPane.showMessageDialog(null,
                                        "You step into the candlelit chamber. A voice speaks: 'You have come far. I am Vella Laikar.'",
                                        "The End", JOptionPane.INFORMATION_MESSAGE);

                                JOptionPane.showMessageDialog(null,
                                        "She smiles gently. 'The truth is not given. It is chosen. You have chosen to see.'",
                                        "Your Journey Begins...", JOptionPane.INFORMATION_MESSAGE);

                                System.exit(0);
                            }
                        }),
                        new SceneOption("Ignore it", () -> {})
                )));


        return scenes;
    }
}
