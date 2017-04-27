package GamePackage;

/**
 * This class for the player object operation
 * 
 */

public class Player {
	int player_id;
	boolean hasturn = false;
	String color = "";
	int rank1_castle;
	int rank2_castle;
	int rank3_castle;
	int rank4_castle;
	String strategy = "";
	public Tile getTile1() {
		return tile1;
	}

	public void setTile1(Tile tile1) {
		this.tile1 = tile1;
	}

	public Tile getTile2() {
		return tile2;
	}

	public void setTile2(Tile tile2) {
		this.tile2 = tile2;
	}

	public Tile getTile3() {
		return tile3;
	}

	public void setTile3(Tile tile3) {
		this.tile3 = tile3;
	}

	Tile tile1 = new Tile();
	Tile tile2 = new Tile();
	Tile tile3 = new Tile();

	public int getPlayer_id() {
		return player_id;
	}

	/**
	 * 
	 * @param player_id
	 */
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public boolean isHasturn() {
		return hasturn;
	}

	/**
	 * 
	 * @param hasturn
	 */
	public void setHasturn(boolean hasturn) {
		this.hasturn = hasturn;
	}

	public String getColor() {
		return color;
	}

	/**
	 * 
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	public int getRank1_castle() {
		return rank1_castle;
	}

	/**
	 * 
	 * @param rank1_castle
	 */
	public void setRank1_castle(int rank1_castle) {
		this.rank1_castle = rank1_castle;
	}

	public int getRank2_castle() {
		return rank2_castle;
	}

	/**
	 * 
	 * @param rank2_castle
	 */
	public void setRank2_castle(int rank2_castle) {
		this.rank2_castle = rank2_castle;
	}

	public int getRank3_castle() {
		return rank3_castle;
	}

	/**
	 * 
	 * @param rank3_castle
	 */
	public void setRank3_castle(int rank3_castle) {
		this.rank3_castle = rank3_castle;
	}

	public int getRank4_castle() {
		return rank4_castle;
	}

	/**
	 * 
	 * @param rank4_castle
	 */
	public void setRank4_castle(int rank4_castle) {
		this.rank4_castle = rank4_castle;
	}

	public String getStrategy() {
		return strategy;
	}

	/**
	 * 
	 * @param strategy
	 */
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

}
