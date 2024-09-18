package game;

import com.codes.vinis.vEngine.core.Core;
import com.codes.vinis.vEngine.core.Renderer;
import com.codes.vinis.vEngine.game.Game;
import com.codes.vinis.vEngine.gfx.image.Sprite;
import com.codes.vinis.vEngine.gfx.image.animate.AnimateSprite;
import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import com.codes.vinis.vEngine.window.Window;
import org.jetbrains.annotations.NotNull;

import java.awt.event.KeyEvent;

public class GameManager implements Game {

    private @NotNull Sprite sprite;

    public GameManager() {

        this.sprite = new Sprite("src/main/resources/person/person1.png", new Location(0, 0));
    }

    @Override
    public void update(@NotNull Core core, float deltaTime) {

        if (core.getINPUT().isKey(KeyEvent.VK_W)) {
            sprite.invertY(1);
            sprite.getLocation().setY(sprite.getLocation().getY() - 2);
        }
        if (core.getINPUT().isKey(KeyEvent.VK_S)) {
            sprite.invertY(-1);
            sprite.getLocation().setY(sprite.getLocation().getY() + 2);
        }
        if (core.getINPUT().isKey(KeyEvent.VK_A)) {

            sprite.invertX(-1);
            sprite.getLocation().setX(sprite.getLocation().getX() - 2);
        }
        if (core.getINPUT().isKey(KeyEvent.VK_D)) {

            sprite.invertX(1);
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
