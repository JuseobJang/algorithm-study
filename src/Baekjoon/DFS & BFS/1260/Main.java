import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int V;
    static ArrayList<Integer> depth = new ArrayList<Integer>();
    static ArrayList<Integer> breadth = new ArrayList<Integer>();
    static Queue<Integer> queue = new LinkedList<Integer>();

    public static void depth_search(int parent, final int[][] edge) {
        int child;
        depth.add(parent);
        System.out.print(parent + " ");
        for (child = 1; child <= N; child++) {
            if (edge[parent][child] == 1 && !depth.contains(child)) {
                edge[parent][child] = 0;
                depth_search(child, edge);
            }
        }

    }

    public static void breadth_search(int parent, final int[][] edge) {
        int child;
        queue.add(parent);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            breadth.add(node);
            System.out.print(node + " ");

            for (child = 1; child <= N; child++) {
                if (edge[node][child] == 1 && !breadth.contains(child)) {
                    edge[node][child] = 0;
                    if (!queue.contains(child))
                        queue.add(child);
                }
            }

        }

    }

    public static void main(final String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);

        int[][] dedge = new int[N + 1][N + 1];
        int[][] bedge = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            String[] input_edge = br.readLine().split(" ");
            int start = Integer.parseInt(input_edge[0]);
            int end = Integer.parseInt(input_edge[1]);
            dedge[start][end] = 1;

            dedge[start][end] = 1;
            dedge[end][start] = 1; // 양방향 삽입
            bedge[start][end] = 1;
            bedge[end][start] = 1; // 양방향 삽입
        }

        depth_search(V, dedge);
        System.out.println("");
        breadth_search(V, bedge);

    }

}
