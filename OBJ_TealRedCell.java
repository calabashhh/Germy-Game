package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_TealRedCell extends SuperObj {

	public OBJ_TealRedCell() {
		
		name = "TealRedCell";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objs/109tealredcell.png"));
		
		}catch(IOException e ) {
			e.printStackTrace();
		}
		collision = true;
	}
	
}