import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {

    Game game;
    Player player;
    Ball ball;
    Bricks[][] bricks  = new Bricks[4][8];
    Timer timer;

    public Board(Game game){
        this.game = game;
        setPreferredSize(new Dimension(1200, 700));
        setBackground(Color.DARK_GRAY);
        timer = new Timer(1000/60, this);
        timer.start();
    }
    
    public void setup(){
        player = new Player(this);
        ball = new Ball(this);
        for(int row = 0; row < 4; row++) {
            for (int col = 0; col < 8; col++) {
                bricks[row][col] = new Bricks(13 + col*150,100 + row*95);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.paint(g);
        ball.paint(g);
        for(int row = 0; row < 4; row++) {
            for (int col = 0; col < 8; col++){
                bricks[row][col].paint(g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ball.checkCollisions(player);
        ball.move();

        if(game.isLeftPressed() && player.getX() > 0 ){
            player.moveLeft();
            System.out.println("DFTGJ");
        }

        if(game.isRightPressed() && player.getX() + player.getWIDTH() < getWidth()){
            player.moveRight();
            System.out.println("ghj");
        }

        /*public void checkCollisions(){

            for(int i = ball.size()-1; i >= 0; i--){
                for(int j = 0; j < bricks.length; j++){
                    for(int k = 0; k < bricks[0].length; k++){
                        if(bricks[j][k] != null){
                            if(ball.get(i).getBounds().intersects(bricks[j][k].getBounds())){
                                ball.get(i).setRemove();
                                bricks[j][k] = null;
                                break;
                            }
                        }
                    }
                }

        }*/
        repaint();
    }
}
