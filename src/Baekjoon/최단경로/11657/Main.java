import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static int v, e;

    static Edge[] edge;
    static long[] dist;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        v = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);
        edge = new Edge[e + 1];
        dist = new long[v + 1];

        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i <= e; i++) {
            String[] input2 = br.readLine().split(" ");
            int start = Integer.parseInt(input2[0]);
            int end = Integer.parseInt(input2[1]);
            int weight = Integer.parseInt(input2[2]);

            edge[i] = new Edge(start, end, weight);
        }

        for (int i = 0; i < v - 1; i++) {
            for (int j = 1; j < e + 1; j++) {
                Edge cur = edge[j];
                if (dist[cur.getStart()] != INF && dist[cur.getEnd()] > dist[cur.getStart()] + cur.getWeight()) {
                    dist[cur.getEnd()] = dist[cur.getStart()] + cur.getWeight();
                }
            }
        }

        for (int j = 1; j < e + 1; j++) {
            Edge cur = edge[j];
            if (dist[cur.getStart()] != INF && dist[cur.getEnd()] > dist[cur.getStart()] + cur.getWeight()) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 2; i < v + 1; i++) {
            if (dist[i] == INF) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
        br.close();
        return;
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
