package Baekjoon.BruteForceNandM.BOJ15664;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static int n;
    static int m;
    static int[] visited;
    static int[] arr;
    static int[] sol;
    static BufferedReader br;
    static BufferedWriter bw;

    static void dfs(int depth, int start) throws Exception {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(Integer.toString(sol[i]) + " ");
            }
            bw.newLine();
            return;
        }
        int before = 0;

        for (int i = start; i < n; i++) {
            if (visited[i] == 0 && (before != arr[i])) {
                sol[depth] = arr[i];
                before = arr[i];
                visited[i] = 1;
                dfs(depth + 1, i + 1);
                visited[i] = 0;

            }
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");

        visited = new int[n];
        arr = new int[n];
        sol = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(arr);

        dfs(0, 0);

        br.close();
        bw.flush();
        bw.close();
    }
}
