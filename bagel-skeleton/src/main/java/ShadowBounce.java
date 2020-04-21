/**
 * SWEN20003 Object Oriented Software Development
 * Project 2b, Semester 2, 2019
 *
 * @Description Shadow Bounce is a game where the players objective is to destroy all red pegs before they run out of
 *              shots
 *              Player have 20 shots for each board
 *              Player wins when they succeed for all 5 boards
 * @author Nicholas 956970
 */
import bagel.AbstractGame;
import bagel.Input;
import bagel.MouseButtons;
import bagel.Window;
import bagel.util.Point;
import bagel.util.Side;
import bagel.util.Vector2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ShadowBounce extends AbstractGame {

    private static final Point BALL_POSITION = new Point(512, 32);
    private static final Vector2 LEFT_UP = Vector2.left.add(Vector2.up);
    private static final Vector2 Right_UP = Vector2.right.add(Vector2.up);
    private  static final int FSPEED =10;
    private static final  int MAX_BOARD =5;
    private Point BUCKET_START = new Point(512,744);
    private Bucket bucket;
    private Board board;
    private Powerup powerup;
    private boolean turn =false,intersected=false,created=false;
    private ArrayList<Ball> balls=new ArrayList<>();
    private String[] boards = new String[MAX_BOARD];
    private int shots=20,boardnum =0;

    public ShadowBounce() throws IOException {

        //initialize boards and check if powerup is created during first round
        for(int i=0 ;i<MAX_BOARD;i++){
            boards[i]="res/"+i+".csv";
        }

        board=new Board(boards[0]);
        System.out.print("Level:" + boardnum+"\n");
        Random random =new Random();
        int num =random.nextInt(11);
        if(num==1){
            created=true;
        }else{
            powerup=null;
        }
    }



    @Override
    protected void update(Input input) {
        ArrayList<Peg> remove=new ArrayList<>();
        ArrayList<Ball> removeball=new ArrayList<>();
        ArrayList<Ball> addball=new ArrayList<>();
        Ball temp,temp1;

        //if there are no red pegs left on board, either advance to next board/ win the game
        if (board.redLeft()==0){
            boardnum++;
            if (boardnum==MAX_BOARD) {
                System.out.println("Congrats ! YOU WON !!!");
                System.exit(0);
            }else{
                System.out.print("Level:" + boardnum+"\n");
            }
            try {
                board=new Board(boards[boardnum]);
                balls.clear();
                shots=20;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //if there are balls on screen(turn has begun)
        if (!balls.isEmpty()) {
            for (Ball ball : balls) {

                //if ball intersects with powerup, ball becomes fireball and powerup dissappears
                if (powerup != null) {
                    if (ball.intersects(powerup)) {
                        temp=new Fireball(ball.getPoint(), ball.getVelocity());
                        removeball.add(ball);
                        addball.add(temp);
                        powerup = null;
                        break;
                    }
                }

                //record that ball has intersected with bucket so that there will be an additional shot next turn
                if (ball.intersects(bucket)){
                    intersected=true;

                }

                /*
                check each peg if it intersects with ball
                if green peg, create two new ball that are the same type
                also check side of intersection to determine ball bounce direction
                 */
                for (Peg current : board.allpegs) {
                    if (current.rect.intersectedAt(ball.getPoint(), ball.getVelocity()) == Side.TOP) {
                        remove.add(current);
                        ball.reverseTop();
                        if (current instanceof GreenPeg) {
                            if (ball instanceof NormalBall){
                                temp=new NormalBall(ball.getPoint(), LEFT_UP);
                                temp1=new NormalBall(ball.getPoint(), Right_UP);
                                addball.add(temp);
                                addball.add(temp1);
                            }else{
                                temp=new Fireball(ball.getPoint(), LEFT_UP.mul(FSPEED));
                                temp1=new Fireball(ball.getPoint(), Right_UP.mul(FSPEED));
                                addball.add(temp);
                                addball.add(temp1);
                            }
                        }
                        if (ball instanceof Fireball){
                            board.destroy(current.rect.centre());
                        }
                        break;
                    }
                    else if (current.rect.intersectedAt(ball.getPoint(), ball.getVelocity()) == Side.BOTTOM) {
                        remove.add(current);
                        ball.reverseTop();
                        if (current instanceof GreenPeg) {
                            if (ball instanceof NormalBall){
                                temp=new NormalBall(ball.getPoint(), LEFT_UP);
                                temp1=new NormalBall(ball.getPoint(), Right_UP);
                                addball.add(temp);
                                addball.add(temp1);
                            }else{
                                temp=new Fireball(ball.getPoint(), LEFT_UP.mul(FSPEED));
                                temp1=new Fireball(ball.getPoint(), Right_UP.mul(FSPEED));
                                addball.add(temp);
                                addball.add(temp1);
                            }
                        }
                        if (ball instanceof Fireball){
                            board.destroy(current.rect.centre());
                        }
                        break;
                    }
                    else if (current.rect.intersectedAt(ball.getPoint(), ball.getVelocity()) == Side.LEFT) {
                        remove.add(current);
                        ball.reverseSide();
                        if (current instanceof GreenPeg) {
                            if (ball instanceof NormalBall){
                                temp=new NormalBall(ball.getPoint(), LEFT_UP);
                                temp1=new NormalBall(ball.getPoint(), Right_UP);
                                addball.add(temp);
                                addball.add(temp1);
                            }else{
                                temp=new Fireball(ball.getPoint(), LEFT_UP.mul(FSPEED));
                                temp1=new Fireball(ball.getPoint(), Right_UP.mul(FSPEED));
                                addball.add(temp);
                                addball.add(temp1);
                            }
                        }
                        if (ball instanceof Fireball){
                            board.destroy(current.rect.centre());
                        }
                        break;
                    }
                    else if (current.rect.intersectedAt(ball.getPoint(), ball.getVelocity()) == Side.RIGHT) {
                        remove.add(current);
                        ball.reverseSide();
                        if (current instanceof GreenPeg) {
                            if (ball instanceof NormalBall){
                                temp=new NormalBall(ball.getPoint(), LEFT_UP);
                                temp1=new NormalBall(ball.getPoint(), Right_UP);
                                addball.add(temp);
                                addball.add(temp1);
                            }else{
                                temp=new Fireball(ball.getPoint(), LEFT_UP.mul(FSPEED));
                                temp1=new Fireball(ball.getPoint(), Right_UP.mul(FSPEED));
                                addball.add(temp);
                                addball.add(temp1);
                            }
                        }
                        if (ball instanceof Fireball){
                            board.destroy(current.rect.centre());
                        }
                        break;
                    }
                }

                //remove pegs that have intersected with ball
                board.remove(remove);
                ball.update();

                //check for balls that are out of screen, and check if there any any shots left
                if (ball.outOfScreen()) {
                    removeball.add(ball);
                    if (shots==0 && !intersected){
                        System.out.println("YOU LOST");
                        System.exit(0);
                    }
                }
            }

            //remove balls that are out of screen
            balls.removeAll(removeball);
            balls.addAll(addball);
            addball.clear();
        }else{
            created=false;
            //if ball intersected with bucket, player gets 1 additional shot
            if (intersected){
                shots++;
                System.out.print("SHOTS LEFT:" + shots + "\n");
                intersected=false;
            }
            //check if powerup is to be created for next turn (1/10 chance)
            if (turn){
                turn=false;
                Random random =new Random();
                int num =random.nextInt(11);
                if(num==1){
                    created=true;
                }else{
                    powerup=null;
                }
                //turn one random blue peg green if possible
                if (board.lengthGreen() == 0) {
                    if (board.lengthBlue() != 0) {
                        board.turnGreen();
                    }
                } else {
                    if (board.lengthBlue() != 0) {
                        board.turnBlue();
                        board.turnGreen();
                    }
                }
            }
        }

        board.update();
        // If we don't have a ball and the mouse button was clicked, create one
        if (input.wasPressed(MouseButtons.LEFT) && balls.isEmpty()) {
            shots--;
            System.out.print("SHOTS LEFT:" + shots + "\n");
            balls.add(new NormalBall(BALL_POSITION, input.directionToMouse(BALL_POSITION)));
            turn=true;
        }

        //if powerup is to be created (1/10 chance), generate random start and end for powerup
        if (powerup==null && !turn){
            Random rand = new Random();
            if ( created) {
                Point p = new Point(Window.getWidth() * rand.nextDouble(), Window.getHeight() * rand.nextDouble());
                Point end = new Point(Window.getWidth() * rand.nextDouble(), Window.getHeight() * rand.nextDouble());
                powerup = new Powerup(p, end);
            }
        }

        if(powerup!=null ){
            powerup.update();
        }
        if (bucket==null){
            bucket=new Bucket(BUCKET_START);
        }
        bucket.update();
    }

    public static void main(String[] args) throws IOException {
        new ShadowBounce().run();
    }
}
