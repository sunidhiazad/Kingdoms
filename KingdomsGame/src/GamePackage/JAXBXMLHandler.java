package GamePackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
/**
 * Convert List<Player> to Xml and vice-versa 
 * method unmarshal retuns List<Players>
 *
 */
public class JAXBXMLHandler {

	/**
	 * marshals player list
	 * 
	 * @param players
	 * @param selectedFile
	 * @throws IOException
	 * @throws JAXBException
	 */
	public static void marshal(List<Player> players, File selectedFile)
			throws IOException, JAXBException {
		JAXBContext context;
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(selectedFile));
		context = JAXBContext.newInstance(PlayerList.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(new PlayerList(players), writer);
		writer.close();
	}
	/**
	 * Marshal tile list
	 * 
	 * @param tiles
	 * @param selectedFile
	 * @throws IOException
	 * @throws JAXBException
	 */
	public static void marshalTile(List<Tile> tiles, File selectedFile)
			throws IOException, JAXBException {
		JAXBContext context;
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(selectedFile));
		context = JAXBContext.newInstance(TileList.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(new TileList(tiles), writer);
		writer.close();
	}
	/**
	 * Marshal block list
	 * 
	 * @param blocks
	 * @param selectedFile
	 * @throws IOException
	 * @throws JAXBException
	 */
	public static void marshalBlock(List<Blocks> blocks, File selectedFile)
			throws IOException, JAXBException {
		JAXBContext context;
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(selectedFile));
		context = JAXBContext.newInstance(BlockList.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(new BlockList(blocks), writer);
		writer.close();
	}
	/**
	 * Marshal epoch list 
	 * 
	 * @param epochs
	 * @param selectedFile
	 * @throws IOException
	 * @throws JAXBException
	 */
	public static void marshalEpoch(List<Epoch> epochs, File selectedFile)
			throws IOException, JAXBException {
		JAXBContext context;
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(selectedFile));
		context = JAXBContext.newInstance(EpochList.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(new EpochList(epochs), writer);
		writer.close();
	}

	/**
	 * Unmarshal player list used for reading player's XML
	 * 
	 * 
	 * @param importFile
	 * @return PlayerList
	 * @throws JAXBException
	 */
	public static List<Player> unmarshal(File importFile) throws JAXBException {
		PlayerList players = new PlayerList();
		JAXBContext context = JAXBContext.newInstance(PlayerList.class);
		Unmarshaller um = context.createUnmarshaller();
		players = (PlayerList) um.unmarshal(importFile);
		return players.getplayers();
	}
	/**
	 * used to read tilebank xml
	 * 
	 * 
	 * @param importFile
	 * @return TileList
	 * @throws JAXBException
	 */
	public static List<Tile> unmarshaltile(File importFile) throws JAXBException {
		TileList tiles = new TileList();
		JAXBContext context = JAXBContext.newInstance(TileList.class);
		Unmarshaller um = context.createUnmarshaller();
		tiles = (TileList) um.unmarshal(importFile);
		return tiles.getTiles();
	}
	/**
	 * Used to read block xml
	 * 
	 * 
	 * @param importFile
	 * @return BlockList
	 * @throws JAXBException
	 */
	public static List<Blocks> unmarshalBlock(File importFile) throws JAXBException {
		BlockList blocks = new BlockList();
		JAXBContext context = JAXBContext.newInstance(BlockList.class);
		Unmarshaller um = context.createUnmarshaller();
		blocks = (BlockList) um.unmarshal(importFile);
		return blocks.getBlocks();
	}
	
	/**
	 * 
	 * @param importFile
	 * @return List<Epoch>
	 * @throws JAXBException
	 */
	public static List<Epoch> unmarshalEpoch(File importFile) throws JAXBException {
		EpochList epochs = new EpochList();
		JAXBContext context = JAXBContext.newInstance(EpochList.class);
		Unmarshaller um = context.createUnmarshaller();
		epochs = (EpochList) um.unmarshal(importFile);
		return epochs.getEpochs();
	}
	

	

}