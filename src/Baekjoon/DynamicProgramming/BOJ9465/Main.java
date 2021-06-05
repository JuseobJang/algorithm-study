package Baekjoon.DynamicProgramming.BOJ9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stk = new int[3][n + 1];
            int[][] dp = new int[3][n + 1];
            for (int i = 0; i < 2; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    stk[i + 1][j + 1] = Integer.parseInt(input[j]);
                }
            }
            dp[1][1] = stk[1][1];
            dp[2][1] = stk[2][1];
            for (int i = 2; i <= n; i++) {
                dp[1][i] = stk[1][i] + Math.max(dp[2][i - 1], dp[2][i - 2]);
                dp[2][i] = stk[2][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
            }
            System.out.println(Math.max(dp[1][n], dp[2][n]));
        }
    }
}
