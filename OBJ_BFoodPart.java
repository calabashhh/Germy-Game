package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_BFoodPart extends SuperObj {

	public OBJ_BFoodPart() {
		
		name = "BFoodPart";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objs/102bluefoodpart.png"));
		
		}catch(IOException e ) {
			e.printStackTrace();
		}
		
	}
	
}