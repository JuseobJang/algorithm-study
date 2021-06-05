package Baekjoon.Simulation.BOJ15683;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<CCTV> list;;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[][][] dir3 = { { { 1, 0 }, { 0, 1 } }, { { -1, 0 }, { 0, 1 } }, { { -1, 0 }, { 0, -1 } },
            { { 1, 0 }, { 0, -1 } } };

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        list = new ArrayList<CCTV>();

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 0) {
                    continue;
                } else if (map[i][j] == 6) {
                    visited[i][j] = true;
                } else {
                    list.add(new CCTV(map[i][j], i, j));
                    visited[i][j] = true;
                }
            }
        }
        dfs(0, visited);

        bw.write(Integer.toString(min));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int depth, boolean[][] visited) {
        if (depth == list.size()) {
            min = Math.min(min, noVisit(visited));
            return;
        } else {
            CCTV cctv = list.get(depth);
            int type = cctv.type;

            if (type == 1) {
                for (int i = 0; i < 4; i++) {
                    boolean[][] tmp = copyVisited(visited);
                    int curRow = cctv.row;
                    int curCol = cctv.col;
                    while (true) {
                        tmp[curRow][curCol] = true;
                        curRow += dir[i][0];
                        curCol += dir[i][1];
                        if (curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) {
                            break;
                        }
                        if (map[curRow][curCol] == 6) {
                            break;
                        }
                    }
                    dfs(depth + 1, tmp);
                }
            } else if (type == 2) {
                for (int i = 0; i < 4; i = i + 2) {
                    boolean[][] tmp = copyVisited(visited);
                    for (int j = 0; j < 2; j++) {
                        int curRow = cctv.row;
                        int curCol = cctv.col;
                        while (true) {
                            tmp[curRow][curCol] = true;
                            curRow += dir[(i + j)][0];
                            curCol += dir[(i + j)][1];
                            if (curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) {
                                break;
                            }
                            if (map[curRow][curCol] == 6) {
                                break;
                            }
                        }
                    }
                    dfs(depth + 1, tmp);
                }

            } else if (type == 3) {
                for (int i = 0; i < 4; i++) {
                    boolean[][] tmp = copyVisited(visited);
                    for (int j = 0; j < 2; j++) {
                        int curRow = cctv.row;
                        int curCol = cctv.col;
                        while (true) {
                            tmp[curRow][curCol] = true;
                            curRow += dir3[i][j][0];
                            curCol += dir3[i][j][1];
                            if (curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) {
                                break;
                            }
                            if (map[curRow][curCol] == 6) {
                                break;
                            }
                        }
                    }
                    dfs(depth + 1, tmp);
                }

            } else if (type == 4) {
                for (int i = 0; i < 4; i++) {
                    boolean[][] tmp = copyVisited(visited);
                    for (int j = 0; j < 3; j++) {
                        int curRow = cctv.row;
                        int curCol = cctv.col;
                        while (true) {
                            tmp[curRow][curCol] = true;
                            curRow += dir[(i + j) % 4][0];
                            curCol += dir[(i + j) % 4][1];
                            if (curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) {
                                break;
                            }
                            if (map[curRow][curCol] == 6) {
                                break;
                            }
                        }
                    }
                    dfs(depth + 1, tmp);
                }

            } else {
                boolean[][] tmp = copyVisited(visited);
                for (int j = 0; j < 4; j++) {
                    int curRow = cctv.row;
                    int curCol = cctv.col;
                    while (true) {
                        tmp[curRow][curCol] = true;
                        curRow += dir[j][0];
                        curCol += dir[j][1];
                        if (curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) {
                            break;
                        }
                        if (map[curRow][curCol] == 6) {
                            break;
                        }
                    }
                    dfs(depth + 1, tmp);
                }
            }
        }
    }

    private static boolean[][] copyVisited(boolean[][] visited) {
        boolean[][] ret = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret[i][j] = visited[i][j];
            }
        }
        return ret;
    }

    private static int noVisit(boolean[][] visited) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}

class CCTV {
    int type;
    int row;
    int col;

    public CCTV(int type, int row, int col) {
        this.type = type;
        this.row = row;
        this.col = col;
    }
}