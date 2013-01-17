package fil;

import java.io.*;
import java.util.*;

import def.Engine;

public class WorldFileHandler {

	public Random r = new Random();
	public File dir;
	public File world;
	public FileWriter fw;
	public Scanner s;

	public int[][] ID;
	public String ReadWorldName;

	public WorldFileHandler() {
		dir = new File("res");
		if (!dir.exists()) {
			dir.mkdir();
		}
		dir = new File("res/world");
		if (!dir.exists()) {
			dir.mkdir();
		}
		world = new File("res/world/map.thu");
		if (!world.exists()) {
			try {
				world.createNewFile();
				writeWorld();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			readWorld();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public int BlockAbove(int i, int j) {
		int k;
		if ((i != (0 | 127 | 128 | 129)) && (j != (0 | 127 | 128 | 129))) {
			if (j != 128) {
				k = ID[i - 1][j];
			} else {
				k = 0;
			}
		} else {
			k = 0;
		}

		return k;
	}

	public int BlockBelow(int i, int j) {
		int k;
		if ((i != (0 | 127 | 128 | 129)) && (j != (0 | 127 | 128 | 129))) {
			if (j < 511) {
				if (j != -1) {
					if (i != 127) {
						k = ID[i + 1][j];
					} else {
						k = 0;
					}
				} else {
					k = 0;
				}
			} else {
				k = 0;
			}
		} else {
			k = 0;
		}

		return k;
	}

	public int BlockLeft(int i, int j) {
		int k;
		if ((i != (0 | 127 | 128 | 129)) && (j != (0 | 127 | 128 | 129))) {
			if (i != 128) {
				k = ID[i][j - 1];
			} else {
				k = 0;
			}
		} else {
			k = 0;
		}

		return k;
	}

	public int BlockRight(int i, int j) {
		int k;
		if ((i != (0 | 127 | 128 | 129)) && (j != (0 | 127 | 128 | 129))) {
			if (i != 128) {
				k = ID[i][j + 1];
			} else {
				k = 0;
			}
		} else {
			k = 0;
		}

		return k;
	}

	public void writeWorld() throws IOException {
		ID = new int[128][512];
		fw = new FileWriter(world);
		fw.write("128 512\r\nworld\r\n");

		GenerateWorld();

		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < 512; j++) {
				fw.write(ID[i][j] + " ");
			}
			fw.write("\r\n");
		}

		fw.flush();
		fw.close();
	}

	public void GenerateWorld() {
		for (int i = ID.length - 1; i >= 0; i--) {
			for (int j = ID[i].length - 1; j >= 0; j--) {
				int t;
				if (i == 124) {
					t = r.nextInt(90);
					if (t <= 5) {
						ID[i][j] = 2;
					} else {
						ID[i][j] = 0;
					}
				} else if (i == 123) {
					if (BlockBelow(i, j) == 2) {
						ID[i][j] = 2;
					} else {
						ID[i][j] = 0;
					}
				} else if (i == 122) {
					if (BlockBelow(i, j + 1) == 2) {
						t = r.nextInt(4);
						if (t == 1) {
							ID[i][j] = 2;
						}
					} else if (BlockBelow(i, j) == 2) {
						ID[i][j] = 2;
					} else {
						ID[i][j] = 0;
					}
				} else if ((i <= 123) && (i >= 110)) {
					if (BlockBelow(i, j) == 2) {
						ID[i][j] = 2;
					} else if (BlockBelow(i, j + 1) == 2) {
						t = r.nextInt(32);
						if (t <= 3) {
							ID[i][j] = 2;
						}
					} else if (BlockBelow(i, j - 1) == 2) {
						t = r.nextInt(32);
						if (t <= 3) {
							ID[i][j] = 2;
						}
					} else {
						ID[i][j] = 0;
					}

				} else if ((i <= 109) && (i >= 80)) {
					if (BlockBelow(i, j) == 2) {
						ID[i][j] = 2;
					} else if (BlockBelow(i, j + 1) == 2) {
						t = r.nextInt(16);
						if (t <= 3) {
							ID[i][j] = 2;
						}
					} else if (BlockBelow(i, j - 1) == 2) {
						t = r.nextInt(16);
						if (t <= 3) {
							ID[i][j] = 2;
						}
					} else {
						ID[i][j] = 0;
					}
				} else if ((i <= 79) && (i >= 70)) {
					if (BlockBelow(i, j) == 2) {
						ID[i][j] = 1;
					} else if (BlockBelow(i, j + 1) == 2) {
						t = r.nextInt(8);
						if (t <= 3) {
							ID[i][j] = 1;
						}
					} else if (BlockBelow(i, j - 1) == 2) {
						t = r.nextInt(8);
						if (t <= 3) {
							ID[i][j] = 1;
						}
					} else if (BlockBelow(i, j) == 1) {
						ID[i][j] = 1;
					} else if (BlockBelow(i, j + 1) == 1) {
						t = r.nextInt(8);
						if (t <= 3) {
							ID[i][j] = 1;
						}
					} else if (BlockBelow(i, j - 1) == 1) {
						t = r.nextInt(8);
						if (t <= 3) {
							ID[i][j] = 1;
						}
					} else {
						ID[i][j] = 0;
					}
				} else if (i == 69) {
					t = r.nextInt(4);
					if (t != 1) {
						if (BlockBelow(i, j) != 0) {
							ID[i][j] = 1;
						}
					} else {
						ID[i][j] = 0;
					}
				} else if (i == 68) {
					if (BlockBelow(i, j) == 1) {
						t = r.nextInt(4);
						if (t != 1) {
							if (BlockBelow(i, j) != 0) {
								ID[i][j] = 1;
							}
						} else {
							ID[i][j] = 0;
						}
					} else {
						ID[i][j] = 0;
					}

				} else {
					ID[i][j] = 0;
				}
			}
		}
		generateObjects();
	}

	public void save() throws IOException {
		fw = new FileWriter(world);
		fw.write("128 512\r\nworld\r\n");
		for (int i = 0; i < Engine.mb.BLOCKS.length; i++) {
			for (int j = 0; j < Engine.mb.BLOCKS[i].length; j++) {
				fw.write(Engine.mb.BLOCKS[i][j].ID + " ");
			}
			fw.write("\r\n");
		}

		fw.flush();
		fw.close();
	}

	public void generateObjects() {
		for (int i = 4; i < ID.length - 5; i++) {
			for (int j = 7; j < ID[i].length - 8; j++) {
				int t = 0;
				if (i == 67) {
					if (BlockBelow(i, j) == 1) {
						if (BlockAbove(i, j) == 0) {
							t = r.nextInt(180);
							if (t <= 10) {
								if (BlockLeft(i - 1, j) != 3) {
									generateTree(i, j);
								}
							}
						}
					}
				}
			}
		}
	}

	public void generateTree(int i, int j) {
		int fi = i, fj = j;
		ID[fi][fj] = 3;
		ID[fi - 1][fj] = 3;
		ID[fi - 2][fj] = 3;
		ID[fi - 3][fj] = 3;
		ID[fi - 4][fj] = 3;
		ID[fi - 2][fj - 2] = 4;
		ID[fi - 2][fj - 1] = 4;
		ID[fi - 2][fj] = 4;
		ID[fi - 2][fj + 1] = 4;
		ID[fi - 2][fj + 2] = 4;
		ID[fi - 3][fj - 2] = 4;
		ID[fi - 3][fj - 1] = 4;
		ID[fi - 3][fj] = 4;
		ID[fi - 3][fj + 1] = 4;
		ID[fi - 3][fj + 2] = 4;
		ID[fi - 4][fj - 1] = 4;
		ID[fi - 4][fj] = 4;
		ID[fi - 4][fj + 1] = 4;
		ID[fi - 5][fj - 1] = 4;
		ID[fi - 5][fj] = 4;
		ID[fi - 5][fj + 1] = 4;
	}

	public void readWorld() throws FileNotFoundException {
		s = new Scanner(world);
		ID = new int[s.nextInt()][s.nextInt()];
		ReadWorldName = s.next();
		for (int i = 0; i < ID.length; i++) {
			for (int j = 0; j < ID[i].length; j++) {
				ID[i][j] = s.nextInt();
			}
		}

	}

}
