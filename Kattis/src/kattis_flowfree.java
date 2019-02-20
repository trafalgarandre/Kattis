import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class kattis_flowfree {
	static Character[][] c;
	static boolean hasSolution;
	static Character[] t = {'R', 'G', 'B', 'Y'};
	public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        c = new Character[4][4];
        boolean hasFour = false;
        hasSolution = false;
        for (int i = 0; i < 4; i++) {
        	String s = reader.readLine();
        	for (int j = 0; j < 4; j++) {
        		c[i][j] = s.charAt(j);
        		if (c[i][j] == 'Y') {
        			hasFour = true;
        		}
        	}
        }
        if (hasFour) {
        	execute(0, 0, 4);
        } else {
        	execute(0, 0, 3);
        }
        System.out.println(hasSolution ? "solvable" : "not solvable");
	}
	
	public static void execute(int x, int y, int type) {
		if (x == 4) {
			boolean[] b = new boolean[type];
			boolean[][] b2 = new boolean[4][4];
			boolean isTrue = true;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (!b2[i][j]) {
						for (int k = 0; k < type; k++) {
							if (t[k] == c[i][j]) {
								if (b[k]) {
									isTrue = false;
								} else {
									Queue<Node> node = new LinkedList<Node>();
									node.add(new Node(i, j));
									b2[i][j] = true;
									b[k] = true;
									while (!node.isEmpty()) {
										Node cur = node.poll();
										if (cur.i > 0 && c[cur.i - 1][cur.j] == t[k] && !b2[cur.i - 1][cur.j]) {
											b2[cur.i - 1][cur.j] = true;
											node.add(new Node(cur.i - 1, cur.j));
										}
										if (cur.i < 3 && c[cur.i + 1][cur.j] == t[k] && !b2[cur.i + 1][cur.j]) {
											b2[cur.i + 1][cur.j] = true;
											node.add(new Node(cur.i + 1, cur.j));
										}
										if (cur.j > 0 && c[cur.i][cur.j - 1] == t[k] && !b2[cur.i][cur.j - 1]) {
											b2[cur.i][cur.j - 1] = true;
											node.add(new Node(cur.i, cur.j - 1));
										}
										if (cur.j < 3 && c[cur.i][cur.j + 1] == t[k] && !b2[cur.i][cur.j + 1]) {
											b2[cur.i][cur.j + 1] = true;
											node.add(new Node(cur.i, cur.j + 1));
										}
									}
									break;
								}
							}
						}
					}
				}
				if (isTrue) {
					hasSolution = true;
				}
			}
		} else {
			if (c[x][y] == 'W') {
				for (int i = 0; i < type; i++) {
					c[x][y] = 'R';
					if (y + 1 == 4) {
						execute(x + 1, 0, type);
					} else {
						execute(x, y + 1, type);
					}
					c[x][y] = 'W';
				}
			} else {
				if (y + 1 == 4) {
					execute(x + 1, 0, type);
				} else {
					execute(x, y + 1, type);
				}
			}
		}
	}
	
	static class Node {
		int i, j;
		Node (int _i, int _j) {
			i = _i;
			j = _j;
		}
	}
}
