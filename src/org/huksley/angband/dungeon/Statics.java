package org.huksley.angband.dungeon;


import java.util.Random;


public class Statics implements Constants {

	Random random = new Random(System.currentTimeMillis());
	
	object_type[] o_list = new object_type[MAX_O_IDX];
	int o_max = 1;
	int level = 0;
	artifact_type[] a_info;
	quest[] q_list = new quest[MAX_Q_IDX];
	int num_trap_on_level = 0;
	int num_glyph_on_level = 0;
	int number_of_thefts_on_level = 0;
	byte[] mp_a;
	char[] mp_c;
	byte[] mp_ta;
	char[] mp_tc;
	vault_type[] t_info;
	String t_text;
	boolean fresh_after;
	int required_tval;
	int panel_row_min;
	int panel_col_min;
	int panel_row_max;
	monster_race[] r_info;
	
	int cave_m_idx[][] = new int[256][256];
	int cave_o_idx[][] = new int[256][256];
	int cave_feat[][] = new int[256][256];
	int cave_info[][] = new int[256][256];
	int cave_cost[][] = new int[256][256];
	int cave_when[][] = new int[256][256];
	
	int ddd[] = { 2, 8, 6, 4, 3, 1, 9, 7, 5 };
	int ddx[] = {  0, -1,  0,  1, -1,  0,  1, -1,  0,  1 };
	int ddy[] = {  0,  1,  1,  1,  0,  0,  0, -1, -1, -1 };
	int ddx_ddd[] = {  0,  0,  1, -1,  1, -1,  1, -1,  0 };
	int ddy_ddd[] = {  1, -1,  0,  0,  1,  1, -1, -1,  0 };
	vault_type[] v_info = new vault_type[MAX_V_IDX];
	boolean cheat_room = false;
	boolean cheat_hear = false;
	boolean cheat_peek = false;
	boolean cheat_xtra = false;
	StringBuffer r_name = null;
	boolean character_dungeon;
	boolean dungeon_stair = false;
	boolean Rand_quick = false;
	
	int m_max = 0;

	int turn = 0;
	int seed_town = rand_int(0x10000000);
	int monster_level = 0;
	int get_angle_to_grid[][] = {
			{  67,  66,  66,  66,  66,  66,  66,  65,  63,  62,  61,  60,  58,  57,  55,  54,  52,  50,  48,  46,  45,  44,  41,  40,  38,  36,  35,  33,  32,  30,  29,  28,  27,  25,  24,  24,  23,  23,  23,  23,  22 },
			{  68,  67,  66,  66,  66,  66,  66,  65,  63,  62,  61,  60,  58,  57,  55,  54,  52,  50,  49,  47,  45,  43,  41,  40,  38,  36,  35,  33,  32,  30,  29,  28,  27,  25,  24,  24,  23,  23,  23,  22,  21 },
			{  68,  68,  67,  66,  66,  66,  66,  65,  63,  62,  61,  60,  58,  57,  55,  54,  52,  50,  49,  47,  45,  43,  41,  40,  38,  36,  35,  33,  32,  30,  29,  28,  27,  25,  24,  24,  23,  23,  22,  21,  21 },
			{  68,  68,  68,  67,  66,  66,  66,  65,  63,  62,  61,  60,  58,  57,  55,  54,  52,  50,  49,  47,  45,  43,  41,  40,  38,  36,  35,  33,  32,  30,  29,  28,  27,  25,  24,  24,  23,  22,  21,  21,  21 },
			{  68,  68,  68,  68,  67,  66,  66,  65,  63,  62,  61,  60,  58,  57,  55,  54,  52,  50,  49,  47,  45,  43,  41,  40,  38,  36,  35,  33,  32,  30,  29,  28,  27,  25,  24,  24,  22,  21,  21,  21,  21 },
			{  68,  68,  68,  68,  68,  67,  66,  65,  64,  63,  62,  60,  59,  58,  56,  54,  52,  51,  49,  47,  45,  43,  41,  39,  38,  36,  34,  32,  31,  30,  28,  27,  26,  25,  24,  22,  21,  21,  21,  21,  21 },
			{  69,  69,  69,  69,  69,  68,  67,  66,  65,  64,  63,  61,  60,  58,  57,  55,  53,  51,  49,  47,  45,  43,  41,  39,  37,  35,  33,  32,  30,  29,  27,  26,  25,  24,  22,  21,  21,  21,  21,  21,  21 },
			{  70,  70,  70,  70,  70,  70,  69,  67,  66,  65,  64,  62,  61,  59,  57,  56,  54,  51,  49,  47,  45,  43,  41,  39,  36,  34,  33,  31,  29,  28,  26,  25,  24,  22,  21,  20,  20,  20,  20,  20,  20 },
			{  72,  72,  72,  72,   72,  71,  70,  69,  67,  66,  65,  63,  62,  60,  58,  56,  54,  52,  50,  47,  45,  43,  40,  38,  36,  34,  32,  30,  28,  27,  25,  24,  22,  21,  20,  19,  18,  18,  18,  18,  18 },
			{  73,  73,  73,  73,  73,  72,  71,  70,  69,  67,  66,  65,  63,  61,  59,  57,  55,  53,  50,  48,  45,  42,  40,  37,  35,  33,  31,  29,  27,  25,  24,  22,  21,  20,  19,  18,  17,  17,  17,  17,  17 },
			{  74,  74,  74,  74,  74,  73,  72,  71,  70,  69,  67,  66,  64,  62,  60,  58,  56,  53,  51,  48,  45,  42,  39,  37,  34,  32,  30,  28,  26,  24,  22,  21,  20,  19,  18,  17,  16,  16,  16,  16,  16 },
			{  75,  75,  75,  75,  75,  75,  74,  73,  72,  70,  69,  67,  66,  64,  62,  60,  57,  54,  51,  48,  45,  42,  39,  36,  33,  30,  28,  26,  24,  22,  21,  20,  18,  17,  16,  15,  15,  15,  15,  15,  15 },
			{  77,  77,  77,  77,  77,  76,  75,  74,  73,  72,  71,  69,  67,  66,  63,  61,  58,  55,  52,  49,  45,  41,  38,  35,  32,  29,  27,  24,  22,  21,  19,  18,  17,  16,  15,  14,  13,  13,  13,  13,  13 },
			{  78,  78,  78,  78,  78,  77,  77,  76,  75,  74,  73,  71,  69,  67,  65,  63,  60,  57,  53,  49,  45,  41,  37,  33,  30,  27,  25,  22,  21,  19,  17,  16,  15,  14,  13,  13,  12,  12,  12,  12,  12 },
			{  80,  80,  80,  80,  80,  79,  78,  78,  77,  76,  75,  73,  72,  70,  67,  65,  62,  58,  54,  50,  45,  40,  36,  32,  28,  25,  22,  20,  18,  17,  15,  14,  13,  12,  12,  11,  10,  10,  10,  10,  10 },
			{  81,  81,  81,  81,  81,  81,  80,  79,  79,  78,  77,  75,  74,  72,  70,  67,  64,  60,  56,  51,  45,  39,  34,  30,  26,  22,  20,  18,  16,  15,  13,  12,  11,  11,  10,   9,   9,   9,   9,   9,   9 },
			{  83,  83,  83,  83,  83,  83,  82,  81,  81,  80,  79,  78,  77,  75,  73,  71,  67,  63,  58,  52,  45,  38,  32,  27,  22,  19,  17,  15,  13,  12,  11,  10,   9,   9,   8,   7,   7,   7,   7,   7,   7 },
			{  85,  85,  85,  85,  85,  84,  84,  84,  83,  82,  82,  81,  80,  78,  77,  75,  72,  67,  62,  54,  45,  36,  28,  22,  18,  15,  13,  12,  10,   9,   8,   8,   7,   6,   6,   6,   5,   5,   5,   5,   5 },
			{  86,  86,  86,  86,  86,  86,  86,  86,  85,  85,  84,  84,  83,  82,  81,  79,  77,  73,  67,  58,  45,  32,  22,  17,  13,  11,   9,   8,   7,   6,   6,   5,   5,   4,   4,   4,   4,   4,   4,   4,   3 },
			{  87,  88,  88,  88,  88,  88,  88,  88,  88,  87,  87,  87,  86,  86,  85,  84,  83,  81,  77,  67,  45,  22,  13,   9,   7,   6,   5,   4,   4,   3,   3,   3,   2,   2,   2,   2,   2,   2,   2,   2,   1 },
			{  90,  90,  90,  90,  90,  90,  90,  90,  90,  90,  90,  90,  90,  90,  90,  90,  90,  90,  90,  90, 255,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0 },
			{  91,  92,  92,  92,  92,  92,  92,  92,  92,  93,  93,  93,  94,  94,  95,  96,  97,  99, 103, 113, 135, 158, 167, 171, 173, 174, 175, 176, 176, 177, 177, 177, 178, 178, 178, 178, 178, 178, 178, 178, 179 },
			{  94,  94,  94,  94,  94,  94,  94,  94,  95,  95,  96,  96,  97,  98,  99, 101, 103, 107, 113, 122, 135, 148, 158, 163, 167, 169, 171, 172, 173, 174, 174, 175, 175, 176, 176, 176, 176, 176, 176, 176, 177 },
			{  95,  95,  95,  95,  95,  96,  96,  96,  97,  98,  98,  99, 100, 102, 103, 105, 108, 113, 118, 126, 135, 144, 152, 158, 162, 165, 167, 168, 170, 171, 172, 172, 173, 174, 174, 174, 175, 175, 175, 175, 175 },
			{  97,  97,  97,  97,  97,  97,  98,  99,  99, 100, 101, 102, 103, 105, 107, 109, 113, 117, 122, 128, 135, 142, 148, 153, 158, 161, 163, 165, 167, 168, 169, 170, 171, 171, 172, 173, 173, 173, 173, 173, 173 },
			{  99,  99,  99,  99,  99,  99, 100, 101, 101, 102, 103, 105, 106, 108, 110, 113, 116, 120, 124, 129, 135, 141, 146, 150, 154, 158, 160, 162, 164, 165, 167, 168, 169, 169, 170, 171, 171, 171, 171, 171, 171 },
			{ 100, 100, 100, 100, 100, 101, 102, 102, 103, 104, 105, 107, 108, 110, 113, 115, 118, 122, 126, 130, 135, 140, 144, 148, 152, 155, 158, 160, 162, 163, 165, 166, 167, 168, 168, 169, 170, 170, 170, 170, 170 },
			{ 102, 102, 102, 102, 102, 103, 103, 104, 105, 106, 107, 109, 111, 113, 115, 117, 120, 123, 127, 131, 135, 139, 143, 147, 150, 153, 155, 158, 159, 161, 163, 164, 165, 166, 167, 167, 168, 168, 168, 168, 168 },
			{ 103, 103, 103, 103, 103, 104, 105, 106, 107, 108, 109, 111, 113, 114, 117, 119, 122, 125, 128, 131, 135, 139, 142, 145, 148, 151, 153, 156, 158, 159, 161, 162, 163, 164, 165, 166, 167, 167, 167, 167, 167 },
			{ 105, 105, 105, 105, 105, 105, 106, 107, 108, 110, 111, 113, 114, 116, 118, 120, 123, 126, 129, 132, 135, 138, 141, 144, 147, 150, 152, 154, 156, 158, 159, 160, 162, 163, 164, 165, 165, 165, 165, 165, 165 },
			{ 106, 106, 106, 106, 106, 107, 108, 109, 110, 111, 113, 114, 116, 118, 120, 122, 124, 127, 129, 132, 135, 138, 141, 143, 146, 148, 150, 152, 154, 156, 158, 159, 160, 161, 162, 163, 164, 164, 164, 164, 164 },
			{ 107, 107, 107, 107, 107, 108, 109, 110, 111, 113, 114, 115, 117, 119, 121, 123, 125, 127, 130, 132, 135, 138, 140, 143, 145, 147, 149, 151, 153, 155, 156, 158, 159, 160, 161, 162, 163, 163, 163, 163, 163 },
			{ 108, 108, 108, 108, 108, 109, 110, 111, 113, 114, 115, 117, 118, 120, 122, 124, 126, 128, 130, 133, 135, 137, 140, 142, 144, 146, 148, 150, 152, 153, 155, 156, 158, 159, 160, 161, 162, 162, 162, 162, 162 },
			{ 110, 110, 110, 110, 110, 110, 111, 113, 114, 115, 116, 118, 119, 121, 123, 124, 126, 129, 131, 133, 135, 137, 139, 141, 144, 146, 147, 149, 151, 152, 154, 155, 156, 158, 159, 160, 160, 160, 160, 160, 160 },
			{ 111, 111, 111, 111, 111, 112, 113, 114, 115, 116, 117, 119, 120, 122, 123, 125, 127, 129, 131, 133, 135, 137, 139, 141, 143, 145, 147, 148, 150, 151, 153, 154, 155, 156, 158, 159, 159, 159, 159, 159, 159 },
			{ 112, 112, 112, 112, 112, 113, 114, 115, 116, 117, 118, 120, 121, 122, 124, 126, 128, 129, 131, 133, 135, 137, 139, 141, 142, 144, 146, 148, 149, 150, 152, 153, 154, 155, 157, 158, 159, 159, 159, 159, 159 },
			{ 112, 112, 112, 112, 113, 114, 114, 115, 117, 118, 119, 120, 122, 123, 125, 126, 128, 130, 131, 133, 135, 137, 139, 140, 142, 144, 145, 147, 148, 150, 151, 152, 153, 155, 156, 157, 158, 159, 159, 159, 159 },
			{ 112, 112, 112, 113, 113, 114, 114, 115, 117, 118, 119, 120, 122, 123, 125, 126, 128, 130, 131, 133, 135, 137, 139, 140, 142, 144, 145, 147, 148, 150, 151, 152, 153, 155, 156, 157, 158, 158, 158, 158, 158 },
			{ 112, 112, 113, 114, 114, 114, 114, 115, 117, 118, 119, 120, 122, 123, 125, 126, 128, 130, 131, 133, 135, 137, 139, 140, 142, 144, 145, 147, 148, 150, 151, 152, 153, 155, 156, 157, 158, 158, 158, 158, 158 },
			{ 112, 113, 114, 114, 114, 114, 114, 115, 117, 118, 119, 120, 122, 123, 125, 126, 128, 130, 131, 133, 135, 137, 139, 140, 142, 144, 145, 147, 148, 150, 151, 152, 153, 155, 156, 157, 158, 158, 158, 158, 158 },
			{ 113, 114, 114, 114, 114, 114, 114, 115, 117, 118, 119, 120, 122, 123, 125, 126, 128, 130, 130, 132, 135, 136, 138, 140, 142, 144, 145, 147, 148, 150, 151, 152, 153, 155, 156, 157, 158, 158, 158, 158, 158 }

		};
	Object get_mon_num_hook;
	Object mon_select;
	int object_level = 0;
	int rating = 0;
	boolean good_item_flag = false;
	int old_turn = 0;
	boolean panel_extra_rows;
	String v_text;
	int feeling;
	boolean auto_scum;
	boolean adult_preserve;	
	player_type p_ptr = new player_type();
	private boolean view_perma_grids;
	private int daytime;
	
	public Statics() {
		for (int i = 0; i < v_info.length; i++) v_info[i] = new vault_type();
	}
	
	public int ABS(int a) {
		return Math.abs(a);
	}
	
	public boolean strchr(char[] l, char ch) {
		return new String(l).indexOf(ch) >= 0;
	}
	
	public int strchrpos(char[] l, char ch) {
		return new String(l).indexOf(ch);
	}
	
	public void strcpy(StringBuffer buf, String s) {
		buf.setLength(0);
		buf.append(s);
	}
	
	public void strcpy(char[] buf, String s) {
		char[] ch = s.toCharArray();
		System.arraycopy(ch, 0, buf, 0, ch.length); 
	}	
	
	int randint(int M) {
		return (rand_int(M) + 1);
	}
	
	int rand_int(int v) {
		return v > 0 ? random.nextInt(v) : 0;
	}
	
	int rand_range(int A, int B) {
		return ((A) + (rand_int(1+(B)-(A))));
	}
	
	int rand_spread(int A, int D) {
		return ((A) + (rand_int(1+(D)+(D))) - (D));
	}
	
	private static final int RANDNOR_NUM	= 256;
	private static final int RANDNOR_STD	= 64;
	
	int Rand_normal_table[] = {
	 	206,     613,    1022,    1430,		1838,	 2245,	  2652,	   3058,
	 	3463,    3867,    4271,    4673,	5075,	 5475,	  5874,	   6271,
	 	6667,    7061,    7454,    7845,	8234,	 8621,	  9006,	   9389,
	 	9770,   10148,   10524,   10898,   11269,	11638,	 12004,	  12367,
	 	12727,   13085,   13440,   13792,   14140,	14486,	 14828,	  15168,
	 	15504,   15836,   16166,   16492,   16814,	17133,	 17449,	  17761,
	 	18069,   18374,   18675,   18972,   19266,	19556,	 19842,	  20124,
	 	20403,   20678,   20949,   21216,   21479,	21738,	 21994,	  22245,

	 	22493,   22737,   22977,   23213,   23446,	23674,	 23899,	  24120,
	 	24336,   24550,   24759,   24965,   25166,	25365,	 25559,	  25750,
	 	25937,   26120,   26300,   26476,   26649,	26818,	 26983,	  27146,
	 	27304,   27460,   27612,   27760,   27906,	28048,	 28187,	  28323,
	 	28455,   28585,   28711,   28835,   28955,	29073,	 29188,	  29299,
	 	29409,   29515,   29619,   29720,   29818,	29914,	 30007,	  30098,
	 	30186,   30272,   30356,   30437,   30516,	30593,	 30668,	  30740,
	 	30810,   30879,   30945,   31010,   31072,	31133,	 31192,	  31249,

	 	31304,   31358,   31410,   31460,   31509,	31556,	 31601,	  31646,
	 	31688,   31730,   31770,   31808,   31846,	31882,	 31917,	  31950,
	 	31983,   32014,   32044,   32074,   32102,	32129,	 32155,	  32180,
	 	32205,   32228,   32251,   32273,   32294,	32314,	 32333,	  32352,
	 	32370,   32387,   32404,   32420,   32435,	32450,	 32464,	  32477,
	 	32490,   32503,   32515,   32526,   32537,	32548,	 32558,	  32568,
	 	32577,   32586,   32595,   32603,   32611,	32618,	 32625,	  32632,
	 	32639,   32645,   32651,   32657,   32662,	32667,	 32672,	  32677,

	 	32682,   32686,   32690,   32694,   32698,	32702,	 32705,	  32708,
	 	32711,   32714,   32717,   32720,   32722,	32725,	 32727,	  32729,
	 	32731,   32733,   32735,   32737,   32739,	32740,	 32742,	  32743,
	 	32745,   32746,   32747,   32748,   32749,	32750,	 32751,	  32752,
	 	32753,   32754,   32755,   32756,   32757,	32757,	 32758,	  32758,
	 	32759,   32760,   32760,   32761,   32761,	32761,	 32762,	  32762,
	 	32763,   32763,   32763,   32764,   32764,	32764,	 32764,	  32765,
	 	32765,   32765,   32765,   32766,   32766,	32766,	 32766,	  32767,
	 };
	
	int Rand_normal(int mean, int stand)
	{
		int tmp;
		int offset;

		int low = 0;
		int high = RANDNOR_NUM;

		/* Paranoia */
		if (stand < 1) return (mean);

		/* Roll for probability */
		tmp = (short) rand_int(32768);

		/* Binary Search */
		while (low < high)
		{
			int mid = (low + high) >> 1;

			/* Move right if forced */
			if (Rand_normal_table[mid] < tmp)
			{
				low = mid + 1;
			}

			/* Move left otherwise */
			else
			{
				high = mid;
			}
		}

		/* Convert the index into an offset */
		offset = (int) ((long)stand * (long)low / RANDNOR_STD);

		/* One half should be negative */
		if (rand_int(100) < 50) return (mean - offset);

		/* One half should be positive */
		return (mean + offset);
	}

	
	boolean isalpha(char[] s) {
		for (int i = 0; i < s.length; i++) {
			if (((s[i] >= 'a') && (s[i] <= 'z')) ||
				((s[i] >= 'A') && (s[i] <= 'Z'))) {				
			} else {
				return false;
			}
		}
		return true;
	}
	
	void Term_get_size(int[] x, int[] y) {
		x[0] = DUNGEON_WID;
		y[0] = DUNGEON_HGT;
	}	
	
	public void Term_fresh() {		
	}
	
	boolean streq(StringBuffer a, String b) {
		return a.toString().equals(b);
	}
	
	boolean in_bounds(int Y, int X) {
		return (X >= 0) && (Y >= 0) && (((Y) < (DUNGEON_HGT)) && ((X) < (DUNGEON_WID)));
	}
	
	boolean in_bounds_fully(int Y, int X) {
		return (((Y) > 0) && ((Y) < DUNGEON_HGT-1) &&
				((X) > 0) && ((X) < DUNGEON_WID-1));
	}
	
	void cave_set_feat(int y, int x, int feat) {	
		/* Change the feature */
		cave_feat[y][x] = feat;

		/* Handle "wall/door" grids.  Trees are also considered walls. */
		if (((feat >= FEAT_DOOR_HEAD) && (feat < FEAT_SHOP_HEAD)) || (feat == FEAT_TREE))
		{
			cave_info[y][x] |= (CAVE_WALL);
		}

		/* Handle "floor"/etc grids */
		else
		{
			cave_info[y][x] &= ~(CAVE_WALL);
		}

		/* Notice/Redraw */
		if (character_dungeon)
		{
			/* Notice */
			note_spot(y, x);

			/* Redraw */
			lite_spot(y, x);
		}
	}
	
	boolean cave_exist_mon(monster_race r_ptr, int y, int x, boolean occupied_ok) {
		int feat;

		/* Check Bounds */
		if (!in_bounds(y, x)) return (FALSE);

		/* Check location */
		feat = cave_feat[y][x];

		/* The grid is already occupied. */
		if (cave_m_idx[y][x] != 0)
		{
			if (!occupied_ok) return (FALSE);
		}

		/*** Check passability of various features. ***/

		/* Feature is not a wall */
		if ((cave_info[y][x] & (CAVE_WALL)) == 0)
		{
			/* Floor -- safe for everything */
			if (feat == FEAT_FLOOR) return (TRUE);

			/* Earthbound demons, firebreathers, and red elementals cannot handle water */
			if (feat == FEAT_WATER)
			{
				if ((r_ptr.flags2 & (RF2_FLYING)) != 0) return (TRUE);

				if ((r_ptr.flags4 & (RF4_BRTH_FIRE)) != 0 ||
				    (strchr("uU".toCharArray(), r_ptr.d_char)) ||
				   ((strchr("E".toCharArray(), r_ptr.d_char)) &&
				   ((r_ptr.d_attr == TERM_RED) || (r_ptr.d_attr == TERM_L_RED))))
				{
					return (FALSE);
				}

				else return (TRUE);
			}


			/* Only fiery or strong flying creatures can handle lava */
			if (feat == FEAT_LAVA)
			{
				if ((r_ptr.flags3 & (RF3_IM_FIRE))  != 0) return (TRUE);
				else if ((r_ptr.flags2 & (RF2_FLYING))  != 0)
				{
					/* Get HPs */
					int hp = (((r_ptr.flags1 & (RF1_FORCE_MAXHP))  != 0) ?
					    (r_ptr.hdice * r_ptr.hside) :
					    (r_ptr.hdice * (r_ptr.hside + 1) / 2));

					/* Only strong monsters */
					if (hp > 49) return (TRUE);
				}

				return (FALSE);
			}

			/* Glyphs -- must break first */
			if (feat == FEAT_GLYPH) return (FALSE);

			/* Anything else that's not a wall we assume to be legal. */
			else return (TRUE);
		}


		/* Feature is a wall */
		else
		{
			/* Rubble is always OK */
			if (feat == FEAT_RUBBLE) return (TRUE);

			/* Trees are always OK */
			if (feat == FEAT_TREE) return (TRUE);

			/* Permanent walls are never OK */
			if ((feat >= FEAT_PERM_EXTRA) && (feat <= FEAT_PERM_SOLID))
				return (FALSE);

			/* Otherwise, test by the monster's ability to live in walls. */
			if (((r_ptr.flags2 & (RF2_PASS_WALL))  != 0) ||
			    ((r_ptr.flags2 & (RF2_KILL_WALL))  != 0)) return (TRUE);

			else return (FALSE);
		}
	}
	

	boolean cave_naked_bold(int Y, int X) {
		return ((cave_feat[Y][X] == FEAT_FLOOR) && 
				 (cave_o_idx[Y][X] == 0) && 
				 (cave_m_idx[Y][X] == 0));
	}
	
	boolean cave_floor_bold(int Y, int X) {
		return ((cave_info[Y][X] & (CAVE_WALL)) == 0);		
	}
	
	boolean cave_empty_bold(int Y, int X) {
		return (cave_floor_bold(Y,X) && 
				 (cave_m_idx[Y][X] == 0));
	}
	
	boolean cave_clean_bold(int Y, int X) {
		return ((cave_feat[Y][X] == FEAT_FLOOR) && 
				 (cave_o_idx[Y][X] == 0));
	}
	
	boolean cave_perma_bold(int Y, int X) {
		return ((cave_feat[Y][X] >= FEAT_PERM_EXTRA) || 
			 ((cave_feat[Y][X] == FEAT_LESS) || 
			  (cave_feat[Y][X] == FEAT_MORE)) || 
			 ((cave_feat[Y][X] >= FEAT_SHOP_HEAD) && 
			  (cave_feat[Y][X] <= FEAT_SHOP_TAIL)));
	}
	
	boolean cave_valid_bold(int y, int x) {
		int this_o_idx, next_o_idx = 0;

		/* Forbid perma-grids */
		if (cave_perma_bold(y, x)) return (false);

		/* Check objects */
		for (this_o_idx = cave_o_idx[y][x]; this_o_idx != 0; this_o_idx = next_o_idx)
		{
			object_type o_ptr;

			/* Acquire object */
			o_ptr = o_list[this_o_idx];

			/* Acquire next object */
			next_o_idx = o_ptr.next_o_idx;

			/* Forbid artifact grids */
			if (artifact_p(o_ptr)) return (false);
		}

		/* Accept */
		return (true);
	}	
	
	int distance(int y1, int x1, int y2, int x2) {
		int ay, ax;

		/* Find the absolute y/x distance components */
		ay = (y1 > y2) ? (y1 - y2) : (y2 - y1);
		ax = (x1 > x2) ? (x1 - x2) : (x2 - x1);

		/* Hack -- approximate the distance */
		return ((ay > ax) ? (ay + (ax>>1)) : (ax + (ay>>1)));
	}	

	boolean artifact_p(object_type T) {
		return T.name1 != 0 ? true : false;
	}
		
	void place_gold(int y, int x) {		
		object_type i_ptr;
		object_type object_type_body = new object_type();

		/* Paranoia */
		if (!in_bounds(y, x)) return;

		/* Require clean floor space */
		if (!cave_clean_bold(y, x)) return;

		/* Get local object */
		i_ptr = object_type_body;

		/* Wipe the object */
		object_wipe(i_ptr);

		/* Make some gold */
		if (make_gold(i_ptr))
		{
			/* Give it to the floor */
			floor_carry(y, x, i_ptr);
		}
	}

	void place_trap(int y, int x) {
		/* Paranoia */
		if (!in_bounds(y, x)) return;

		/* Require empty, clean, floor grid */
		if (!cave_naked_bold(y, x)) return;

		/* Place an invisible trap */
		cave_set_feat(y, x, FEAT_INVIS);
	}
	

	int player_place(int y, int x) {		
		/* Paranoia XXX XXX */
		if (cave_m_idx[y][x] != 0) return (0);


		/* Save player location */
		p_ptr.py = y;
		p_ptr.px = x;

		/* Mark cave grid */
		cave_m_idx[y][x] = -1;

		/* Success */
		return (-1);
	}
	
	void place_random_door(int x, int y) {		
		int tmp;

		/* Choose an object */
		tmp = rand_int(1000);

		/* Open doors (300/1000) */
		if (tmp < 300)
		{
			/* Create open door */
			cave_set_feat(y, x, FEAT_OPEN);
		}

		/* Broken doors (100/1000) */
		else if (tmp < 400)
		{
			/* Create broken door */
			cave_set_feat(y, x, FEAT_BROKEN);
		}

		/* Secret doors (200/1000) */
		else if (tmp < 600)
		{
			/* Create secret door */
			cave_set_feat(y, x, FEAT_SECRET);
		}

		/* Closed, locked, or stuck doors (400/1000) */
		else
		{
			/* Create closed door */
			place_closed_door(y, x);
		}
	}
		
	private void place_closed_door(int y, int x) {
		int tmp;

		/* Choose an object */
		tmp = rand_int(400);

		/* Closed doors (300/400) */
		if (tmp < 300)
		{
			/* Create closed door */
			cave_set_feat(y, x, FEAT_DOOR_HEAD + 0x00);
		}

		/* Locked doors (99/400) */
		else if (tmp < 399)
		{
			/* Create locked door */
			cave_set_feat(y, x, FEAT_DOOR_HEAD + randint(7));
		}

		/* Stuck doors (1/400) */
		else
		{
			/* Create jammed door */
			cave_set_feat(y, x, FEAT_DOOR_HEAD + 0x08 + rand_int(8));
		}
	}

	boolean is_quest(int v) {
		int i;

		/* Town is never a quest */
		if (level == 0) return (FALSE);

		/* Check quests */
		for (i = 0; i < MAX_Q_IDX; i++)
		{
			/* Check for quest */
			if (q_list[i].level == level) return (TRUE);
		}

		/* Nope */
		return (FALSE);

	}
	
	void town_illuminate(boolean day) {
		int y, x, i;


		/* Apply light or darkness */
		for (y = 0; y < DUNGEON_HGT; y++)
		{
			for (x = 0; x < DUNGEON_WID; x++)
			{
				/* Grids "outside" the town walls */
				if (cave_feat[y][x] == FEAT_PERM_SOLID) {

					/* Darken the grid */
					cave_info[y][x] &= ~(CAVE_GLOW);

					/* Hack -- Forget grids */
					if (view_perma_grids)
					{
						cave_info[y][x] &= ~(CAVE_MARK);
					}
				}

				/* Interesting grids */
				else if (cave_feat[y][x] > FEAT_INVIS)
				{
					/* Illuminate the grid */
					cave_info[y][x] |= (CAVE_GLOW);

					/* Memorize the grid */
					cave_info[y][x] |= (CAVE_MARK);
				}

				/* Boring grids (light) */
				else if (daytime != 0)
				{
					/* Illuminate the grid */
					cave_info[y][x] |= (CAVE_GLOW);

					/* Hack -- Memorize grids */
					if (view_perma_grids)
					{
						cave_info[y][x] |= (CAVE_MARK);
					}
				}

				/* Boring grids (dark) */
				else
				{
					/* Darken the grid */
					cave_info[y][x] &= ~(CAVE_GLOW);

					/* Hack -- Forget grids */
					if (view_perma_grids)
					{
						cave_info[y][x] &= ~(CAVE_MARK);
					}
				}
			}
		}


		/* Handle shop doorways */
		for (y = 0; y < DUNGEON_HGT; y++)
		{
			for (x = 0; x < DUNGEON_WID; x++)
			{
				/* Track shop doorways */
				if ((cave_feat[y][x] >= FEAT_SHOP_HEAD) &&
				    (cave_feat[y][x] <= FEAT_SHOP_TAIL))
				{
					for (i = 0; i < 8; i++)
					{
						int yy = y + ddy_ddd[i];
						int xx = x + ddx_ddd[i];

						/* Illuminate the grid */
						cave_info[yy][xx] |= (CAVE_GLOW);

						/* Hack -- Memorize grids */
						if (view_perma_grids)
						{
							cave_info[yy][xx] |= (CAVE_MARK);
						}
					}
				}
			}
		}


		/* Fully update the visuals */
		p_ptr.update |= (PU_FORGET_VIEW | PU_UPDATE_VIEW | PU_MONSTERS);

		/* Redraw map */
		p_ptr.redraw |= (PR_MAP);

		/* Window stuff */
		p_ptr.window |= (PW_OVERHEAD);		
	}
	
	
	void place_object(int y, int x, boolean good, boolean great, boolean exact_kind)
	{
		object_type i_ptr;
		object_type object_type_body = new object_type();

		/* Paranoia */
		if (!in_bounds(y, x)) return;

		/* Hack -- require clean floor space */
		if (!cave_clean_bold(y, x)) return;

		/* Get local object */
		i_ptr = object_type_body;

		/* Wipe the object */
		object_wipe(i_ptr);

		/* Make an object */
		if (make_object(i_ptr, good, great, exact_kind))
		{
			/* Give it to the floor */
			if (floor_carry(y, x, i_ptr) == 0)
			{
				/* Hack -- Preserve artifacts */
				a_info[i_ptr.name1].creat_stat = 0;
			}
		}

	}
	
	private boolean make_object(object_type i_ptr, boolean good, boolean great, boolean exact_kind) {
		return false;
	}

	void place_monster(int y, int x, boolean a, boolean b, boolean c) {		
	}
	
	void place_monster_aux(int y, int x, int a, boolean b, boolean c) {		
	}	
	
	
	private int floor_carry(int y, int x, object_type i_ptr) {
		return 0;
	}

	private void object_wipe(object_type i_ptr) {
	}

	private boolean make_gold(object_type i_ptr) {
		return false;
	}

	void alloc_monster(int a, boolean b, boolean c) {
		
	}
	

	
	void delete_monster(int y, int x) {		
	}
	
	void delete_object(int y, int x) {		
	}
	
	int get_mon_num(int a) {
		return 0;
	}
	
	void get_mon_num_prep() {		
	}
	
	int get_mon_num_quick(int a) {
		return 0;
	}
	
	void place_secret_door(int y, int x) {
		
	}
	
	void msg_print(String s) {
		System.out.println(s);
	}
	
	
	boolean strstr(String s, String part) {
		return s.indexOf(part) >= 0;
	}
	
	void kill_t_info() {		
	}
	
	void verify_panel() {
		
	}
	
	void wipe_m_list() {		
	}	
	
	void wipe_o_list() {		
	}
	
	


	private void lite_spot(int y, int x) {
	}
	
	private void note_spot(int y, int x) {
	}
	
	boolean init_t_info(int c) {
		return false;
	}
	
}
