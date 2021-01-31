import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static int n;
    static int m;
    static int[] visited;
    static int[] arr;
    static int[] sol;
    static BufferedReader br;
    static BufferedWriter bw;

    static void dfs(int depth, int nextNum) throws Exception {
        sol[depth] = nextNum;

        if (depth == m - 1) {
            for (int i = 0; i < m; i++) {
                bw.write(Integer.toString(sol[i]) + " ");
            }
            bw.newLine();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (arr[i] > sol[depth]) {
                    visited[i] = 1;
                    dfs(depth + 1, arr[i]);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");

        visited = new int[n];
        arr = new int[n];
        sol = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            visited[i] = 1;
            dfs(0, arr[i]);
            visited[i] = 0;
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
