package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_SimpleHole extends SuperObj {

	public OBJ_SimpleHole() {
		
		name = "SimpleHole";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objs/108simplehole.png"));
		
		}catch(IOException e ) {
			e.printStackTrace();
		}
		
	}
	
}
