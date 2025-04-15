import java.util.*;
import javax.swing.*;

public class SceneLibrary {
    public static List<Scene> loadNormalScenes(SceneManager manager, PlayerCharacter player) {
        List<Scene> scenes = new ArrayList<>();

        // Positive/Neutral Events
        scenes.add(new Scene("You open a mysterious lunchbox. It smells ancient.",
                List.of(
                        new SceneOption("Eat it", () -> player.restoreHP(5)),
                        new SceneOption("Throw it away", () -> {})
                )));

        scenes.add(new Scene("A ragged cat with one eye darts into the shadows.",
                List.of(
                        new SceneOption("Follow it", () -> {
                            if (player.getMajor().equals("Arithmetic")) player.intelligence++;
                        }),
                        new SceneOption("Let it go", () -> {})
                )));

        scenes.add(new Scene("You stare at a flickering rune above a lantern.",
                List.of(
                        new SceneOption("Focus on the rhythm", () -> {
                            player.useMP(3);
                            if (player.getMajor().equals("Astronomy")) player.wisdom++;
                        }),
                        new SceneOption("Look away", () -> {})
                )));

        scenes.add(new Scene("You inspect an old desk in the hall.",
                List.of(
                        new SceneOption("Check inside", () -> {
                            int chance = new Random().nextInt(100);
                            if (chance < 10) {
                                player.increaseKnowledge();
                            } else if (chance < 70) {
                                player.strength++;
                            }
                        }),
                        new SceneOption("Ignore it", () -> {})
                )));

        scenes.add(new Scene("A hooded stranger watches you silently.",
                List.of(
                        new SceneOption("Approach them", () -> {
                            int chance = new Random().nextInt(100);
                            if (chance < 25) player.getMemory().rememberDecision("met watcher");
                            else if (chance < 50) player.wisdom++;
                        }),
                        new SceneOption("Avoid them", () -> {})
                )));

        scenes.add(new Scene("You tap a rune-marked brick on the wall.",
                List.of(
                        new SceneOption("Press harder", () -> player.restoreMP(1)),
                        new SceneOption("Walk away", () -> {})
                )));

        scenes.add(new Scene("A cloaked figure steps forward.",
                List.of(
                        new SceneOption("Listen to the emissary", () -> {
                            StringBuilder result = new StringBuilder("The emissary stares into your soul.\n\n");
                            boolean matched = false;
                            if (player.getWisdom() >= 6) {
                                result.append("\u2022 Guild of Ash: \"You see through the fog.\"\n");
                                matched = true;
                            }
                            if (player.getKnowledgeLevel() >= 2) {
                                result.append("\u2022 Seekers of Vella: \"You've begun to unravel.\"\n");
                                matched = true;
                            }
                            if (player.getCharisma() >= 6) {
                                result.append("\u2022 Inquisition: \"We recognize your loyalty.\"\n");
                                matched = true;
                            }
                            if (!matched) {
                                result.append("None respond. The emissary fades without a word.");
                            }
                            JOptionPane.showMessageDialog(null, result.toString(), "Emissary Response", JOptionPane.INFORMATION_MESSAGE);
                        }),
                        new SceneOption("Ignore them", () -> {})
                )));

        // Negative Events
        scenes.add(new Scene("You bite into a glowing fruit. It was rotten inside.",
                List.of(
                        new SceneOption("Spit it out", () -> player.takeDamage(10)),
                        new SceneOption("Keep chewing", () -> player.takeDamage(20))
                )));

        scenes.add(new Scene("A hidden rune explodes beneath your step!",
                List.of(
                        new SceneOption("Brace yourself", () -> player.takeDamage(15)),
                        new SceneOption("Dive for cover", () -> player.useMP(5))
                )));

        scenes.add(new Scene("You feel suddenly very cold. Your heart slows.",
                List.of(
                        new SceneOption("Focus your will", () -> {
                            player.takeDamage(5);
                            player.useMP(3);
                        }),
                        new SceneOption("Give in to the sleep", () -> {
                            player.takeDamage(50);
                        })
                )));

        // Death event logic example (player must be checked externally in GUI)
        scenes.add(new Scene("You step into complete darkness. Something whispers: \"Rest now.\"",
                List.of(
                        new SceneOption("Accept fate", () -> {
                            player.takeDamage(player.getCurrentHP());
                            JOptionPane.showMessageDialog(null, "You have died.", "End", JOptionPane.WARNING_MESSAGE);
                            System.exit(0);
                        })
                )));

        return scenes;
    }

    public static List<Scene> professorChain(PlayerCharacter player) {
        return List.of(
                new Scene("The cloaked professor turns slowly. \"Knowledge is not a right... it is a burden.\"",
                        List.of(new SceneOption("Nod silently", () -> player.getMemory().rememberDecision("met professor"))))
        );
    }

    public static List<Scene> statueEncounter(PlayerCharacter player) {
        String desc = "You stare into the hollow eyes of a marble statue. Its hand is raised—not in greeting, but judgment.";
        if (player.getMemory().hasMade("met professor")) {
            desc += "\n\nSomething about the statue's gaze seems... softer. A compartment opens.";
            player.increaseKnowledge();
        }
        return List.of(new Scene(desc, List.of(new SceneOption("Step back", () -> {}))));
    }

    public static List<Scene> libraryDiscovery(PlayerCharacter player) {
        String desc = "A shadow flits past an old bookcase. A whisper: \"Do not trust what is written.\"";
        if (player.getKnowledgeLevel() >= 1) {
            desc += "\n\nYou notice a text that wasn’t there before. It bears your name.";
        }
        return List.of(new Scene(desc, List.of(new SceneOption("Leave quietly", () -> {}))));
    }
}
