package Baekjoon.MinimumSpanningTree.BOJ1944;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static int[] root;
    static int[][] map;
    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static int[][] start;
    static int[][] info;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        root = new int[m + 1];
        map = new int[n][n];
        start = new int[m + 1][2];
        info = new int[m + 1][m + 1];
        pq = new PriorityQueue<Edge>();

        for (int i = 0, k = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (input[j].equals("0")) {
                    map[i][j] = 0;
                } else if (input[j].equals("1")) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 2;
                    start[k][0] = i;
                    start[k][1] = j;
                    k++;
                }
            }
        }
        for (int i = 0; i < m + 1; i++) {
            bfs(i, start[i][0], start[i][1]);
        }

        for (int i = 0; i < m + 1; i++) {
            for (int j = i + 1; j < m + 1; j++) {
                pq.add(new Edge(info[i][j], i, j));
            }
        }

        for (int i = 0; i < m + 1; i++) {
            root[i] = i;
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (edge.cost == 0) {
                continue;
            }
            if (find(edge.start) != find(edge.end)) {
                merge(edge.start, edge.end);
                ans += edge.cost;
            }
        }

        for (int i = 0; i < m + 1; i++) {
            if (find(0) != find(i)) {
                bw.write("-1");
                bw.flush();

                br.close();
                bw.close();
                return;
            }
        }
        
        bw.write(Integer.toString(ans));
        bw.flush();

        br.close();
        bw.close();
        return;

    }

    private static void bfs(int start, int row, int col) {
        int[][] visited = new int[n][n];
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(row, col, 0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.row][node.col] = 1;
            for (int i = 0; i < 4; i++) {
                int r = node.row + dir[i][0];
                int c = node.col + dir[i][1];
                int d = node.dis + 1;
                if (map[r][c] == 1) {
                    continue;
                } else if (map[r][c] == 0 && visited[r][c] == 0) {
                    visited[r][c] = 1;
                    q.add(new Node(r, c, d));
                } else if (map[r][c] == 2 && visited[r][c] == 0) {
                    int end = findNode(r, c);
                    visited[r][c] = 1;
                    q.add(new Node(r, c, d));

                    info[start][end] = d;
                }
            }
        }
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

    static int findNode(int row, int col) {
        for (int i = 0; i < m + 1; i++) {
            if (start[i][0] == row && start[i][1] == col) {
                return i;
            }
        }
        return -1;
    }
}

class Node {
    public int row;
    public int col;
    public int dis;

    public Node(int row, int col, int dis) {
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}

class Edge implements Comparable<Edge> {
    int cost;
    int start;
    int end;

    public Edge(int cost, int start, int end) {
        this.cost = cost;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Edge e) {
        if (this.cost > e.cost)
            return 1;
        else if (this.cost < e.cost)
            return -1;
        else {
            return 0;
        }
    }
}
