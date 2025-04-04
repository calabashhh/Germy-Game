package environment;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Lighting {

	GamePanel gp;
	BufferedImage darknessFilter;
	
	public Lighting(GamePanel gp, int circleSize) {
		
		//Create a buffered Image
		darknessFilter = new BufferedImage(gp.screenWidth,gp.screenHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)darknessFilter.getGraphics();
		
		// create a screen-sized rectangle area
		Area screenArea = new Area(new Rectangle2D.Double(0,0,gp.screenWidth,gp.screenHeight));
		
		// get the center x and y of the light circle
		int centerX = gp.player.screenX + (gp.tileSize)/2;
		int centerY = gp.player.screenY + (gp.tileSize)/2;
		
		// get the top left x and y of the light circle
		double x = centerX - (circleSize/2);
		double y = centerY - (circleSize/2);
		
		// Create a light circle shape
		Shape circleShape = new Ellipse2D.Double(x, y, circleSize, circleSize);
		
		// create a light circle area
		Area lightArea = new Area(circleShape);
		
		//subtract the light circle from the screen rectangle
		screenArea.subtract(lightArea);
		
		g2.setColor(new Color(0,0,0,0.95f));
		
		g2.fill(screenArea);
		
		g2.dispose();
		
	}
	public void draw(Graphics2D g2) {
		
		g2.drawImage(darknessFilter,  0, 0, null);	
		
		
		
	}
	
}
