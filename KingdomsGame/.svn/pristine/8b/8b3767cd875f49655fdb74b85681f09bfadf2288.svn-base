package GamePackage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class is made to make Xml read write operations easier and initialize epoch list
 * 
 * @version 1.0
 * @since 1.0.0
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Epochs")
public class EpochList {

	@XmlElement(name = "epoch", type = Epoch.class)
	public List<Epoch> epochs = new ArrayList<Epoch>();
	/**
	 * 
	 * @return List<Epoch>
	 */
	public List<Epoch> getEpochs() {
		return epochs;
	}
/**
 * 
 * @param List<Epoch>
 */
	public void setEpochs(List<Epoch> epochs) {
		this.epochs = epochs;
	}
/**
 * Empty constructor needed for xml operation.
 */
	public  EpochList() {
	}
/**
 * 
 * @param List<Epoch>
 */
	public EpochList(List<Epoch> epochs) {
		this.epochs = epochs;
	}


}
