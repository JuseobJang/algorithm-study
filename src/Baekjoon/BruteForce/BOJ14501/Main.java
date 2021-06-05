package Baekjoon.BruteForce.BOJ14501;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] T;
    static int[] P;
    static int n;
    static int max = 0;

    static void bfs(int day, int pay) {
        if (day == n) {
            max = Math.max(max, pay);
            return;
        }
        if (day + T[day] - 1 < n) {
            bfs(day + T[day], pay + P[day]);
        }
        bfs(day + 1, pay);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        T = new int[n];
        P = new int[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }
        bfs(0, 0);
        System.out.println(max);
    }
}
