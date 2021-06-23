package Baekjoon.ShortestPath.BOJ1738;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static final int INF = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;
        input = br.readLine().split(" ");

        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        int[] dist = new int[v + 1];
        Edge[] edges = new Edge[e + 1];
        int[] path = new int[v + 1];

        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i <= e; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            edges[i] = new Edge(start, end, weight);
        }

        for (int i = 0; i < v - 1; i++) {
            for (int j = 1; j <= e; j++) {
                Edge cur = edges[j];
                if (dist[cur.getStart()] != INF && dist[cur.getEnd()] < dist[cur.getStart()] + cur.getWeight()) {
                    dist[cur.getEnd()] = dist[cur.getStart()] + cur.getWeight();
                    path[cur.getEnd()] = cur.getStart();
                }
            }
        }

        ArrayList<Integer> cycle = new ArrayList<Integer>();
        for (int j = 1; j <= e; j++) {
            Edge cur = edges[j];
            if (dist[cur.getStart()] != INF && dist[cur.getEnd()] < dist[cur.getStart()] + cur.getWeight()) {
                cycle.add(cur.getEnd());
            }
        }

        if (dist[v] == INF) {
            bw.write(-1 + "\n");
            bw.flush();
            return;
        }

        if (cycle.size() != 0) {
            boolean[] visited = bfs(cycle, v, edges, e);
            if (visited[v]) {
                bw.write("-1\n");
                bw.flush();
                br.close();
                bw.close();
                return;
            }
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();
        int end = v;
        ans.add(end);
        while (true) {
            end = path[end];
            ans.add(end);
            if (end == 1) {
                break;
            }
        }
        for (int i = ans.size(); i > 0; i--) {
            bw.write(ans.get(i - 1) + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean[] bfs(ArrayList<Integer> cycle, int v, Edge[] edges, int e) {
        boolean[] visited = new boolean[v + 1];
        for (int i = 0; i < cycle.size(); i++) {
            int start = cycle.get(i);
            if (visited[start]) {
                continue;
            }
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(start);
            while (!q.isEmpty()) {
                int cur = q.poll();
                visited[cur] = true;

                for (int j = 1; j <= e; j++) {
                    if (cur == edges[j].getStart() && !visited[edges[j].getEnd()]) {
                        q.add(edges[j].getEnd());
                    }
                }

            }
        }
        return visited;
    }
}

class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return end;
    }

    public Integer getWeight() {
        return this.weight;
    }
}


