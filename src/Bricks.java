import java.awt.*;

public class Bricks {

    int x, y, WIDTH = 125, HEIGHT = 55;
    int dx, dy;
    int numEnemies = 36;
    boolean remove;

    public Bricks(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public int getNumEnemies(){
        return numEnemies;
    }

    public void setRemove(){
        remove = true;
    }
    public boolean getRemove(){
        return remove;
    }
}
