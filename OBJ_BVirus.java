package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_BVirus extends SuperObj {

	public OBJ_BVirus() {
		
		name = "BVirus";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objs/101bluevirus.png"));
		
		}catch(IOException e ) {
			e.printStackTrace();
		}
		collision = true;
	}
	
}
