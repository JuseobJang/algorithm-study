package Baekjoon.DynamicProgramming.BOJ2156;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (n == 1) {
            System.out.println(arr[1]);
            return;
        }
        dp[1] = arr[1];
        dp[2] = dp[1] + arr[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max((dp[i - 2] + arr[i]), dp[i - 3] + arr[i - 1] + arr[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        System.out.println(dp[n]);
    }
}
