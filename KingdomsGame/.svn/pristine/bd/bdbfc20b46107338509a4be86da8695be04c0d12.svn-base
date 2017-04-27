package GamePackage;

import java.util.ArrayList;
import java.util.List;

/**
 * This class for setting points value and base values for row and column for
 * each of blocks
 */
public class HandleBaseValue {
	int[] row_points = new int[5];
	int[] column_points = new int[6];
	int GMrow = 0;
	int GMcolumn = 0;
	int wizrow = 0;
	int wizcolumn = 0;
	List<Blocks> block_list = new ArrayList<Blocks>();

	/**
	 * Constructor to set the base value.
	 * 
	 * @param blockobj
	 * @param block_list
	 */
	public HandleBaseValue(Blocks obj) {
		block_list = XmlOperation.ReadBlockXML();
		for (int i = 0; i < row_points.length; i++) {
			row_points[i] = 0;
		}
		for (int i = 0; i < column_points.length; i++) {
			column_points[i] = 0;
		}
		for (int i = 0; i < block_list.size(); i++) {
			if (block_list.get(i).getCastle_rank() == 0) {
				if (block_list.get(i).getTile().equals("GoldMine")) {
					GMrow = block_list.get(i).getRow();
					GMcolumn = block_list.get(i).getColummn();
				}
				if (block_list.get(i).getTile().equals("Wizard")) {
					wizrow = block_list.get(i).getRow();
					wizcolumn = block_list.get(i).getColummn();
				}
			}
		}
		if (obj.getRow() == GMrow || obj.getColummn() == GMcolumn)
			workOnGoldMineTile(obj);

		if (obj.getRow() == wizrow
				&& Math.abs(obj.getColummn() - wizcolumn) == 1
				|| obj.getColummn() == wizcolumn
				&& Math.abs(obj.getRow() - wizrow) == 1)
			workOnWizardMineTile(obj);

		setBaseValue();
	}

	/**
	 * Is called when a block is placed adjacent to wizard tile and it doubles
	 * the ranks of the castles.
	 * 
	 * @param obj
	 */
	public void workOnWizardMineTile(Blocks obj) {
		for (int i = 0; i < block_list.size(); i++) {
			if (block_list.get(i).getRow() == obj.getRow()
					&& block_list.get(i).getColummn() == obj.getColummn()) {
				int rank = block_list.get(i).getCastle_rank() * 2;
				block_list.get(i).setCastle_rank(rank);
			}
		}
		XmlOperation.WriteBlockXML(block_list);
	}

	/**
	 * Doubles the points of the tiles.
	 * @param obj
	 */
	public void workOnGoldMineTile(Blocks obj) {
		for (int i = 0; i < block_list.size(); i++) {
			if (block_list.get(i).getRow() == obj.getRow()
					&& block_list.get(i).getColummn() == obj.getColummn()) {
				int points = block_list.get(i).getPoints() * 2;
				block_list.get(i).setPoints(points);
			}
		}
		XmlOperation.WriteBlockXML(block_list);
	}

	/**
	 * Sets the base value for each row and column and writes the updates list
	 * back to xml.
	 */
	public void setBaseValue() {
		for (int i = 0; i < block_list.size(); i++) {
			if (i >= 0 && i < 6) {
				row_points[0] += block_list.get(i).getPoints();
			}
			if (i >= 6 && i < 12) {
				row_points[1] += block_list.get(i).getPoints();
			}
			if (i >= 12 && i < 18) {
				row_points[2] += block_list.get(i).getPoints();
			}
			if (i >= 18 && i < 24) {
				row_points[3] += block_list.get(i).getPoints();
			}
			if (i >= 24 && i < 30) {
				row_points[4] += block_list.get(i).getPoints();
			}
			if (i == 0 || i == 6 || i == 12 || i == 18 || i == 24) {
				column_points[0] += block_list.get(i).getPoints();
			}
			if (i == 1 || i == 7 || i == 13 || i == 19 || i == 25) {
				column_points[1] += block_list.get(i).getPoints();
			}
			if (i == 2 || i == 8 || i == 14 || i == 20 || i == 26) {
				column_points[2] += block_list.get(i).getPoints();
			}
			if (i == 3 || i == 9 || i == 15 || i == 21 || i == 27) {
				column_points[3] += block_list.get(i).getPoints();
			}
			if (i == 4 || i == 10 || i == 16 || i == 22 || i == 28) {
				column_points[4] += block_list.get(i).getPoints();
			}
			if (i == 5 || i == 11 || i == 17 || i == 23 || i == 29) {
				column_points[5] += block_list.get(i).getPoints();
			}
		}

		// for (int i = 0; i < row_points.length; i++) {
		// System.out.println("Row "+(i+1)+" : "+row_points[i]);
		// }
		// for (int i = 0; i < column_points.length; i++) {
		// System.out.println("Column "+(i+1)+" : "+column_points[i]);
		// }

		for (int i = 0; i < block_list.size(); i++) {
			if (block_list.get(i).getRow() == 1) {
				block_list.get(i).setRow_base_value(row_points[0]);
			}
			if (block_list.get(i).getRow() == 2) {
				block_list.get(i).setRow_base_value(row_points[1]);
			}
			if (block_list.get(i).getRow() == 3) {
				block_list.get(i).setRow_base_value(row_points[2]);
			}
			if (block_list.get(i).getRow() == 4) {
				block_list.get(i).setRow_base_value(row_points[3]);
			}
			if (block_list.get(i).getRow() == 5) {
				block_list.get(i).setRow_base_value(row_points[4]);
			}
			if (block_list.get(i).getColummn() == 1) {
				block_list.get(i).setColumn_base_value(column_points[0]);
			}
			if (block_list.get(i).getColummn() == 2) {
				block_list.get(i).setColumn_base_value(column_points[1]);
			}
			if (block_list.get(i).getColummn() == 3) {
				block_list.get(i).setColumn_base_value(column_points[2]);
			}
			if (block_list.get(i).getColummn() == 4) {
				block_list.get(i).setColumn_base_value(column_points[3]);
			}
			if (block_list.get(i).getColummn() == 5) {
				block_list.get(i).setColumn_base_value(column_points[4]);
			}
			if (block_list.get(i).getColummn() == 6) {
				block_list.get(i).setColumn_base_value(column_points[5]);
			}
		}
		XmlOperation.WriteBlockXML(block_list);
	}

}
