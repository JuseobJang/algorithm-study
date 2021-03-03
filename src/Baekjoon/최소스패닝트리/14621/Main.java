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
    static boolean[] univ;
    static PriorityQueue<Road> pq;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        // root 초기화
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        univ = new boolean[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            univ[i] = input[i].equals("M");
        }

        // pq 초기화
        pq = new PriorityQueue<Road>();
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);

            pq.add(new Road(d, u, v));
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            Road road = pq.poll();
            if (find(road.start - 1) != find(road.end - 1) && univ[road.start - 1] != univ[road.end - 1]) {
                merge(road.start - 1, road.end - 1);
                ans += road.cost;
            }
        }
        for (int i = 1; i < n; i++) {
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
