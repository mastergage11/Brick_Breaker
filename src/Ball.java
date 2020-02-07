import java.awt.*;

public class Ball {

    int x, y, diameter = 20;
    private final int speed = 5;
    double dx = speed, dy = speed;
    double maxAngle = 5*Math.PI/12;
    Board board;

    public Ball(Board board){
        x = board.getWidth()/2 - (diameter/2);
        y = board.getHeight() - (diameter*3);
        this.board = board;
    }

    public void move(){

        //LEFT AND RIGHT
        if(x <= 0){
            dx*=-1;
        }
        if(x + diameter >= board.getWidth()){
            dx*=-1;
        }
        if(y <= 0 || y + diameter >= board.getHeight()){
            dy*=-1;
        }

        x+=dx;
        y+=dy;
    }

    

    public void paint(Graphics g){
        g.setColor(Color.WHITE); //ball will change color depending on speed, speed will change depending on which block is hit but will not decrease if ball hits a block that wants to lower its current speed
        g.fillOval(x, y, diameter, diameter);
    }

    public void checkCollisions(Bricks[][] bricks) {

    }

    public void checkCollisions(Player player) {
        if(getBounds().intersects(player.getBounds())){
            double playr = player.getBounds().getX();
            double ballX = x;

            if(x + (diameter/2) < playr){
                ballX = x + diameter;
            }
            else if(x + (diameter/2) > playr + player.getBounds().getWidth()){
                ballX = x;
            }
            else{
                ballX = x + diameter;
                if(x < board.getHeight()/2){
                    dy*=-1;
                }
                if(x > board.getHeight()/2){
                    dy*=-1;
                }
            }
        }
    }
    
    private Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }


    public void get(int i) {
        get(i);
    }
}


////if ball touches player, ball.setPosition(~, board.getHeight() - (diameter*3))