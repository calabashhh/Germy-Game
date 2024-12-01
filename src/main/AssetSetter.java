package main;

import obj.OBJ_BAmoeba;
import obj.OBJ_BFoodPart;
import obj.OBJ_BVirus;
import obj.OBJ_OAmoeba;
import obj.OBJ_OFoodPart;
import obj.OBJ_PAmoeba;
import obj.OBJ_PFoodPart;
import obj.OBJ_SimpleHole;
import obj.OBJ_TealRedCell;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		
	}
	
	public void setObj() {
		
		gp.obj[0] = new OBJ_BVirus();
		gp.obj[0].worldX = 25 * gp.tileSize;
		gp.obj[0].worldY = 45 * gp.tileSize;
		
		gp.obj[1] = new OBJ_BFoodPart();
		gp.obj[1].worldX = 39 * gp.tileSize;
		gp.obj[1].worldY = 27 * gp.tileSize;
		
		gp.obj[2] = new OBJ_OFoodPart();
		gp.obj[2].worldX = 48 * gp.tileSize;
		gp.obj[2].worldY = 6 * gp.tileSize;
		
		gp.obj[3] = new OBJ_PFoodPart();
		gp.obj[3].worldX = 46 * gp.tileSize;
		gp.obj[3].worldY = 17 * gp.tileSize;
		
		gp.obj[4] = new OBJ_PAmoeba();
		gp.obj[4].worldX = 25 * gp.tileSize;
		gp.obj[4].worldY = 34 * gp.tileSize;
		
		gp.obj[5] = new OBJ_OAmoeba();
		gp.obj[5].worldX = 19 * gp.tileSize;
		gp.obj[5].worldY = 27 * gp.tileSize;
		
		gp.obj[6] = new OBJ_BAmoeba();
		gp.obj[6].worldX = 26 * gp.tileSize;
		gp.obj[6].worldY = 13 * gp.tileSize;
		
		gp.obj[7] = new OBJ_SimpleHole();
		gp.obj[7].worldX = 25 * gp.tileSize;
		gp.obj[7].worldY = 28 * gp.tileSize;
		
		gp.obj[8] = new OBJ_TealRedCell();
		gp.obj[8].worldX = 25 * gp.tileSize;
		gp.obj[8].worldY = 23 * gp.tileSize;
		
		
	}
	
}
