package Baekjoon.BruteForce.BOJ14500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int row;
    static int col;
    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;

    static void dfs(int depth, int sum, int x, int y) {

        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                continue;
            }

            if (!visited[newX][newY]) {
                visited[x][y] = true;
                dfs(depth + 1, sum + map[newX][newY], newX, newY);
                visited[newX][newY] = false;
            }
        }
    }

    static void convex(int x, int y) {
        if (x >= 0 && x + 1 < row && y >= 0 && y + 2 < col) {
            int sum = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 1];
            max = Math.max(max, sum);
        }

        if (x >= 0 && x + 2 < row && y >= 0 && y + 1 < col) {
            int sum = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1];
            max = Math.max(max, sum);
        }

        if (x - 1 >= 0 && x < row && y >= 0 && y + 2 < col) {
            int sum = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x - 1][y + 1];
            max = Math.max(max, sum);
        }

        if (x - 1 >= 0 && x + 1 < row && y >= 0 && y + 1 < col) {
            int sum = map[x][y] + map[x][y + 1] + map[x - 1][y + 1] + map[x + 1][y + 1];
            max = Math.max(max, sum);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);
        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] a = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(a[j]);
            }
        }

        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = true;
                dfs(1, map[i][j], i, j);
                visited[i][j] = false;

                convex(i, j);
            }
        }
        System.out.println(max);
    }
}
