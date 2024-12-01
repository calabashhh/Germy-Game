package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_PAmoeba extends SuperObj {

	public OBJ_PAmoeba() {
		
		name = "PAmoeba";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objs/105purpleamoeba.png"));
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	
}