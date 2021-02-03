import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int v;
    int weight;

    public Node(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }

    public int getV() {
        return this.v;
    }

    public Integer getWeight() {
        return this.weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.getWeight();
    }
}

public class Main {
    static BufferedReader br;
    static int v;
    static int e;
    static int start;
    static ArrayList<ArrayList<Node>> list;
    static int[] dist;
    static boolean[] visit;
    static final int inf = 1000000000;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        v = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);
        start = Integer.parseInt(br.readLine());

        list = new ArrayList<ArrayList<Node>>();
        dist = new int[v + 1];
        visit = new boolean[v + 1];

        Arrays.fill(dist, inf);

        for (int i = 0; i < v + 1; i++) {
            list.add(new ArrayList<Node>());
        }

        for (int i = 1; i <= e; i++) {
            String[] path = br.readLine().split(" ");
            int v1 = Integer.parseInt(path[0]);
            int v2 = Integer.parseInt(path[1]);
            int weight = Integer.parseInt(path[2]);
            list.get(v1).add(new Node(v2, weight));
        }

        dijksrta();

        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == inf) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    static void dijksrta() {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visit[cur]) {
                continue;
            }

            int curV = cur.getV();
            visit[curV] = true;

            for (Node next : list.get(v)) {
                if (dist[next.getV()] > dist[curV] + next.getWeight()) {
                    dist[next.getV()] = dist[curV] + next.getWeight();
                    pq.add(new Node(next.getV(), dist[next.getV()]));
                }
            }
        }
    }
}
