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

    public GameManager() {

        this.sprite = new Image("src/main/resources/person/person1.png", new Location(0, 0));
    }

    @Override
    public void update(@NotNull Core core, float deltaTime) {

        if (core.getINPUT().isKey(KeyEvent.VK_W)) {

            sprite.getLocation().setY(sprite.getLocation().getY() - 2);
        }
        if (core.getINPUT().isKey(KeyEvent.VK_S)) {

            sprite.getLocation().setY(sprite.getLocation().getY() + 2);
        }
        if (core.getINPUT().isKey(KeyEvent.VK_A)) {

            sprite.getLocation().setX(sprite.getLocation().getX() - 2);
        }
        if (core.getINPUT().isKey(KeyEvent.VK_D)) {

            sprite.getLocation().setX(sprite.getLocation().getX() + 2);
        }
    }

    @Override
    public void render(@NotNull Core core, @NotNull Renderer renderer) {
        renderer.drawImage(sprite);
    }

    public static void main(String[] args) {
        @NotNull Core core = new Core(new Window("my game", new Dimension(400, 300), 2f));

        core.start();
    }
}
