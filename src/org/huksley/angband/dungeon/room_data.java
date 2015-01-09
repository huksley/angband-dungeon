package org.huksley.angband.dungeon;
/**
 * 
 */


class room_data
{
	/* Allocation information. */
	int room_gen_num[] = new int[11];

	/* Minimum level on which room can appear. */
	int min_level;
	
	room_data(int[] g, int minl) {
		room_gen_num = g;
		min_level = minl;
	}
}