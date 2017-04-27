package GamePackage;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

/**
 * This class is used to read/write Xml,creates playerstats.xml,Block.xml,TileBank.xml file input
 * List<Player>
 * 
 * @see JAXBXMLHandler
 * @version 1.0
 * @since 1.0.0
 * 
 */

public class XmlOperation {
	/**
	 * creates and write playerstats.xml
	 * 
	 * @param List<Player>
	 */
	public static void WriteXML(List<Player> players) {
		try {
			JAXBXMLHandler.marshal(players, new File("playerstats.xml"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * creates and write TileBank.xml
	 * 
	 * @param List<Tile>
	 */
	public static void WriteTileXML(List<Tile> tiles) {
		try {
			JAXBXMLHandler.marshalTile(tiles, new File("TileBank.xml"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * creates and write Block.xml
	 * 
	 * @param List<Blocks>
	 */
	public static void WriteBlockXML(List<Blocks> blocks) {
		try {
			JAXBXMLHandler.marshalBlock(blocks, new File("Block.xml"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * creates and write score.xml
	 * 
	 * @param List<Epoch>
	 */
	public static void WriteEpochXML(List<Epoch> epochs) {
		try {
			JAXBXMLHandler.marshalEpoch(epochs, new File("score.xml"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Reads player's xml
	 * 
	 * @return List<Player>
	 */
	public static List<Player> ReadXML() {
		try {
			List<Player> players = JAXBXMLHandler.unmarshal(new File(
					"playerstats.xml"));
			return players;
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Reads TileBank.xml
	 * 
	 * @return List<Tile>
	 */
	public static List<Tile> ReadTileXML() {
		try {
			List<Tile> tiles = JAXBXMLHandler.unmarshaltile(new File(
					"TileBank.xml"));
			return tiles;
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Reads block.xml
	 * 
	 * @return List<Blocks>
	 */
	public static List<Blocks> ReadBlockXML() {
		try {
			List<Blocks> blocks = JAXBXMLHandler.unmarshalBlock(new File(
					"Block.xml"));
			return blocks;
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * Reads Epoch Xml
	 * 
	 * @return List<Epoch>
	 */
	public static List<Epoch> ReadEpochXML() {
		try {
			List<Epoch> epochs = JAXBXMLHandler.unmarshalEpoch(new File(
					"score.xml"));
			return epochs;
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

}
