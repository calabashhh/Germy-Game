package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_OAmoeba extends SuperObj {

	public OBJ_OAmoeba() {
		
		name = "OAmoeba";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objs/106orangeamoeba.png"));
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	
}