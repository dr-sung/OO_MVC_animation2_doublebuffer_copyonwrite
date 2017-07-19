package model;

import controller.Main;
import view.GamePanel;
import java.awt.Color;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameData {

    private final int RADIUS = 6;
    public final List<GameFigure> figures;

    private int totalEnemies = 0;
    private int killedEnemies = 0;

    public GameData() {

        //figures = Collections.synchronizedList(new ArrayList<>());
        figures = new CopyOnWriteArrayList<>();

        // GamePanel.width, height are known when rendered. Thus, at this moment,
        // we cannot use GamePanel.width and height.
        figures.add(
                new Shooter(Main.WIN_WIDTH / 2, Main.WIN_HEIGHT - 130));
    }

    public void add(int n) {

        totalEnemies += n;

        for (int i = 0; i < n; i++) {
            float red = (float) Math.random();
            float green = (float) Math.random();
            float blue = (float) Math.random();
            // adjust if too dark since the background is black
            if (red < 0.5) {
                red += 0.2;
            }
            if (green < 0.5) {
                green += 0.2;
            }
            if (blue < 0.5) {
                blue += 0.2;
            }
            figures.add(new Ball(
                    (int) (Math.random() * GamePanel.width),
                    (int) (Math.random() * GamePanel.height),
                    RADIUS,
                    new Color(red, green, blue)));
        }

    }

    public void update() {
        
        for (GameFigure f : figures) {
            f.update();
        }

    }

    public int getTotalEnemies() {
        return totalEnemies;
    }

    public void setTotalEnemies(int totalEnemies) {
        this.totalEnemies = totalEnemies;
    }

    public int getKilledEnemies() {
        return killedEnemies;
    }

    public void setKilledEnemies(int killedEnemies) {
        this.killedEnemies = killedEnemies;
    }

}
