package Baekjoon.Sorting.BOJ2252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static int[] linkCnt;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        linkCnt = new int[n];
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]) - 1;
            int v2 = Integer.parseInt(input[1]) - 1;
            graph.get(v1).add(v2);
            linkCnt[v2]++;
        }
        topologicalSort();

        bw.flush();
        br.close();
        bw.close();
    }

    static void topologicalSort() throws IOException {
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (linkCnt[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if(visited[cur])
                continue;
            visited[cur] = true;
            bw.write(Integer.toString(cur+1) + " ");
            for (int next : graph.get(cur)) {
                if(--linkCnt[next] == 0){
                    q.add(next);
                }
            }
        }
    }
}