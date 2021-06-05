package Baekjoon.ShortestPath.BOJ1916;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static int start;
    static int end;
    static int[] dist;
    static ArrayList<ArrayList<Node>> edges;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n];
        edges = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]) - 1;
            int e = Integer.parseInt(input[1]) - 1;
            int w = Integer.parseInt(input[2]);
            edges.get(s).add(new Node(e, w));
        }

        input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]) - 1;
        end = Integer.parseInt(input[1]) - 1;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        dijksrta();

        bw.write(Integer.toString(dist[end]));

        bw.flush();

        br.close();
        bw.close();
    }

    static void dijksrta() {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        boolean[] visited = new boolean[n];

        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            int cur = pq.poll().v;
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            for (Node next : edges.get(cur)) {
                if (dist[next.v] > dist[cur] + next.weight) {
                    dist[next.v] = dist[cur] + next.weight;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int v;
    int weight;

    public Node(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}