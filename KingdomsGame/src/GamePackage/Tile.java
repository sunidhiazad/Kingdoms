package GamePackage;
/**
 * This class for the each of tile object operation
 *
 */
public class Tile {
	String tile_name = "";
	int tile_value = 0;
	int tile_count;
	//Boolean isTilePlaced=false;

	public Tile()
	{}

//	public Boolean getIsTilePlaced() {
//		return isTilePlaced;
//	}
//	public void setIsTilePlaced(Boolean isTilePlaced) {
//		this.isTilePlaced = isTilePlaced;
//	}
	public int getTile_count() {
		return tile_count;
	}
/**
 * 
 * @param tile_count
 */
	public void setTile_count(int tile_count) {
		this.tile_count = tile_count;
	}

	public String getTile_name() {
		return tile_name;
	}
/**
 * 
 * @param tile_name
 */
	public void setTile_name(String tile_name) {
		this.tile_name = tile_name;
	}

	public int getTile_value() {
		return tile_value;
	}
/**
 * 
 * @param tile_value
 */
	public void setTile_value(int tile_value) {
		this.tile_value = tile_value;
	}

}
