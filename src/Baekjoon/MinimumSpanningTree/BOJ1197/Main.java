package Baekjoon.MinimumSpanningTree.BOJ1197;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] root;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int node = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);

        root = new int[node + 1];
        for (int i = 0; i < node + 1; i++) {
            root[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        for (int i = 0; i < edge; i++) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            pq.add(new Edge(s, e, w));
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (find(cur.s) == find(cur.e)) {
                continue;
            } else {
                merge(cur.s, cur.e);
                sum += cur.w;
            }
        }
        bw.write(Integer.toString(sum));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int find(int n) {
        if (root[n] == n) {
            return n;
        } else {
            return find(root[n]);
        }
    }

    private static void merge(int a, int b) {
        root[find(b)] = find(a);
    }
}

class Edge implements Comparable<Edge> {
    int s;
    int e;
    int w;

    public Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.w > o.w) {
            return 1;
        } else if (this.w < o.w) {
            return -1;
        }
        return 0;
    }
}