package GamePackage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class is made to make Xml read write operations easier and initialize block list
 * 
 * @version 1.0
 * @since 1.0.0
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Blocks")
public class BlockList {

	@XmlElement(name = "block", type = Blocks.class)
	public List<Blocks> blocks = new ArrayList<Blocks>();
	
	public  BlockList() {
	}
/**
 * 
 * @param blocks
 */
	public BlockList(List<Blocks> blocks) {
		this.blocks = blocks;
	}
/**
 * 
 * @return List<Blocks> object
 */
	public List<Blocks> getBlocks() {
		return blocks;
	}
/**
 * 
 * @param blocks
 */
	public void setBlocks(List<Blocks> blocks) {
		this.blocks = blocks;
	}
}
