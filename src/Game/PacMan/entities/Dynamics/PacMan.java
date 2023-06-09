package Game.PacMan.entities.Dynamics;

import Game.Galaga.Entities.EnemyBee;
import Game.PacMan.entities.Statics.BaseStatic;
import Game.PacMan.entities.Statics.BoundBlock;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PacMan extends BaseDynamic{
	
	public int health = 3;
	public boolean pacmanDead = false;

    protected double velX,velY,speed = 1;
    public String facing = "Left";
    public boolean moving = true,turnFlag = false;
    public Animation leftAnim,rightAnim,upAnim,downAnim,deathAnimation;
    int turnCooldown = 20;
    int spawnCoolDown = 5*60;
    public int spawnx = 350;
    public int spawny = 400;


    public PacMan(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler, Images.pacmanRight[0]);
        leftAnim = new Animation(128,Images.pacmanLeft);
        rightAnim = new Animation(128,Images.pacmanRight);
        upAnim = new Animation(128,Images.pacmanUp);
        downAnim = new Animation(128,Images.pacmanDown);
        deathAnimation = new Animation(350,Images.pacmanDeath);
    }

    @Override
    public void tick(){
    	
    	
        switch (facing){
            case "Right":
                x+=velX;
                rightAnim.tick();
                break;
            case "Left":
                x-=velX;
                leftAnim.tick();
                break;
            case "Up":
                y-=velY;
                upAnim.tick();
                break;
            case "Down":
                y+=velY;
                downAnim.tick();
                break;
        }
        if (turnCooldown<=0){
            turnFlag= false;
        }
        if (turnFlag){
            turnCooldown--;
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_P) && health > 0) { //Kill Player	
        	pacmanDead = true;
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_N) && health < 3) { // +1 health
        	health ++;
       	handler.getMusicHandler().playEffect("life.wav");
        }

        if ((handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT)  || handler.getKeyManager().keyJustPressed(KeyEvent.VK_D)) && !turnFlag && checkPreHorizontalCollision("Right")){
            facing = "Right";
            turnFlag = true;
            turnCooldown = 20;
        }else if ((handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT) || handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)) && !turnFlag&& checkPreHorizontalCollision("left")){
            facing = "Left";
            turnFlag = true;
            turnCooldown = 20;
        }else if ((handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP)  ||handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) && !turnFlag&& checkPreVerticalCollisions("Up")){
            facing = "Up";
            turnFlag = true;
            turnCooldown = 20;
        }else if ((handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN)  || handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) && !turnFlag&& checkPreVerticalCollisions("Down")){
            facing = "Down";
            turnFlag = true;
            turnCooldown = 20;
        }

        if (facing.equals("Right") || facing.equals("Left")){
            checkHorizontalCollision();
        }else{
            checkVerticalCollisions();
        }
        if (handler.getPacManState().startCooldown <=0) {
        	speed = 1;
        }else {
        	speed=0;
        }
        if (pacmanDead) {
        	deathAnimation.tick();
        	if (spawnCoolDown <= 0) {
        		x = spawnx;
        		y = spawny;
        		deathAnimation.reset();
        		spawnCoolDown = 5*60;
        		speed = 1;
        		health--;
                handler.getMusicHandler().playEffect("death.wav");
        		if (health < 1) {
        			health = 0;
        		}
        		facing = "Right";
        		pacmanDead = false;
        	}else {
        		speed = 0;
        		spawnCoolDown--;
        	}
        }

    }

    public void checkVerticalCollisions() {
        PacMan pacman = this;
        ArrayList<BaseStatic> bricks = handler.getMap().getBlocksOnMap();
        ArrayList<BaseDynamic> enemies = handler.getMap().getEnemiesOnMap();

        boolean pacmanDies = false;
        boolean toUp = moving && facing.equals("Up");

        Rectangle pacmanBounds = toUp ? pacman.getTopBounds() : pacman.getBottomBounds();

        velY = speed;
        for (BaseStatic brick : bricks) {
            if (brick instanceof BoundBlock) {
                Rectangle brickBounds = !toUp ? brick.getTopBounds() : brick.getBottomBounds();
                if (pacmanBounds.intersects(brickBounds)) {
                    velY = 0;
                    if (toUp)
                        pacman.setY(brick.getY() + pacman.getDimension().height);
                    else
                        pacman.setY(brick.getY() - brick.getDimension().height);
                }
            }
        }

        for(BaseDynamic enemy : enemies){
            Rectangle enemyBounds = !toUp ? enemy.getTopBounds() : enemy.getBottomBounds();
            if (pacmanBounds.intersects(enemyBounds)) {
                pacmanDies = true;
                break;
            }
        }

        if(pacmanDies) {
        	pacmanDead=true;
        	
            handler.getMap().reset();

            
        }
    }


    public boolean checkPreVerticalCollisions(String facing) {
        PacMan pacman = this;
        ArrayList<BaseStatic> bricks = handler.getMap().getBlocksOnMap();

        boolean pacmanDies = false;
        boolean toUp = moving && facing.equals("Up");

        Rectangle pacmanBounds = toUp ? pacman.getTopBounds() : pacman.getBottomBounds();

        velY = speed;
        for (BaseStatic brick : bricks) {
            if (brick instanceof BoundBlock) {
                Rectangle brickBounds = !toUp ? brick.getTopBounds() : brick.getBottomBounds();
                if (pacmanBounds.intersects(brickBounds)) {
                    return false;
                }
            }
        }
        return true;

    }



    public void checkHorizontalCollision(){
        PacMan pacman = this;
        ArrayList<BaseStatic> bricks = handler.getMap().getBlocksOnMap();
        ArrayList<BaseDynamic> enemies = handler.getMap().getEnemiesOnMap();
        velX = speed;
        boolean pacmanDies = false;
        boolean toRight = moving && facing.equals("Right");

        Rectangle pacmanBounds = toRight ? pacman.getRightBounds() : pacman.getLeftBounds();

        for(BaseDynamic enemy : enemies){
            Rectangle enemyBounds = !toRight ? enemy.getRightBounds() : enemy.getLeftBounds();
            if (pacmanBounds.intersects(enemyBounds)) {
               
            	pacmanDies = true;
                break;
               }
            }
    
      

        if(pacmanDies) {
        	 pacmanDead=true;
        	
            handler.getMap().reset();
        }else {

            for (BaseStatic brick : bricks) {
                if (brick instanceof BoundBlock) {
                    Rectangle brickBounds = !toRight ? brick.getRightBounds() : brick.getLeftBounds();
                    if (pacmanBounds.intersects(brickBounds)) {
                        velX = 0;
                        if (toRight)
                            pacman.setX(brick.getX() - pacman.getDimension().width);
                        else
                            pacman.setX(brick.getX() + brick.getDimension().width);
                    }
                }
            }
        }
    }


    public boolean checkPreHorizontalCollision(String facing){
        PacMan pacman = this;
        ArrayList<BaseStatic> bricks = handler.getMap().getBlocksOnMap();
        velX = speed;
        boolean toRight = moving && facing.equals("Right");

        Rectangle pacmanBounds = toRight ? pacman.getRightBounds() : pacman.getLeftBounds();

            for (BaseStatic brick : bricks) {
                if (brick instanceof BoundBlock) {
                    Rectangle brickBounds = !toRight ? brick.getRightBounds() : brick.getLeftBounds();
                    if (pacmanBounds.intersects(brickBounds)) {
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
    public int getHealth() {
    	if (health < 1) {
    		handler.getPacManState().restart = true;
    	}
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


}
