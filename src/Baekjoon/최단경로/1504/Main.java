import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int next;
    int cost;

    public Node(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }

    public int getNext() {
        return this.next;
    }

    public Integer getCost() {
        return this.cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.getCost();
    }
}

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int v;
    static int e;
    static int target1, target2;
    static int[][] dist;
    static ArrayList<ArrayList<Node>> edge;
    static final int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        v = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);

        dist = new int[v][v];
        edge = new ArrayList<ArrayList<Node>>();

        for (int[] row : dist) {
            Arrays.fill(row, INF);
        }

        for (int i = 0; i < v; i++) {
            edge.add(new ArrayList<Node>());
        }

        for (int i = 0; i < e; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]) - 1;
            int end = Integer.parseInt(input[1]) - 1;
            int cost = Integer.parseInt(input[2]);
            edge.get(start).add(new Node(end, cost));
            edge.get(end).add(new Node(start, cost));
        }

        input = br.readLine().split(" ");
        target1 = Integer.parseInt(input[0]) - 1;
        target2 = Integer.parseInt(input[1]) - 1;

        dijksrta(0);
        dijksrta(target1);
        dijksrta(target2);

        int ans = Math.min(dist[0][target1] + dist[target1][target2] + dist[target2][v - 1],
                dist[0][target2] + dist[target2][target1] + dist[target1][v - 1]);

        if (ans >= INF) {
            bw.write(Integer.toString(-1));
            bw.flush();

            br.close();
            bw.close();
            return;
        }
        bw.write(Integer.toString(ans));
        bw.flush();

        br.close();
        bw.close();
        return;
    }

    static void dijksrta(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        boolean[] visited = new boolean[v];
        dist[start][start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            int cur = pq.poll().getNext();
            if (visited[cur]) {
                continue;
            }

            visited[cur] = true;

            for (Node node : edge.get(cur)) {
                if (dist[start][node.getNext()] > dist[start][cur] + node.getCost()) {
                    dist[start][node.getNext()] = dist[start][cur] + node.getCost();
                    pq.add(new Node(node.getNext(), dist[start][node.getNext()]));
                }
            }
        }
    }
}
