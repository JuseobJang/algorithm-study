package Baekjoon.DFSAndBFS.BOJ2206;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static int ans = Integer.MAX_VALUE;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[][] map;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;
        input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        ans = Math.min(ans, bfs());
        if (ans == Integer.MAX_VALUE) {
            bw.write(Integer.toString(-1));
        } else {
            bw.write(Integer.toString(ans));
        }
        bw.flush();

        br.close();
        bw.close();
    }

    static int bfs() {
        Queue<Info> q = new LinkedList<Info>();
        boolean[][][] visited = new boolean[n][m][2];
        q.add(new Info(0, 0, 1, true));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Info curPair = q.poll();
            int curRow = curPair.row;
            int curCol = curPair.col;
            int curCnt = curPair.cnt;
            boolean chance = curPair.chance;

            if (curRow == n - 1 && curCol == m - 1) {
                return curCnt;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dir[i][0];
                int nextCol = curCol + dir[i][1];
                int nextCnt = curCnt + 1;
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m)
                    continue;
                if (chance) {
                    if (map[nextRow][nextCol] == 1) {
                        if (visited[nextRow][nextCol][1] == true)
                            continue;
                        visited[nextRow][nextCol][1] = true;
                        q.add(new Info(nextRow, nextCol, nextCnt, !chance));

                    } else {
                        if (visited[nextRow][nextCol][0] == true)
                            continue;
                        visited[nextRow][nextCol][0] = true;
                        q.add(new Info(nextRow, nextCol, nextCnt, chance));
                    }

                } else {
                    if (visited[nextRow][nextCol][1] == true)
                        continue;
                    if (map[nextRow][nextCol] == 1)
                        continue;
                    visited[nextRow][nextCol][1] = true;
                    q.add(new Info(nextRow, nextCol, nextCnt, chance));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    static class Info {
        int row;
        int col;
        int cnt;
        boolean chance;

        public Info(int row, int col, int cnt, boolean chance) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.chance = chance;
        }
    }

}
