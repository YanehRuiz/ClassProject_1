package Game.PacMan.entities.Dynamics;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import Game.PacMan.entities.Statics.BaseStatic;
import Game.PacMan.entities.Statics.BoundBlock;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

public class Ghost extends BaseDynamic{

    protected double velX,velY,speed = 1;
    public String facing = "Up";
    public boolean moving = true,turnFlag = false,vulnerable = false;
    public Animation leftAnim,rightAnim,upAnim,downAnim,vulnerableAnim;
    int turnCooldown = 30;
    public int vulnerableCoolDown = 8*60;
    public boolean hasgoneout=false;
    public boolean hasleftcage = false;
    private int spawnx = 350, spawny = 350;


    public Ghost(int x, int y, int width, int height, Handler handler, BufferedImage ghost) {
        super(x, y, width, height, handler, Images.ghost);
        leftAnim = new Animation(128,Images.pacmanLeft);
        rightAnim = new Animation(128,Images.pacmanRight);
        upAnim = new Animation(128,Images.pacmanUp);
        downAnim = new Animation(128,Images.pacmanDown);
        vulnerableAnim = new Animation(128,Images.vulnerableGhost);
    }

    @Override
    public void tick(){

        switch (facing){
            case "Up":
                y-=velY;
                upAnim.tick();
                break;
                
            case "Right":
                x+=velX;
                rightAnim.tick();
                break;
            case "Left":
                x-=velX;
                leftAnim.tick();
                break;
              
            case "Down":
                y+=velY;
                downAnim.tick();
                break;
        }
        if (turnCooldown<=0){
            turnFlag= false;
            turnCooldown = 30;
        }
        if (turnFlag){
            turnCooldown--;
        }

        if(!hasgoneout&&!turnFlag&& (checkPreVerticalCollisions("Up"))) {
        	facing="Up";
        	turnFlag=true;
        	hasgoneout=true;	
        }
        
        if(hasgoneout&&!hasleftcage&&!turnFlag&& (checkPreVerticalCollisions("Right"))) {
        	facing="Up";
        	turnFlag=true;
        	hasgoneout=true;	
        	hasleftcage=true;
        }

        if (!turnFlag && checkPreHorizontalCollision("Right")&&hasgoneout&&hasleftcage){
        	Random rand = new Random();
        	String[] Directions  = {"Up", "Left", "Down"};
        	facing = Directions[rand.nextInt(Directions.length)];
            turnFlag = true;    
        }else if ((!turnFlag&& checkPreHorizontalCollision("left")&&hasgoneout&&hasleftcage)){
        	Random rand = new Random();
        	String[] Directions  = {"Up", "Down", "Right"};
        	facing = Directions[rand.nextInt(Directions.length)];
            turnFlag = true;   
        }else if ((!turnFlag&& checkPreVerticalCollisions("Up")&&hasgoneout&&hasleftcage)){
        	Random rand = new Random();
        	String[] Directions  = {"Left", "Right", "Down"};
        	facing = Directions[rand.nextInt(Directions.length)];
            turnFlag = true;
        }else if ((!turnFlag&& checkPreVerticalCollisions("Down")&&hasgoneout&&hasleftcage)){
        	Random rand = new Random();
        	String[] Directions  = {"Left", "Right","Up"};
        	facing = Directions[rand.nextInt(Directions.length)];
            turnFlag = true;
        }

        if (facing.equals("Right") || facing.equals("Left")){
            checkHorizontalCollision();
        }else{
            checkVerticalCollisions();
        }
        if (vulnerable) {
        	vulnerableAnim.tick();
        	if (vulnerableCoolDown <= 0) {
        		x = spawnx;
        		y = spawny;
        		vulnerableAnim.reset();
        		vulnerableCoolDown = 8*60;
        		handler.getMusicHandler().playEffect("life.wav");
        		speed = 1;
        		facing = "Right";
        		vulnerable = false;
        	}else {
        		speed = 0;
        		vulnerableCoolDown--;
        	}
        }
    }


    public void checkVerticalCollisions() {
        Ghost ghost = this;
        ArrayList<BaseStatic> bricks = handler.getMap().getBlocksOnMap();
        ArrayList<BaseDynamic> enemies = handler.getMap().getEnemiesOnMap();

        boolean ghostDies = false;
        boolean toUp = moving && facing.equals("Up");

        Rectangle ghostBounds = toUp ? ghost.getTopBounds() : ghost.getBottomBounds();

        velY = speed;
        for (BaseStatic brick : bricks) {
            if (brick instanceof BoundBlock) {
                Rectangle brickBounds = !toUp ? brick.getTopBounds() : brick.getBottomBounds();
                if (ghostBounds.intersects(brickBounds)) {
                    velY = 0;
                             
                    if (toUp)
                        ghost.setY(brick.getY() + ghost.getDimension().height);
                    else
                        ghost.setY(brick.getY() - brick.getDimension().height);
                }
            }
        }

        for(BaseDynamic enemy : enemies){
            Rectangle enemyBounds = !toUp ? enemy.getTopBounds() : enemy.getBottomBounds();
            if (ghostBounds.intersects(enemyBounds)) {
                ghostDies = true;
                break;
            }
        }

        if(ghostDies) {
            handler.getMap().reset();
        }
    }


    public boolean checkPreVerticalCollisions(String facing) {
        Ghost ghost = this;
        ArrayList<BaseStatic> bricks = handler.getMap().getBlocksOnMap();

        boolean ghostDies = false;
        boolean toUp = moving && facing.equals("Up");

        Rectangle ghostBounds = toUp ? ghost.getTopBounds() : ghost.getBottomBounds();

        velY = speed;
        for (BaseStatic brick : bricks) {
            if (brick instanceof BoundBlock) {
                Rectangle brickBounds = !toUp ? brick.getTopBounds() : brick.getBottomBounds();
                if (ghostBounds.intersects(brickBounds)) {

                    return false;
                }
            }
        }
        return true;

    }



    public void checkHorizontalCollision(){
        Ghost ghost = this;
        ArrayList<BaseStatic> bricks = handler.getMap().getBlocksOnMap();
        ArrayList<BaseDynamic> enemies = handler.getMap().getEnemiesOnMap();
        velX = speed;
        boolean ghostDies = false;
        boolean toRight = moving && facing.equals("Right");

        Rectangle ghostBounds = toRight ? ghost.getRightBounds() : ghost.getLeftBounds();

        for(BaseDynamic enemy : enemies){
            Rectangle enemyBounds = !toRight ? enemy.getRightBounds() : enemy.getLeftBounds();
            if (ghostBounds.intersects(enemyBounds)) {                              
                ghostDies = true;
                break;
            }
        }

        if(ghostDies) {
            handler.getMap().reset();
        }else {

            for (BaseStatic brick : bricks) {
                if (brick instanceof BoundBlock) {
                    Rectangle brickBounds = !toRight ? brick.getRightBounds() : brick.getLeftBounds();
                    if (ghostBounds.intersects(brickBounds)) {
                        velX = 0;
                        if (toRight)
                            ghost.setX(brick.getX() - ghost.getDimension().width);
                        else
                            ghost.setX(brick.getX() + brick.getDimension().width);
                    }
                }
            }
        }
    }


    public boolean checkPreHorizontalCollision(String facing){
        Ghost ghost = this;
        ArrayList<BaseStatic> bricks = handler.getMap().getBlocksOnMap();
        velX = speed;
        boolean toRight = moving && facing.equals("Right");

        Rectangle ghostBounds = toRight ? ghost.getRightBounds() : ghost.getLeftBounds();

        for (BaseStatic brick : bricks) {
            if (brick instanceof BoundBlock) {
                Rectangle brickBounds = !toRight ? brick.getRightBounds() : brick.getLeftBounds();
                if (ghostBounds.intersects(brickBounds)) {
                    return false;
                }
            }
        }
        return true;
    }


    public double getVelX() {
        return velX;
    }
    public double getVelY() {
        return velY;
    }

}
