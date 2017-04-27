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
@XmlRootElement(name = "players")
public class PlayerList {
 
    @XmlElement(name = "player", type = Player.class)
    private List<Player> players = new ArrayList<Player>();
 
    /**
     * Default Constructor
     */
    public PlayerList() {}
 
    /**
     * 
     * @param players
     */
    public PlayerList(List<Player> players) {
        this.players = players;
    }
 
    /**
     * 
     * @return List<Player>
     */
    public List<Player> getplayers() {
        return players;
    }
 
    /**
     * 
     * @param players
     */
    public void setplayers(List<Player> players) {
        this.players = players;
    }
}
