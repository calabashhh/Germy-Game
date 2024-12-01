package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import obj.OBJ_BFoodPart;
import obj.OBJ_OFoodPart;
import obj.OBJ_PFoodPart;

public class UI {

	GamePanel gp;
	Font arial_20;
	BufferedImage bFoodImage;
	BufferedImage pFoodImage;
	BufferedImage oFoodImage;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_20 = new Font("Arial", Font.PLAIN, 20);
		OBJ_BFoodPart bFood = new OBJ_BFoodPart();
		bFoodImage = bFood.image;
		OBJ_PFoodPart pFood = new OBJ_PFoodPart();
		pFoodImage = pFood.image;
		OBJ_OFoodPart oFood = new OBJ_OFoodPart();
		oFoodImage = oFood.image;
	}
	
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		
		g2.setFont(arial_20);
		g2.setColor(Color.white);
		g2.drawImage(bFoodImage, gp.tileSize/2,  gp.tileSize/2, gp.tileSize, gp.tileSize, null);
		g2.drawImage(pFoodImage, gp.tileSize/2,  (gp.tileSize/2) * 3, gp.tileSize, gp.tileSize, null);
		g2.drawImage(oFoodImage, gp.tileSize/2,  (gp.tileSize/2) * 5, gp.tileSize, gp.tileSize, null);
		g2.drawString("x "+ gp.player.hasBFood, 74, 60);
		g2.drawString("x "+ gp.player.hasPFood, 74, 110);
		g2.drawString("x "+ gp.player.hasOFood, 74, 155);
		
		
		// Message
		if(messageOn == true) {
			
			g2.setFont(g2.getFont().deriveFont(20F));
			g2.drawString(message,  gp.tileSize*5, gp.tileSize);
			
			messageCounter++;
			
			if(messageCounter > 120) {
				messageCounter = 0;
				messageOn = false;
			}
		}
	}
	
	
}
