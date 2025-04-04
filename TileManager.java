package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[20];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/world01.txt");
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/muscle.png"));
			tile[0].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/mucos.png"));
			tile[2].collision = true;
		
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/dermos.png"));
			tile[4].collision = true;
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lipos.png"));
			tile[6].collision = true;
			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/membrane.png"));
			tile[7].collision = true;
			
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/oesto.png"));
			tile[8].collision = true;
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sangus.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/herros.png"));
			tile[1].collision = true;
			
			//tile[12] = new Tile();
			//tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
		}catch(IOException e ) {
			e.printStackTrace();
		}
		
	}
	public void loadMap(String filePath) {
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col] [row] = num;
					col++;
				}
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		}catch(Exception e) {
			
		}
	}
	
	
	public void draw(Graphics2D g2) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX; //from here to...
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			
			if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
				worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
				worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
				worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			} // ... to here this was copied to the new SuperObj
			
			worldCol++;
	
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
			
		}
		
		
		
	}
	
	
}
