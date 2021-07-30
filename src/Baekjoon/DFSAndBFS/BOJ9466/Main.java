package Baekjoon.DFSAndBFS.BOJ9466;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < tc ; t ++) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[n];
            visited = new boolean[n];
            finished = new boolean[n];
            count = 0;

            String[] input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]) - 1;
            }

            for (int i = 0; i < n; i++) {
                if (!finished[i]) { dfs(i); }
            }
            bw.write(n-count + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int cur) {
        if (visited[cur]) {
            finished[cur] = true;
            count++;
        } else {
            visited[cur] = true;
        }

        int next = arr[cur];

        if (!finished[next]) {
            dfs(next);
        }

        visited[cur] = false;
        finished[cur] = true;
    }
}