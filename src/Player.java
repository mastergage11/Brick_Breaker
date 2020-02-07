import java.awt.*;

public class Player {

    int x, y;
    final int WIDTH = 250, HEIGHT = 20;
    double speed, dx = 4, dy;

    public Player(Board board){
        x = board.getWidth()/2 - WIDTH/2;
        y = board.getHeight() - (HEIGHT + 20);
    }

    public void paint(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWIDTH() {
        return WIDTH;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void moveRight(){
        x+=dx;
    }

    public void moveLeft(){
        x-=dx;
    }
}
