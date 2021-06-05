package Baekjoon.DFSAndBFS.BOJ1167;

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
            input = br.readLine().split(" ");
            ArrayList<Pair> list = new ArrayList<Pair>();
            e[Integer.parseInt(input[0]) - 1] = list;
            for (int j = 1; j < input.length - 1; j = j + 2) {
                Pair pair = new Pair(Integer.parseInt(input[j]) - 1, Integer.parseInt(input[j + 1]));
                e[Integer.parseInt(input[0]) - 1].add(pair);
            }
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
