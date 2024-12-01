package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	public int hasBFood = 0;
	public int hasOFood = 0;
	public int hasPFood = 0;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 10;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 26;
		solidArea.height = 24;
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 2;
		worldY = gp.tileSize * 48;
		speed = 4;
		direction = "down";
	}
	public void getPlayerImage() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/GermyUp1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/GermyUp2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/GermyDown1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/GermyDown2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/GermyRight1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/GermyRight2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/GermyLeft1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/GermyLeft2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public void update() {
		
			if(keyH.upPressed == true || keyH.downPressed == true || 
					keyH.leftPressed == true || keyH.rightPressed == true) {
				
				 if(keyH.upPressed == true) {
					   direction = "up";
				         
				         // playerY = playerY - playerSpeed;
				 }
				 else if(keyH.downPressed == true) {
				   	  direction = "down";
				 }
				 else if(keyH.leftPressed == true) {
				   	  direction = "left";
				 }
				 else if(keyH.rightPressed == true) {
				  	  direction = "right";
				 }
				 
				 // Check Tile Collision
				 collisionOn = false;
				 gp.cChecker.checkTile(this);
				 
				 // Check object collision
				 int objIndex = gp.cChecker.checkObj(this,  true);
				 pickUpObj(objIndex);
				 
				 	
				 // If collision is false, player can move
				 if(collisionOn == false) {
					 
					 switch(direction) {
					 case "up": worldY -= speed; break;
					 case "down": worldY += speed; break;
					 case "left": worldX -= speed; break;
					 case "right": worldX += speed; break;
					 }
				 }
				   
				   	spriteCounter++;
				   	if(spriteCounter > 10) {
				   		if(spriteNum == 1) {
				   			spriteNum = 2;
				   		}
				   		else if(spriteNum == 2) {
				   			spriteNum = 1;
				   		}
				   		spriteCounter = 0;
				   	}
			}
		
		  
	}
	public void pickUpObj(int i) {
		
		if(i != 999) {
			
			String objName = gp.obj[i].name;
			
			switch(objName) {
			case "BFoodPart":
				hasBFood++;
				gp.obj[i] = null;
				gp.ui.showMessage("You got a blue antibody!");
				break;
			case "OFoodPart":
				hasOFood++;
				gp.obj[i] = null;
				gp.ui.showMessage("You got an orange antibody!");
				break;
			case "PFoodPart":
				hasPFood++;
				gp.obj[i] = null;
				gp.ui.showMessage("You got a purple antibody!");
				break;
			case "BAmoeba":
				if(hasBFood > 0) {
					gp.obj[i] = null;
					hasBFood--;
					gp.ui.showMessage("The blue amoeba has been eliminated!");
				}
				else {
					gp.ui.showMessage("You must find the right antibody to eliminate the amoeba.");
				}
				break;
			case "OAmoeba":
				if(hasOFood > 0) {
					gp.obj[i] = null;
					hasOFood--;
					gp.ui.showMessage("The orange amoeba has been eliminated!");
				}
				else {
					gp.ui.showMessage("You must find the right antibody to eliminate the amoeba.");
				}
				break;
			case "PAmoeba":
				if(hasPFood > 0) {
					gp.obj[i] = null;
					hasPFood--;
					gp.ui.showMessage("The purple amoeba has been eliminated!");
				}
				else {
					gp.ui.showMessage("You must find the right antibody to eliminate the amoeba.");
				}
				break;
			case "BVirus":
				gp.ui.showMessage("You must find the teal cell.");
				break;
			case "TealRedCell":
				gp.ui.showMessage("You found your way through!");
			
			
			}
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		// g2.setColor(Color.white);  
	    //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}







