//package Game.PacMan.entities.Dynamics;
//
//import java.awt.image.BufferedImage;
//
//import Main.Handler;
//import Resources.Animation;
//import Resources.Images;
//
//
//public class GhostSpawner extends Ghost {
//
//	public Animation RleftAnim,RrightAnim,RupAnim,RdownAnim,
//	BleftAnim,BrightAnim,BupAnim,BdownAnim,
//	OleftAnim,OrightAnim,OupAnim,OdownAnim,
//	PleftAnim,PrightAnim,PupAnim,PdownAnim;
//
//	public Ghost Red;
//	public Ghost Blue;
//	public Ghost Pink;
//	public Ghost Orange;
//
//
//	public GhostSpawner(int x, int y, int width, int height, Handler handler) {
//		super(x, y, width, height, handler,Images.ghost); 
//
//		Ghost Red = new Ghost(x, y, width, height, handler, sprite);
//		//red ghost
//		RleftAnim = new Animation(128,Images.rGhostLeft);
//		RrightAnim = new Animation(128,Images.rGhostRight);
//		RupAnim = new Animation(128,Images.rGhostUp);
//		RdownAnim = new Animation(128,Images.rGhostDown);
//		
//		
//		Ghost Blue = new Ghost(x, y, width, height, handler, sprite);
//		//blue ghost
//		BleftAnim = new Animation(128,Images.bGhostLeft);
//		BrightAnim = new Animation(128,Images.bGhostRight);
//		BupAnim = new Animation(128,Images.bGhostUp);
//		BdownAnim = new Animation(128,Images.bGhostDown);
//		
//		
//		Ghost Orange = new Ghost(x, y, width, height, handler, sprite);
//			//orange ghost
//		OleftAnim = new Animation(128,Images.oGhostLeft);
//		OrightAnim = new Animation(128,Images.oGhostRight);
//		OupAnim = new Animation(128,Images.oGhostUp);
//		OdownAnim = new Animation(128,Images.oGhostDown);
//		
//		
//		Ghost Pink = new Ghost(x, y, width, height, handler, sprite);
//
//		//pink ghost
//		PleftAnim = new Animation(128,Images.pGhostLeft);
//		PrightAnim = new Animation(128,Images.pGhostRight);
//		PupAnim = new Animation(128,Images.pGhostUp);
//		PdownAnim = new Animation(128,Images.pGhostDown);
//
//	}
//	//BaseDynamic ghostSpawn = new Ghost(x,y,width,height,handler);
//
//
//
//
//}
