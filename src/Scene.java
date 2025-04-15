import java.util.List;

public class Scene {
    public String description;
    public List<SceneOption> options;

    public Scene(String description, List<SceneOption> options) {
        this.description = description;
        this.options = options;
    }
}