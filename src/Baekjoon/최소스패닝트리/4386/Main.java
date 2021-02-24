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
    static int[] root;
    static double[] x;
    static double[] y;
    static PriorityQueue<Star> pq;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        root = new int[n];
        x = new double[n];
        y = new double[n];

        pq = new PriorityQueue<Star>();

        for (int i = 0; i < n; i++) {
            root[i] = i;
            String[] input = br.readLine().split(" ");
            x[i] = Double.parseDouble(input[0]);
            y[i] = Double.parseDouble(input[1]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double cost = Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
                pq.add(new Star(cost, i, j));
            }
        }

        double ans = 0;
        while(!pq.isEmpty()){
            Star star = pq.poll();
            if (find(star.start) != find(star.end)) {
                merge(star.start, star.end);
                ans += star.cost;
            }
        }
        bw.write(String.format("%.2f", ans));
        bw.flush();

        br.close();
        bw.close();
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

class Star implements Comparable<Star> {
    double cost;
    int start;
    int end;

    public Star(double cost, int start, int end) {
        this.cost = cost;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Star o) {
        if (this.cost > o.cost)
            return 1;
        else if (this.cost < o.cost)
            return -1;
        else {
            return 0;
        }
    }
}
