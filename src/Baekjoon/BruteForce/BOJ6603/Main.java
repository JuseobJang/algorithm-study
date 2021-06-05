package Baekjoon.BruteForce.BOJ6603;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] set;

    static void dfs(int depth, int[] arr, int[] visited, int cur) {
        if (depth == 5) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && set[cur] < set[i]) {
                // System.out.println(Arrays.toString(arr));

                arr[depth + 1] = set[i];
                visited[i] = 1;
                dfs(depth + 1, arr, visited, i);
                visited[i] = 0;

            }

        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("0")) {
                break;
            }
            n = Integer.parseInt(input[0]);
            set = new int[n];

            for (int i = 0; i < n; i++) {
                set[i] = Integer.parseInt(input[i + 1]);
            }
            Arrays.sort(set);

            for (int i = 0; i < n; i++) {
                int[] arr = new int[6];
                int[] visited = new int[n];
                arr[0] = set[i];
                visited[i] = 1;
                dfs(0, arr, visited, i);
            }
            System.out.println();
        }
    }

}
