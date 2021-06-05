package Baekjoon.ShortestPath.BOJ1865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static final int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;

        int test = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < test; tc++) {
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            boolean flag = false;
            int[] dist = new int[n];
            ArrayList<Edge> edges = new ArrayList<Edge>();

            for (int i = 0; i < m; i++) {
                input = br.readLine().split(" ");
                int s = Integer.parseInt(input[0]) - 1;
                int e = Integer.parseInt(input[1]) - 1;
                int t = Integer.parseInt(input[2]);
                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));
            }

            for (int i = 0; i < w; i++) {
                input = br.readLine().split(" ");
                int s = Integer.parseInt(input[0]) - 1;
                int e = Integer.parseInt(input[1]) - 1;
                int t = Integer.parseInt(input[2]) * (-1);
                edges.add(new Edge(s, e, t));
            }
            Arrays.fill(dist, INF);
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < edges.size(); j++) {
                    Edge cur = edges.get(j);
                    
                    if (dist[cur.end] > dist[cur.start] + cur.weight) {
                        dist[cur.end] = dist[cur.start] + cur.weight;
                    }
                }
            }
            for (int j = 0; j < edges.size(); j++) {
                Edge cur = edges.get(j);
                
                if (dist[cur.end] > dist[cur.start] + cur.weight) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }
            bw.newLine();
        }
        bw.flush();

        br.close();
        bw.close();
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
}