package org.huksley.angband.dungeon;


public class artifact_type {
	int name;			/* Name (offset) */
	int text;			/* Text (offset) */

	byte tval;			/* Artifact type */
	byte sval;			/* Artifact sub type */

	int pval;			/* Artifact extra info */

	int to_h;			/* Bonus to hit */
	int to_d;			/* Bonus to damage */
	int to_a;			/* Bonus to armor */

	int ac;			/* Base armor */

	byte dd, ds;		/* Damage when hits */

	int weight;		/* Weight */
	int cost;			/* Artifact "cost" */

	long flags1;		/* Artifact Flags, set 1 */
	long flags2;		/* Artifact Flags, set 2 */
	long flags3;		/* Artifact Flags, set 3 */

	byte level;			/* Artifact level */
	byte rarity;		/* Artifact rarity */

	byte creat_stat;		/* Was cur_num.  0 or 1.
					 * Possible future expanded functionality. */
	byte activation;		/* Temporary activation index. -LM- */

	byte set_no;		/* Stores the set number of the artifact. 0 if not part of a set -GS- */
	boolean set_bonus;		/* Is the item set, is the bonus currently applied? */

}
