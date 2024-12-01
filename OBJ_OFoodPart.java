package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_OFoodPart extends SuperObj {

	public OBJ_OFoodPart() {
		
		name = "OFoodPart";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objs/103orangefoodpart.png"));
		
		}catch(IOException e ) {
			e.printStackTrace();
		}
		
	}
	
}