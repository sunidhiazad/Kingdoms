package GamePackage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 /**
  * This class is made to make Xml read write operations easier and initial object list players
  * @version 1.0
  * @since 1.0.0
  *
  */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "tiles")
public class TileList {
 
    @XmlElement(name = "tile", type = Tile.class)
    private List<Tile> tiles = new ArrayList<Tile>();
 /**
  * Empty constructor is needed for xml operations.
  */
    public  TileList() {
	}
    /**
     * 
     * @param List<Tile>
     */
     public TileList(List<Tile> tiles) {
        this.tiles = tiles;
    }
 /**
  * 
  * @return List<Tile>
  */
    public List<Tile> getTiles() {
        return tiles;
    }
 /**
  * 
  * @param List<Tile>
  */
    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }
}
