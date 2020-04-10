package Game.PacMan.entities.Statics;

import java.awt.image.BufferedImage;

import Main.Handler;
import Resources.Animation;
import Resources.Images;


public class BigDot extends BaseStatic{
	
	public Animation onAnim;

	
    public BigDot(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler, Images.pacmanDots[0]);
       onAnim=new Animation(128,Images.pacmanDots);
 
    }
  


	@Override
    public void tick(){
                onAnim.tick();
              
}
}
