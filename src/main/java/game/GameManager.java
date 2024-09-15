package game;

import com.codes.vinis.vEngine.core.Core;
import com.codes.vinis.vEngine.core.Renderer;
import com.codes.vinis.vEngine.game.Game;
import com.codes.vinis.vEngine.gfx.image.Image;
import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import com.codes.vinis.vEngine.window.Window;
import org.jetbrains.annotations.NotNull;

import java.awt.event.KeyEvent;

public class GameManager implements Game {

    private @NotNull Image sprite;

    private @NotNull Location location;

    public GameManager() {

        this.sprite = new Image("src/main/resources/person/person1.png", new Dimension(45, 45));

        this.location = new Location(0, 0);
    }

    @Override
    public void update(@NotNull Core core, float deltaTime) {

        if (core.getINPUT().isKey(KeyEvent.VK_W)) {
            location = new Location(location.getX(), location.getY() - 1);
        }
        if (core.getINPUT().isKey(KeyEvent.VK_S)) {
            location = new Location(location.getX(), location.getY() + 1);
        }
        if (core.getINPUT().isKey(KeyEvent.VK_A)) {
            location = new Location(location.getX() - 1, location.getY());
        }
        if (core.getINPUT().isKey(KeyEvent.VK_D)) {
            location = new Location(location.getX() + 1, location.getY());
        }
    }

    @Override
    public void render(@NotNull Core core, @NotNull Renderer renderer) {
        renderer.drawImage(sprite, location);
    }

    public static void main(String[] args) {
        @NotNull Core core = new Core(new Window("my game", new Dimension(500, 400)));

        core.start();
    }
}
