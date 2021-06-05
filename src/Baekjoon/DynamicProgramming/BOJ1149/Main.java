package Baekjoon.DynamicProgramming.BOJ1149;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[][] cost;
    static int[][] dp;
    static int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        String[] input;
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        cost = new int[n][3];
        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        for (int i = 0; i < 3; i++) {
            dp[0][i] = cost[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][j];
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][j];
                }
            }
        }
        int ans = INF;
        ans = Math.min(dp[n - 1][0], dp[n - 1][1]);
        ans = Math.min(ans, dp[n - 1][2]);
        bw.write(Integer.toString(ans));
        bw.flush();

        br.close();
        bw.close();
    }
}
