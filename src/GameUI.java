import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameUI {
    private JFrame frame;
    private JTextArea storyArea;
    private JPanel buttonPanel;
    private PlayerCharacter player;
    private SceneManager sceneManager;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameUI().showCharacterCreation());
    }

    public void showCharacterCreation() {
        frame = new JFrame("City of Liberty - Character Creation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        JTextArea intro = new JTextArea("Welcome to the University of Liberty.\n\nChoose your Major — this will shape how you see the world.");
        intro.setFont(new Font("Serif", Font.PLAIN, 16));
        intro.setEditable(false);
        intro.setLineWrap(true);
        intro.setWrapStyleWord(true);
        intro.setMargin(new Insets(10, 10, 10, 10));
        frame.add(intro, BorderLayout.NORTH);

        JPanel majorsPanel = new JPanel();
        majorsPanel.setLayout(new GridLayout(0, 2, 10, 10));
        String[] majors = {
                "Runic Medicine", "Runic Warfare", "Historical Inquiry",
                "Translation Studies", "Religious Doctrine", "Arithmetic",
                "Theology", "Astronomy"
        };

        for (String major : majors) {
            JButton btn = new JButton(major);
            btn.addActionListener(e -> {
                createPlayer("Aelric", major);
                showFirstScene();
            });
            majorsPanel.add(btn);
        }

        frame.add(majorsPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void createPlayer(String name, String major) {
        String runeAffinity = switch (major) {
            case "Runic Medicine" -> "Healing Sigils";
            case "Runic Warfare" -> "Strike Glyphs";
            case "Historical Inquiry" -> "Chrono Scripts";
            case "Translation Studies" -> "Ciphered Runes";
            case "Religious Doctrine" -> "Divine Marks";
            case "Arithmetic" -> "Pattern Chains";
            case "Theology" -> "Liturgical Seals";
            case "Astronomy" -> "Celestial Marks";
            default -> "Unknown";
        };
        player = new PlayerCharacter(name, major, runeAffinity, "Fresh initiate", 100, 50, 5, 6, 4, 5);
        sceneManager = new SceneManager();
        sceneManager.addNormalScenes(SceneLibrary.loadNormalScenes(sceneManager, player));
    }

    public void showFirstScene() {
        frame.getContentPane().removeAll();
        frame.setTitle("University District - City of Liberty");

        storyArea = new JTextArea();
        storyArea.setEditable(false);
        storyArea.setFont(new Font("Serif", Font.ITALIC, 16));
        storyArea.setLineWrap(true);
        storyArea.setWrapStyleWord(true);
        storyArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scroll = new JScrollPane(storyArea);
        frame.add(scroll, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1));
        frame.add(buttonPanel, BorderLayout.SOUTH);

        showNextScene();
        frame.revalidate();
        frame.repaint();
    }

    private void showNextScene() {
        Scene next = sceneManager.getNextScene();
        storyArea.setText(next.description);
        buttonPanel.removeAll();

        for (SceneOption option : next.options) {
            JButton btn = new JButton(option.text);
            btn.addActionListener(e -> {
                option.action.run();
                showNextScene();
            });
            buttonPanel.add(btn);
        }

        frame.revalidate();
        frame.repaint();
    }
}
