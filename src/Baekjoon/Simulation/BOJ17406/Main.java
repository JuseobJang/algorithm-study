package Baekjoon.Simulation.BOJ17406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static int k;
    static int[][] arr;
    static int[][] rots;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        arr = new int[n][m];
        rots = new int[k][3];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            rots[i][0] = Integer.parseInt(input[0]) - 1;
            rots[i][1] = Integer.parseInt(input[1]) - 1;
            rots[i][2] = Integer.parseInt(input[2]);
        }

        boolean[] visited = new boolean[k];
        dfs(0, arr, visited);
        bw.write(Integer.toString(ans));

        bw.flush();

        br.close();
        bw.close();
    }

    static void dfs(int depth, int[][] array, boolean[] visited) {
        if (depth == k) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < m; j++) {
                    sum += array[i][j];
                }
                min = Math.min(min, sum);
            }
            ans = Math.min(min, ans);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, rotate(array, i), visited);
                visited[i] = false;
            }
        }
    }

    static int[][] rotate(int[][] array, int ind) {
        int[][] ret = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret[i][j] = array[i][j];
            }
        }

        int[] rot = rots[ind];
        int sRow = rot[0] - rot[2];
        int sCol = rot[1] - rot[2];
        int eRow = rot[0] + rot[2];
        int eCol = rot[1] + rot[2];

        for (int i = rot[2] * 2; i > 1; i -= 2, sRow++, sCol++, eRow--, eCol--) {
            int[] corner = new int[4];
            corner[0] = ret[sRow][sCol];
            corner[1] = ret[sRow][eCol];
            corner[2] = ret[eRow][eCol];
            corner[3] = ret[eRow][sCol];
            for (int j = 0; j < i - 1; j++) {
                ret[sRow][eCol - j] = ret[sRow][eCol - j - 1];
            }
            for (int j = 0; j < i - 1; j++) {
                ret[eRow - j][eCol] = ret[eRow - j - 1][eCol];
            }
            for (int j = 0; j < i - 1; j++) {
                ret[eRow][sCol + j] = ret[eRow][sCol + j + 1];
            }
            for (int j = 0; j < i - 1; j++) {
                ret[sRow + j][sCol] = ret[sRow + j + 1][sCol];
            }
            ret[sRow][sCol + 1] = corner[0];
            ret[sRow + 1][eCol] = corner[1];
            ret[eRow][eCol - 1] = corner[2];
            ret[eRow - 1][sCol] = corner[3];
        }
        return ret;
    }

}