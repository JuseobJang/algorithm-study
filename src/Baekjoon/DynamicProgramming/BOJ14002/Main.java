package Baekjoon.DynamicProgramming.BOJ14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int n;
    static int[] arr;
    static int[] dp;
    static Stack<Integer> stk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        stk = new Stack<Integer>();

        String input[] = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }
        for (int i = 1; i <= n; i++) {
            dp[i]++;
            for (int j = 1; j <= i; j++) {
                if (arr[j] < arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }

        int num = max;
        for (int i = n; i >= 1; i--) {
            if (num == dp[i]) {
                stk.push(arr[i]);
                num--;
            }
        }

        System.out.println(max);
        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
    }
}
