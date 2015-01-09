package org.huksley.angband.dungeon;
/**
 * 
 */


class dun_data {
	/* Array of centers of rooms */
	int cent_n;
	coord[] cent = new coord[Generate.CENT_MAX];

	/* Array to store whether rooms are connected or not. */
	boolean[] connected = new boolean[Generate.CENT_MAX];

	/* Array of possible door locations */
	int door_n;
	coord[] door = new coord[Generate.DOOR_MAX];

	/* Array of wall piercing locations */
	int wall_n;
	coord[] wall = new coord[Generate.WALL_MAX];

	/* Array of tunnel grids */
	int tunn_n;
	coord[] tunn = new coord[Generate.TUNN_MAX];

	/* Array of good potential stair grids */
	int stair_n;
	coord[] stair = new coord[Generate.STAIR_MAX];

	/* Number of blocks along each axis */
	int row_rooms;
	int col_rooms;

	/* Array to store block usage */
	int[][] room_map = new int[Generate.MAX_ROOMS_ROW][Generate.MAX_ROOMS_COL];
	
	public dun_data() {
		init(cent);
		init(door);
		init(stair);
		init(tunn);
		init(wall);
	}
	
	public void init(coord[] l) {
		for (int i = 0;i < l.length; i++) {
			l[i] = new coord();
		}		
	}
}