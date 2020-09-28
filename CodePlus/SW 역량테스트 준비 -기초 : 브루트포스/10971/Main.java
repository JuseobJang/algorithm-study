import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int arr[][];
    static int min = 4000000;
    static int start;

    static void dfs(int depth, int[] visited, int pos, int sum) {
        if (depth == 0) {
            start = pos;
        }
        if (depth == n - 1 && arr[pos][start] != 0) {
            sum += arr[pos][start];
            min = Math.min(min, sum);
        } else {
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && arr[pos][i] != 0) {
                    sum += arr[pos][i];
                    visited[i] = 1;
                    dfs(depth + 1, visited, i, sum);
                    visited[i] = 0;
                    sum -= arr[pos][i];
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            visited[i] = 1;
            dfs(0, visited, i, 0);
            visited[i] = 0;
        }
        System.out.println(min);
    }
}
