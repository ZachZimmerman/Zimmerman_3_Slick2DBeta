package magikgoldgame;

import java.util.ArrayList;

import org.newdawn.slick.Color;

import org.newdawn.slick.AppGameContainer;

import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;

import org.newdawn.slick.Input;

import org.newdawn.slick.SlickException;

import org.newdawn.slick.state.BasicGameState;

import org.newdawn.slick.state.StateBasedGame;

import org.newdawn.slick.state.transition.FadeInTransition;

import org.newdawn.slick.state.transition.FadeOutTransition;

import org.newdawn.slick.tiled.TiledMap;

public class Magikgoldgame extends BasicGameState {
    
    public Orb orb1;
    public Item healthpotion, healthpotion1;
    public Item1 speedpotion, speedpotion1;
    public Itemwin antidote;
    public Goldcoin goldcoin;
   // public Ninja morse, gia, weber;
   // public Xbox xboxz;
    public Player player;
    public Enemy zach;
    public Enemy joe;
    public Enemy rhys;
    public Enemy adam;
    public Enemy jordan;
    public Enemy kris;
    
    public Goldcoin point;
    
    public ArrayList<Goldcoin> coinz = new ArrayList();
    
    public ArrayList<Enemy> enemyz = new ArrayList();
    
   // public ArrayList<Ninja> ninjaz = new ArrayList();
    
    //public ArrayList<Xbox> Xboxz = new ArrayList();
    
    public ArrayList<Item> stuff = new ArrayList();

    public ArrayList<Item1> stuff1 = new ArrayList();

    public ArrayList<Itemwin> stuffwin = new ArrayList();

    private boolean[][] hostiles;

    private static TiledMap grassMap;

    private static AppGameContainer app;

    private static Camera camera;

    public static int counter = 0;
    
 
    private static final int SIZE = 64;

    private static final int SCREEN_WIDTH = 1000;

    private static final int SCREEN_HEIGHT = 750;

    public Magikgoldgame(int xSize, int ySize) {

    }
    

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {

        gc.setTargetFrameRate(60);

        gc.setShowFPS(false);

        grassMap = new TiledMap("res/d4.tmx");

        camera = new Camera(gc, grassMap);
        player = new Player();

        Blocked.blocked = new boolean[grassMap.getWidth()][grassMap.getHeight()];


        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {

            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {

                int tileID = grassMap.getTileId(xAxis, yAxis, 0);

                String value = grassMap.getTileProperty(tileID,
                        "blocked", "false");

                if ("true".equals(value)) {

                    Blocked.blocked[xAxis][yAxis] = true;

                }

            }

        }

        hostiles = new boolean[grassMap.getWidth()][grassMap.getHeight()];

     /*   for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                int xBlock = (int) xAxis;
                int yBlock = (int) yAxis;
                if (!Blocked.blocked[xBlock][yBlock]) {
                    if (yBlock % 7 == 0 && xBlock % 15 == 0) {
                        Item i = new Item(xAxis * SIZE, yAxis * SIZE);
                        stuff.add(i);
                        //stuff1.add(h);
                        hostiles[xAxis][yAxis] = true;
                   }
               }
           }
        } */
 
        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                int xBlock = (int) xAxis;
                int yBlock = (int) yAxis;
                if (!Blocked.blocked[xBlock][yBlock]) {
                    if (xBlock % 7 == 0 && yBlock % 15 == 0) {
                        Item1 h = new Item1(xAxis * SIZE, yAxis * SIZE);
                        //	stuff.add(i);
                        stuff1.add(h);
                        hostiles[xAxis][yAxis] = true;
                    }
                }
            }
        }
        
        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                int xBlock = (int) xAxis;
                int yBlock = (int) yAxis;
                if (!Blocked.blocked[xBlock][yBlock]) {
                    if (xBlock % 9 == 0 && yBlock % 25 == 0) {
                        Goldcoin c = new Goldcoin(xAxis * SIZE, yAxis * SIZE);
                        //	stuff.add(i);
                        coinz.add(c);
                        hostiles[xAxis][yAxis] = true;
                    }
                }
            }
        }

        stuff.add(healthpotion);
        stuff.add(healthpotion1);
        
        point = new Goldcoin(10,10);
        
       // morse = new Ninja(42, 42);
       // gia = new Ninja(0, 0);
       // weber = new Ninja(10, 10);
        
       // xboxz = new Xbox(0,0);
        
        zach = new Enemy(1315,1250);
        enemyz.add(zach);
        
        joe = new Enemy(5097, 727);
        enemyz.add(joe);
        
        rhys = new Enemy(4636,5539);
        enemyz.add(rhys);
        
        adam = new Enemy(2256,1800);
        enemyz.add(adam);
        
        jordan = new Enemy (2536,4125);
        enemyz.add(jordan);
        
        kris = new Enemy (936,5758);
        enemyz.add(kris);

        speedpotion = new Item1(100, 150);
        speedpotion1 = new Item1(450, 100);
        stuff1.add(speedpotion);
        stuff1.add(speedpotion1);
        
        antidote = new Itemwin(5629, 733);
        stuffwin.add(antidote);
        
         orb1 = new Orb((int)player.x, (int)player.y);
    }
    
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {

        camera.centerOn((int) Player.x, (int) Player.y);

        camera.drawMap();

        camera.translateGraphics();

        player.sprite.draw((int) Player.x, (int) Player.y);
        
        g.drawString("Point: " + Player.Score / 1000, camera.cameraX + 10,
                camera.cameraY + 30);
		
        g.drawString("Health: " + Player.health / 1000, camera.cameraX + 10,
                camera.cameraY + 10);

        g.drawString("time passed: " + counter / 1000, camera.cameraX + 600, camera.cameraY);
      
//        morse.currentImage.draw(morse.x, morse.y);
//        gia.currentImage.draw(gia.x, gia.y);
//        weber.currentImage.draw(weber.x, weber.y);
          point.currentImage.draw(point.x, point.y);
      //  xboxz.currentImage.draw(xboxz.x, xboxz.y);
        
        for (Enemy e : enemyz) {
            if (e.isvisible) {
                e.currentanime.draw(e.Bx, e.By);
            }
        }
        
        for (Goldcoin c: coinz) {
            if (c.isvisible) {
                c.currentImage.draw(c.x, c.y);
            }
        }
        
//        for (Item1 h : stuff1) {
//            if (h.isvisible) {
//                h.currentImage.draw(h.x, h.y);
//            }
//       }

        for (Itemwin w : stuffwin) {
            if (w.isvisible) {
                w.currentImage.draw(w.x, w.y);
            }
        }
        if(orb1.isIsVisible()){
            orb1.orbpic.draw(orb1.getX(), orb1.getY());
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {

        counter += delta;

        Input input = gc.getInput();

        float fdelta = delta * Player.speed;

        Player.setpdelta(fdelta);

        double rightlimit = (grassMap.getWidth() * SIZE) - (SIZE * 0.75);

        float projectedright = Player.x + fdelta + SIZE;

        boolean cangoright = projectedright < rightlimit;
        
        for (Enemy e : enemyz) {

            e.move();

        }

        if (input.isKeyDown(Input.KEY_UP)) {

            player.sprite = player.up;

            float fdsc = (float) (fdelta - (SIZE * .15));

            if (!(isBlocked(Player.x, Player.y - fdelta) || isBlocked((float) (Player.x + SIZE + 1.5), Player.y - fdelta))) {

                player.sprite.update(delta);

                Player.y -= fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_DOWN)) {

            player.sprite = player.down;

            if (!isBlocked(Player.x, Player.y + SIZE + fdelta)
                    || !isBlocked(Player.x + SIZE - 1, Player.y + SIZE + fdelta)) {

                player.sprite.update(delta);

                Player.y += fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_LEFT)) {

            player.sprite = player.left;

            if (!(isBlocked(Player.x - fdelta, Player.y) || isBlocked(Player.x
                    - fdelta, Player.y + SIZE - 1))) {

                player.sprite.update(delta);

                Player.x -= fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_RIGHT)) {

            player.sprite = player.right;

            if (cangoright
                    && (!(isBlocked(Player.x + SIZE + fdelta,
                            Player.y) || isBlocked(Player.x + SIZE + fdelta, Player.y
                            + SIZE - 1)))) {

                player.sprite.update(delta);

                Player.x += fdelta;

            } 
        } else if(input.isKeyDown(Input.KEY_SPACE)){
            orb1.setX((int)player.x);
            orb1.setY((int)player.y);
            orb1.hitbox.setX(orb1.getX());
            orb1.hitbox.setY(orb1.getY());
            orb1.setIsVisible(!orb1.isIsVisible());
//            orb1.setIsVisible(true);
            
        }

        Player.rect.setLocation(Player.getplayershitboxX(),
                Player.getplayershitboxY());
        
        for (Goldcoin i : coinz) {

            if (Player.rect.intersects(i.hitbox)) {
                
                if (i.isvisible) {

                    Player.Score += 1000;
                    i.isvisible = false;
                }

            }
        }

      /*  for (Item i : stuff) {

            if (Player.rect.intersects(i.hitbox)) {
                //System.out.println("yay");
                if (i.isvisible) {

                    Player.health += 10000;
                    i.isvisible = false;
                }

            }
         } */

         /* for (Item i : stuff) {

            if (Player.rect.intersects(i.hitbox)) {
                //System.out.println("yay");
                if (i.isvisible) {

                    Player.health += 10000;
                    i.isvisible = false;
                }

            }
        } */
        for (Enemy e : enemyz) {

//            if (Player.rect.intersects(e.rect)) {
//                if (orb1.hitbox.intersects(e.rect)) {
//                    e.isvisible = false; 
//                    Player.health -= 10000;
//                    e.isvisible = false;
//                }
//
//            }
        }

        for (Itemwin w : stuffwin) {

            if (Player.rect.intersects(w.hitbox)) {
                if (w.isvisible) {
                    w.isvisible = false;
                    makevisible();
                    sbg.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

                }

            }
        }

        
        if (Player.health <= 0) {
            makevisible();
            sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }

    }

    public int getID() {

        return 1;

    }

    public void makevisible() {
        for (Goldcoin c : coinz) {

            c.isvisible = true;
        
        for (Item1 h : stuff1) {

            h.isvisible = true;
        }

    /*    for (Item i : stuff) {

            i.isvisible = true;
        }
    } */
        }
    }

    private boolean isBlocked(float tx, float ty) {

        int xBlock = (int) tx / SIZE;

        int yBlock = (int) ty / SIZE;

        return Blocked.blocked[xBlock][yBlock];
    }
}
