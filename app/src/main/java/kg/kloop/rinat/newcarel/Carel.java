package kg.kloop.rinat.newcarel;

        import android.os.Handler;
        import android.os.SystemClock;

/**
 * Этот класс содержит методы, определяющие поведение Карела*/
public class Carel extends Object{

    public Carel(GameCanvas gameCanvas, CarelGrid grid) {
        this.grid = grid;
        x = grid.getCarelX();
        y = grid.getCarelY();
        directionX = grid.getCarelDirectionX();
        directionY = grid.getCarelDirectionY();
        dead = grid.isCarelDead();
        game = gameCanvas;
        game.draw(grid);
    }

    public void move(){

        if (!dead){
            x = x + directionX;
            y = y - directionY;
            if (outOfBounds(x, y)) {
                die();
            }
            update();
        }
    }

    public void turnLeft() {
        if (!dead) {
            if (directionY != 0){
                directionX = directionY * (-1);
                directionY = 0;
            } else {
                directionY = directionX;
                directionX = 0;
            }
            update();
        }
    }

    public void dropBeeper() {
        if (!dead){
            grid.placeBeeper(x, y);
            update();
        }
    }

    public void collectBeeper() {
        if (!dead){
            if (isBeeper()) {
                grid.removeBeeper(x, y);
            } else die();
            update();
        }
    }

    public boolean isBeeper() {
        if (grid.isBeeper(x, y)) {
            return true;
        } else return false;
    }

    public boolean isFrontClear() {
        int frontX = x + directionX;
        int frontY = y - directionY;

        if (outOfBounds(frontX, frontY)) {
            return false;
        } else return true;
    }

    private void update() {

        if (!dead) {
            grid.setCarelX(x);
            grid.setCarelY(y);
        }
        grid.setCarelDirectionX(directionX);
        grid.setCarelDirectionY(directionY);
        grid.setCarelDead(dead);
        game.draw(grid);
    }

    private void die() {
        dead = true;
    }

    private boolean outOfBounds (int x, int y) {
        if (x >= grid.getWidth() || y >= grid.getHeight() || x<0 || y<0 || grid.getBeepersNumber(x , y) < 0) {
            return true;
        } else return false;
    }

    private CarelGrid grid = null;
    private int x = 0;
    private int y = 0;
    private GameCanvas game = null;
    private int directionX = 1;
    private int directionY = -1;
    private boolean dead = false;


}
