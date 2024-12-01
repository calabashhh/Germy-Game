package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_PFoodPart extends SuperObj {

	public OBJ_PFoodPart() {
		
		name = "PFoodPart";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objs/104purplefoodpart.png"));
		
		}catch(IOException e ) {
			e.printStackTrace();
		}
		
	}
	
}