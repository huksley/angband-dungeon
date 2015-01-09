package org.huksley.angband.dungeon;


public class object_type {
	int k_idx;			/* Kind index (zero if "dead") */

	byte iy;			/* Y-position on map, or zero */
	byte ix;			/* X-position on map, or zero */

	byte tval;			/* Item type (from kind) */
	byte sval;			/* Item sub-type (from kind) */

	int pval;			/* Item extra-parameter */

	byte discount;		/* Discount (if any) */

	byte number;		/* Number of items */

	int weight;		/* Item weight */

	byte name1;			/* Artifact type, if any */
	byte name2;			/* Ego-Item type, if any */

	byte xtra1;			/* Extra info type (or activation indicator). */
	byte xtra2;			/* Extra info or activation index. */

	int to_h;			/* Plusses to hit */
	int to_d;			/* Plusses to damage */
	int to_a;			/* Plusses to AC */

	int ac;			/* Normal AC */

	byte dd, ds;		/* Damage dice/sides */

	int timeout;		/* Timeout Counter */

	byte ident;			/* Special flags  */

	byte marked;		/* Object is marked */

	byte feel;			/* Feeling index */
	
	long note;			/* Inscription index */

	int next_o_idx;	/* Next object in stack (if any) */

	int held_m_idx;	/* Monster holding us (if any) */
}
