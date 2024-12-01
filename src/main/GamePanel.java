package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import environment.EnvironmentManager;
import obj.SuperObj;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{

	// SCREEN SETTINGS
   final int originalTileSize = 16; // 16 x 16 tile
   final int scale = 3;
	   
   public final int tileSize = originalTileSize * scale; // 48 x 48 tile
   public final int maxScreenCol = 16;
   public final int maxScreenRow = 12;
   public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
   public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
	   
   // WORLD SETTINGS
   public final int maxWorldCol = 50;
   public final int maxWorldRow = 50;
   public final int worldWidth = tileSize * maxWorldCol;
   public final int worldHeight = tileSize * maxWorldRow;
   
   
   // FPS Frames PEr Second
   int FPS = 60;
	   
   // System
   TileManager tileM = new TileManager(this);
   KeyHandler keyH = new KeyHandler();
   Thread gameThread;
   public CollisionChecker cChecker = new CollisionChecker(this);
   public UI ui = new UI(this);
   EnvironmentManager eManager = new EnvironmentManager(this);
   
   // Entity and Object
   public AssetSetter aSetter = new AssetSetter(this);
   public Player player = new Player(this,keyH);
   public SuperObj obj[] = new SuperObj[10];
   
	   
	  
 
   public GamePanel() {
	   
      this.setPreferredSize(new Dimension(screenWidth, screenHeight));
      this.setBackground(Color.black);
      this.setDoubleBuffered(true);
      this.addKeyListener(keyH);
      this.setFocusable(true);
   }
   
   
   public void setupGame() {
	   
	   aSetter.setObj();
	   eManager.setup();
   }
	   
   public void startGameThread() {
	   
      gameThread = new Thread(this);
      gameThread.start();
	      
   }  
	   
   public void run() {
	   
	  double drawInterval = 1000000000/FPS; // 0.01666666 seconds
	  double nextDrawTime = System.nanoTime() + drawInterval;
	      
	  while(gameThread != null) {
	      
	     long currentTime = System.nanoTime();
	     
      //         System.out.println("The game loop is running");
	      	  // 1 UPDATE: update the information such as character positions
	      update();
	         
	         
	         // 2 DRAW: draw the screen with the updated information
	      repaint();
	         
	                  
	      try {
	         double remainingTime = nextDrawTime - System.nanoTime();
	         remainingTime = remainingTime/1000000;
	            
	         if(remainingTime < 0) {
	         remainingTime = 0;
	         }
	            
	         Thread.sleep((long) remainingTime);
	            
	         nextDrawTime += drawInterval;
	            
	         } catch (InterruptedException e) {
	               e.printStackTrace();
	         }

	      }
	      
	   }
 
	    public void update() {
	    	
//	    	if (keyH.upPressed == true) {
//	    		playerY -= playerSpeed;
//	    	}
//	    	else if(keyH.downPressed == true) {
//	    		playerY += playerSpeed;
//	    	}
//	    	else if(keyH.leftPressed == true) {
//	    		playerX -= playerSpeed;
//	    	}
//	    	else if(keyH.rightPressed == true) {
//	    		playerX += playerSpeed;
//	    	}
	    	
	    	
	    	
	      player.update();
	      
	   }
	   
	   public void paintComponent(Graphics g) {
		  super.paintComponent(g);
	      Graphics2D g2 = (Graphics2D)g;
	      
	      //TILE
	      tileM.draw(g2);
	      
	      //OBJ
	      for(int i = 0; i < obj.length; i++) {
	    	  if(obj[i] != null) {
	    		  obj[i].draw(g2, this);
	    	  }
	      }
	      
	      //PLAYER
	      player.draw(g2);
	      
	      // Environmental Manager
	      eManager.draw(g2);
	      
	      // UI
	      ui.draw(g2);
	      
	      g2.dispose();
	      
	      
	   }
	
}
