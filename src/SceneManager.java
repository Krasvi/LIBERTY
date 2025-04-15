import java.util.*;

public class SceneManager {
    private List<Scene> normalScenes;
    private Queue<Scene> currentChain;
    private Random rand = new Random();

    public SceneManager() {
        normalScenes = new ArrayList<>();
        currentChain = new LinkedList<>();
    }

    public void addNormalScene(Scene scene) {
        normalScenes.add(scene);
    }

    public void addNormalScenes(List<Scene> scenes) {
        normalScenes.addAll(scenes);
    }

    public void triggerSceneChain(List<Scene> scenes) {
        currentChain.addAll(scenes);
    }

    public boolean hasNextScene() {
        return !currentChain.isEmpty() || !normalScenes.isEmpty();
    }

    public Scene getNextScene() {
        if (!currentChain.isEmpty()) {
            return currentChain.poll();
        }
        if (!normalScenes.isEmpty()) {
            return normalScenes.get(rand.nextInt(normalScenes.size()));
        }
        return new Scene("There is nothing here...", List.of());
    }

    public void clearNormalScenes() {
        normalScenes.clear();
    }

    public void clearCurrentChain() {
        currentChain.clear();
    }
}
