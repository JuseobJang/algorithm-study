package Baekjoon.LongestIncreasingSequence.BOJ11053;

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
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];

        String[] input = br.readLine().split(" ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }
        Arrays.fill(dp, 1);

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = (dp[j] + 1 > dp[i] && arr[j] < arr[i]) ? dp[j] + 1 : dp[i];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int num : dp) {
            max = Math.max(max, num);
        }

        bw.write(Integer.toString(max));
        bw.flush();

        br.close();
        bw.close();
    }
}
