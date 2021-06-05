package Baekjoon.DFSAndBFS.BOJ2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; // up , right , down , left
    static boolean[][] visited;

    static class pos {
        public int x;
        public int y;
        public int count;

        pos(int row, int col, int count) {
            this.x = row;
            this.y = col;
            this.count = count;
        }
    }

    static void bfs(int row, int col) {
        Queue<pos> q = new LinkedList<pos>();
        q.add(new pos(row, col, 1));
        while (!q.isEmpty()) {
            pos p = q.poll();
            if (p.x == N - 1 && p.y == M - 1) {
                System.out.println(p.count);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int new_row = p.x + dir[i][0];
                int new_col = p.y + dir[i][1];
                int cnt = p.count;
                if (new_row >= 0 && new_col >= 0 && new_row < N && new_col < M) {
                    if (map[new_row][new_col] == 1 && visited[new_row][new_col] == false) {
                        visited[new_row][new_col] = true;
                        q.add(new pos(new_row, new_col, cnt + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] input_map = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input_map[j]);
            }
        }
        bfs(0, 0);
        br.close();
    }
}