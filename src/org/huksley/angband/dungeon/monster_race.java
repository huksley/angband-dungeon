package org.huksley.angband.dungeon;
/**
 * 
 */


class monster_blow
{
	byte method;
	byte effect;
	byte d_dice;
	byte d_side;
};

class monster_race {
	String name;				/* Name (offset) */
	String text;				/* Text (offset) */

	byte hdice;				/* Creatures hit dice count */
	byte hside;				/* Creatures hit dice sides */

	int ac;				/* Armour Class */

	int sleep;				/* Inactive counter (base) */
	byte aaf;				/* Area affect radius (1-100) */
	byte speed;				/* Speed (normally 110) */

	int mexp;				/* Exp value for kill */

	byte mana;                              /* max mana */

	byte freq_ranged;		/* Ranged attack frequency */

	long flags1;			/* Flags 1 (general) */
	long flags2;			/* Flags 2 (abilities) */
	long flags3;			/* Flags 3 (race/resist) */
	long flags4;			/* Flags 4 (inate/breath) */
	long flags5;			/* Flags 5 (normal spells) */
	long flags6;			/* Flags 6 (special spells) */
	long flags7;			/* Flags 6 (summon spells) */

	monster_blow blow[] = new monster_blow[4];	/* Up to four blows per round */


	byte level;				/* Level of creature */
	byte rarity;			/* Rarity of creature */


	byte d_attr;			/* Default monster attribute */
	char d_char;			/* Default monster character */


	byte x_attr;			/* Desired monster attribute */
	char x_char;			/* Desired monster character */


	byte max_num;			/* Maximum population allowed per level */

	byte cur_num;			/* Monster population on current level */

        byte spell_power;


}