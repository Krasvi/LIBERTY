
// SceneOption.java
public class SceneOption {
    public String text;
    public Runnable action;

    public SceneOption(String text, Runnable action) {
        this.text = text;
        this.action = action;
    }
}