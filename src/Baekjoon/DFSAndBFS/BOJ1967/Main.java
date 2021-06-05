package Baekjoon.DFSAndBFS.BOJ1967;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static int v;
    static ArrayList<Pair>[] e;
    static boolean visited[];
    static int ans = Integer.MIN_VALUE;
    static int start;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;

        v = Integer.parseInt(br.readLine());
        e = new ArrayList[v];
        visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            e[i] = new ArrayList<Pair>();
        }

        for (int i = 0; i < v - 1; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]) - 1;
            int end = Integer.parseInt(input[1]) - 1;
            int weight = Integer.parseInt(input[2]);

            e[start].add(new Pair(end, weight));
            e[end].add(new Pair(start, weight));
        }

        dfs(0, 0);
        Arrays.fill(visited, false);
        dfs(start, 0);

        bw.write(Integer.toString(ans));
        bw.flush();

        br.close();
        bw.close();
    }

    static void dfs(int curV, int weight) {
        visited[curV] = true;

        for (Pair pair : e[curV]) {
            if (!visited[pair.node])
                dfs(pair.node, weight + pair.weight);
        }

        if (weight > ans) {
            start = curV;
            ans = weight;
        }
    }
}
