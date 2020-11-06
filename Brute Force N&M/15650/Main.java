import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int m;
    static int[] visited;
    static int[] arr;

    static void dfs(int depth, int nextNum) {
        arr[depth] = nextNum;

        if (depth == m - 1) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (i + 1 > arr[depth]) {
                    visited[i] = 1;
                    dfs(depth + 1, i + 1);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new int[n];
        arr = new int[m];

        for (int i = 0; i < n; i++) {
            visited[i] = 1;
            dfs(0, i + 1);
            visited[i] = 0;
        }
    }
}
