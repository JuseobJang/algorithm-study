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
    static int n;
    static int[][] early;
    static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        early = new int[2][n];
        tree = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]) - 1;
            int e = Integer.parseInt(input[1]) - 1;
            tree.get(s).add(e);
            tree.get(e).add(s);
        }

        boolean[] visited = new boolean[n];
        dfs(0, visited);
        int ans = Math.min(early[0][0], early[1][0]);
        bw.write(Integer.toString(ans));

        bw.flush();

        br.close();
        bw.close();
    }

    static void dfs(int cur, boolean[] visited) {
        visited[cur] = true;
        early[0][cur] = 0;
        early[1][cur] = 1;
        for (int next : tree.get(cur)) {
            if (!visited[next]) {
                dfs(next, visited);
                early[0][cur] += early[1][next];
                early[1][cur] += Math.min(early[0][next], early[1][next]);
            }
        }
    }

}