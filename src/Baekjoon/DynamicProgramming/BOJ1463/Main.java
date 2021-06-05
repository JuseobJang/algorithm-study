package Baekjoon.DynamicProgramming.BOJ1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br;
    public static int x;
    public static int[] dp = new int[1000001];

    public static void dyn(int num) {

    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        dp[0] = dp[1] = 0;
        dp[2] = dp[3] = 1;
        for (int i = 4; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[x]);
    }
}
