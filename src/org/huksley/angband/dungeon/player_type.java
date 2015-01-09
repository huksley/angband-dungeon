package org.huksley.angband.dungeon;
/**
 * 
 */



class player_type {
	int py;			/* Player location */
	int px;			/* Player location */

	int depth;			/* Cur depth */


	byte themed_level;	/* Player in a themed level?  Which one? */
	/* Flags indicating which themed levels have already appeared. -LM- */
	long themed_level_appeared;

	/*** Temporary fields ***/

	boolean create_up_stair;	        /* Create up stair on next level */
	boolean create_down_stair;	        /* Create down stair on next level */

	long update;		/* Pending Updates (bit flags) */
	long redraw;		/* Normal Redraws (bit flags) */
	long window;		/* Window Redraws (bit flags) */

    /* Add some variables for disturb_trap_detect.  Not saved.  -BR- */
    byte dtrap_x;           /* X location of last trap detection */
    byte dtrap_y;           /* Y location of last trap detection */
    byte dtrap_rad;         /* radius of last trap detection */
}