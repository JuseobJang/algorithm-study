package Baekjoon.MinimumSpanningTree.BOJ16398;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static int[] root;
    static PriorityQueue<Road> pq;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);

        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        pq = new PriorityQueue<Road>();

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = i + 1; j < n; j++) {
                int cost = Integer.parseInt(input[j]);
                pq.add(new Road(cost, i, j));
            }
        }

        long ans = 0;
        while (!pq.isEmpty()) {
            Road road = pq.poll();
            if (find(road.start) != find(road.end)) {
                merge(road.start, road.end);
                ans += road.cost;
            }
        }

        bw.write(Long.toString(ans));
        bw.flush();

        br.close();
        bw.close();
        return;
    }

    private static int find(int n) {
        if (root[n] == n)
            return n; // root[n] == n 이면 트리의 맨위 root 이다.
        else {
            return find(root[n]);
        }
    }

    private static void merge(int a, int b) {
        root[find(b)] = find(a);
    }
}

class Road implements Comparable<Road> {
    int cost;
    int start;
    int end;

    public Road(int cost, int start, int end) {
        this.cost = cost;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Road road) {
        if (this.cost > road.cost)
            return 1;
        else if (this.cost < road.cost)
            return -1;
        else {
            return 0;
        }
    }
}
