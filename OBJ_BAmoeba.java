package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_BAmoeba extends SuperObj {

	public OBJ_BAmoeba() {
		
		name = "BAmoeba";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objs/107blueamoeba.png"));
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
