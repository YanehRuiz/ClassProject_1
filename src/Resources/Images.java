package Resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by AlexVR on 1/24/2020.
 */
public class Images {


    public static BufferedImage titleScreenBackground;
    public static BufferedImage pauseBackground;
    public static BufferedImage selectionBackground;
    public static BufferedImage galagaCopyright;
    public static BufferedImage galagaSelect;
    public static BufferedImage muteIcon;
    public static BufferedImage galagaPlayerLaser;
    public static BufferedImage[] startGameButton;
    public static BufferedImage[] galagaLogo;
    public static BufferedImage[] pauseResumeButton;
    public static BufferedImage[] pauseToTitleButton;
    public static BufferedImage[] pauseOptionsButton;
    public static BufferedImage[] galagaPlayer;
    public static BufferedImage[] galagaPlayerDeath;
    public static BufferedImage[] galagaEnemyDeath;
    public static BufferedImage[] galagaEnemyBee;

    public static BufferedImage map1;
    public static BufferedImage ghost;
    public static BufferedImage[] pacmanDots;
    public static BufferedImage[] pacmanRight;
    public static BufferedImage[] pacmanLeft;
    public static BufferedImage[] pacmanUp;
    public static BufferedImage[] pacmanDown;
    public static BufferedImage[] bound;
    public static BufferedImage intro;
    public static BufferedImage start; 
    public static BufferedImage PacbyLogo;
    public static BufferedImage[] pacmanfruits;
    public static BufferedImage [] pacmanDeath;
    public static BufferedImage [] rGhostLeft;
    public static BufferedImage [] rGhostRight;
    public static BufferedImage [] rGhostUp;
    public static BufferedImage [] rGhostDown;
    public static BufferedImage [] pGhostLeft;
    public static BufferedImage [] pGhostRight;
    public static BufferedImage [] pGhostUp;
    public static BufferedImage [] pGhostDown;
    public static BufferedImage [] bGhostLeft;
    public static BufferedImage [] bGhostRight;
    public static BufferedImage [] bGhostUp;
    public static BufferedImage [] bGhostDown;
    public static BufferedImage [] oGhostLeft;
    public static BufferedImage [] oGhostRight;
    public static BufferedImage [] oGhostUp;
    public static BufferedImage [] oGhostDown;
    
    public static BufferedImage [] vulnerableGhost;
 


    public static BufferedImage galagaImageSheet;
    public SpriteSheet galagaSpriteSheet;

    public static BufferedImage pacmanImageSheet;
	
    public SpriteSheet pacmanSpriteSheet;

    public Images() {

        startGameButton = new BufferedImage[3];
        pauseResumeButton = new BufferedImage[2];
        pauseToTitleButton = new BufferedImage[2];
        pauseOptionsButton = new BufferedImage[2];
        galagaLogo = new BufferedImage[3];
        galagaPlayer = new BufferedImage[8];//not full yet, only has second to last image on sprite sheet
        galagaPlayerDeath = new BufferedImage[8];
        galagaEnemyDeath = new BufferedImage[5];
        galagaEnemyBee = new BufferedImage[8];

        pacmanDots = new BufferedImage[4];
        pacmanfruits = new BufferedImage[3];
     //   pacmanDotsOFF = new BufferedImage[1];
        pacmanRight = new BufferedImage[2];
        pacmanLeft = new BufferedImage[2];
        pacmanUp = new BufferedImage[2];
        pacmanDown = new BufferedImage[2];
        bound = new BufferedImage[16];
        pacmanDeath = new BufferedImage[3];
        
        rGhostLeft = new BufferedImage[2];
        pGhostLeft = new BufferedImage[2];
        bGhostLeft = new BufferedImage[2];
        oGhostLeft = new BufferedImage[2];
        
        rGhostRight = new BufferedImage[2];
        pGhostRight = new BufferedImage[2];
        bGhostRight = new BufferedImage[2];
        oGhostRight = new BufferedImage[2];
        
        rGhostUp = new BufferedImage[2];
        pGhostUp = new BufferedImage[2];
        bGhostUp = new BufferedImage[2];
        oGhostUp = new BufferedImage[2];
        
        rGhostDown = new BufferedImage[2];
        pGhostDown = new BufferedImage[2];
        bGhostDown = new BufferedImage[2];
        oGhostDown = new BufferedImage[2];
        
        vulnerableGhost = new BufferedImage[4];
        
       


        try {

            startGameButton[0]= ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Start/NormalStartButton.png"));
            startGameButton[1]= ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Start/HoverStartButton.png"));
            startGameButton[2]= ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Start/ClickedStartButton.png"));

            titleScreenBackground = ImageIO.read(getClass().getResourceAsStream("/UI/Backgrounds/Title.png"));

            pauseBackground = ImageIO.read(getClass().getResourceAsStream("/UI/Backgrounds/Pause.png"));

            selectionBackground = ImageIO.read(getClass().getResourceAsStream("/UI/Backgrounds/Selection.png"));

            galagaCopyright = ImageIO.read(getClass().getResourceAsStream("/UI/Misc/Copyright.png"));

            galagaSelect = ImageIO.read(getClass().getResourceAsStream("/UI/Misc/galaga_select.png"));

            muteIcon = ImageIO.read(getClass().getResourceAsStream("/UI/Misc/mute.png"));

            galagaLogo[0] = ImageIO.read(getClass().getResourceAsStream("/UI/Misc/galaga_logo.png"));
            galagaLogo[1] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Selection/Galaga/hover_galaga_logo.png"));
            galagaLogo[2] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Selection/Galaga/pressed_galaga_logo.png"));

            pauseResumeButton[0] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Pause/Resume/NormalHoverResume.png"));
            pauseResumeButton[1] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Pause/Resume/PressedResume.png"));

            pauseToTitleButton[0] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Pause/ToTitle/NormalHoverToTitleButton.png"));
            pauseToTitleButton[1] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Pause/ToTitle/PressedToTitleButton.png"));

            pauseOptionsButton[0] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Pause/ToOptions/NormalHoverToOptionsButton.png"));
            pauseOptionsButton[1] = ImageIO.read(getClass().getResourceAsStream("/UI/Buttons/Pause/ToOptions/PressedToOptionsButton.png"));

            galagaImageSheet = ImageIO.read(getClass().getResourceAsStream("/UI/SpriteSheets/Galaga/Galaga.png"));
            galagaSpriteSheet = new SpriteSheet(galagaImageSheet);

            galagaPlayer[0] = galagaSpriteSheet.crop(160,55,15,16);

            galagaPlayerDeath[0] = galagaSpriteSheet.crop(209,48,32,32);
            galagaPlayerDeath[1] = galagaSpriteSheet.crop(209,48,32,32);
            galagaPlayerDeath[2] = galagaSpriteSheet.crop(247,48,32,32);
            galagaPlayerDeath[3] = galagaSpriteSheet.crop(247,48,32,32);
            galagaPlayerDeath[4] = galagaSpriteSheet.crop(288,47,32,32);
            galagaPlayerDeath[5] = galagaSpriteSheet.crop(288,47,32,32);
            galagaPlayerDeath[6] = galagaSpriteSheet.crop(327,47,32,32);
            galagaPlayerDeath[7] = galagaSpriteSheet.crop(327,47,32,32);

            galagaEnemyDeath[0] = galagaSpriteSheet.crop(201,191,32,32);
            galagaEnemyDeath[1] = galagaSpriteSheet.crop(223,191,32,32);
            galagaEnemyDeath[2] = galagaSpriteSheet.crop(247,191,32,32);
            galagaEnemyDeath[3] = galagaSpriteSheet.crop(280,191,32,32);
            galagaEnemyDeath[4] = galagaSpriteSheet.crop(320,191,32,32);

            galagaEnemyBee[0] = galagaSpriteSheet.crop(188,178,9,10);
            galagaEnemyBee[1] = galagaSpriteSheet.crop(162,178,13,10);
            galagaEnemyBee[2] = galagaSpriteSheet.crop(139,177,11,12);
            galagaEnemyBee[3] = galagaSpriteSheet.crop(113,176,14,13);
            galagaEnemyBee[4] = galagaSpriteSheet.crop(90,177,13,13);
            galagaEnemyBee[5] = galagaSpriteSheet.crop(65,176,13,14);
            galagaEnemyBee[6] = galagaSpriteSheet.crop(42,178,12,11);
            galagaEnemyBee[7] = galagaSpriteSheet.crop(19,177,10,13);


            galagaPlayerLaser = galagaSpriteSheet.crop(365 ,219,3,8);

            pacmanImageSheet = ImageIO.read(getClass().getResourceAsStream("/UI/SpriteSheets/PacMan/Background.png"));
            PacbyLogo=ImageIO.read(getClass().getResourceAsStream("/UI/SpriteSheets/PacMan/PacbyLogo.jpg"));
            pacmanSpriteSheet = new SpriteSheet(pacmanImageSheet);
            map1 = ImageIO.read(getClass().getResourceAsStream("/UI/Backgrounds/PacManMaps/map1.png"));
            ghost = pacmanSpriteSheet.crop(456,64,16,16);
            pacmanDots[0] = pacmanSpriteSheet.crop(643,18,16,16);
            pacmanDots[1] = pacmanSpriteSheet.crop(623,18,16,16);
            pacmanDots[2]= pacmanSpriteSheet.crop(660, 18, 16, 16);
            
            pacmanfruits[2] = pacmanSpriteSheet.crop(520,50,16,16);
            pacmanfruits[1] = pacmanSpriteSheet.crop(490,50,16,16);

//            pacmanDeath[0]=pacmanSpriteSheet.crop(32,1,16,16);//whole
//            pacmanDeath[1]=pacmanSpriteSheet.crop(16,33,16,16);
//            pacmanDeath[2]=pacmanSpriteSheet.crop(0,33,16,16);
        
            pacmanDeath[0]=pacmanSpriteSheet.crop(470,0,16,16);//whole
            pacmanDeath[1]=pacmanSpriteSheet.crop(535,0,16,16);
            pacmanDeath[2]=pacmanSpriteSheet.crop(664,0,16,16);
            
            bound[0] = pacmanSpriteSheet.crop(603,18,16,16);//single
            bound[1] = pacmanSpriteSheet.crop(615,37,16,16);//right open
            bound[2] = pacmanSpriteSheet.crop(635,37,16,16);//down open
            bound[3] = pacmanSpriteSheet.crop(655,37,16,16);//left open
            bound[4] = pacmanSpriteSheet.crop(655,57,16,16);//up open
            bound[5] = pacmanSpriteSheet.crop(655,75,16,16);//up/down
            bound[6] = pacmanSpriteSheet.crop(656,116,16,16);//left/Right
            bound[7] = pacmanSpriteSheet.crop(656,136,16,16);//up/Right
            bound[8] = pacmanSpriteSheet.crop(655,174,16,16);//up/left
            bound[9] = pacmanSpriteSheet.crop(655,155,16,16);//down/Right
            bound[10] = pacmanSpriteSheet.crop(655,192,16,16);//down/left
            bound[11] = pacmanSpriteSheet.crop(664,232,16,16);//all
            bound[12] = pacmanSpriteSheet.crop(479,191,16,16);//left
            bound[13] = pacmanSpriteSheet.crop(494,191,16,16);//right
            bound[14] = pacmanSpriteSheet.crop(479,208,16,16);//top
            bound[15] = pacmanSpriteSheet.crop(479,223,16,16);//bottom

            pacmanRight[0] = pacmanSpriteSheet.crop(473,1,12,13);
            pacmanRight[1] = pacmanSpriteSheet.crop(489,1,13,13);

            pacmanLeft[0] = pacmanSpriteSheet.crop(474,17,12,13);
            pacmanLeft[1] = pacmanSpriteSheet.crop(489,1,13,13);

            pacmanUp[0] = pacmanSpriteSheet.crop(473,34,13,12);
            pacmanUp[1] = pacmanSpriteSheet.crop(489,1,13,13);

            pacmanDown[0] = pacmanSpriteSheet.crop(473,48,13,12);
            pacmanDown[1] = pacmanSpriteSheet.crop(489,1,13,13);

            
            rGhostLeft[0] = pacmanSpriteSheet.crop(488,64,16,16);
            rGhostLeft[1] = pacmanSpriteSheet.crop(504,64,16,16);
            pGhostLeft[0] = pacmanSpriteSheet.crop(488,80,16,16);
            pGhostLeft[1] = pacmanSpriteSheet.crop(504,80,16,16);
            bGhostLeft[0] = pacmanSpriteSheet.crop(488,96,16,16);
            bGhostLeft[1] = pacmanSpriteSheet.crop(504,96,16,16);
            oGhostLeft[0] = pacmanSpriteSheet.crop(488,112,16,16);
            oGhostLeft[1] = pacmanSpriteSheet.crop(504,112,16,16);
            
            rGhostRight[0] = pacmanSpriteSheet.crop(456,64,16,16);
            rGhostRight[1] = pacmanSpriteSheet.crop(472,64,16,16);
            pGhostRight[0] = pacmanSpriteSheet.crop(456,80,16,16);
            pGhostRight[1] = pacmanSpriteSheet.crop(472,80,16,16);
            bGhostRight[0] = pacmanSpriteSheet.crop(456,96,16,16);
            bGhostRight[1] = pacmanSpriteSheet.crop(472,96,16,16);
            oGhostRight[0] = pacmanSpriteSheet.crop(456,112,16,16);
            oGhostRight[1] = pacmanSpriteSheet.crop(472,112,16,16);
            
            rGhostUp[0] = pacmanSpriteSheet.crop(520,64,16,16);
            rGhostUp[1] = pacmanSpriteSheet.crop(536,64,16,16);
            pGhostUp[0] = pacmanSpriteSheet.crop(520,80,16,16);
            pGhostUp[1] = pacmanSpriteSheet.crop(536,80,16,16);
            bGhostUp[0] = pacmanSpriteSheet.crop(520,96,16,16);
            bGhostUp[1] = pacmanSpriteSheet.crop(536,96,16,16);
            oGhostUp[0] = pacmanSpriteSheet.crop(520,112,16,16);
            oGhostUp[1] = pacmanSpriteSheet.crop(536,112,16,16);
            
            rGhostDown[0] = pacmanSpriteSheet.crop(552,64,16,16);
            rGhostDown[1] = pacmanSpriteSheet.crop(568,64,16,16);
            pGhostDown[0] = pacmanSpriteSheet.crop(552,80,16,16);
            pGhostDown[1] = pacmanSpriteSheet.crop(568,80,16,16);
            bGhostDown[0] = pacmanSpriteSheet.crop(552,96,16,16);
            bGhostDown[1] = pacmanSpriteSheet.crop(568,96,16,16);
            oGhostDown[0] = pacmanSpriteSheet.crop(552,112,16,16);
            oGhostDown[1] = pacmanSpriteSheet.crop(568,112,16,16);
            
            vulnerableGhost[0] = pacmanSpriteSheet.crop(584,64,16,16);
            vulnerableGhost[1] = pacmanSpriteSheet.crop(600,64,16,16);
            vulnerableGhost[2] = pacmanSpriteSheet.crop(616,64,16,16);
            vulnerableGhost[3] = pacmanSpriteSheet.crop(632,64,16,16);
            
            intro = ImageIO.read(getClass().getResourceAsStream("/UI/SpriteSheets/PacMan/intro.png"));
            start = ImageIO.read(getClass().getResourceAsStream("/UI/Backgrounds/startScreen.png"));



        }catch (IOException e) {
        e.printStackTrace();
    }


    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(Images.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
