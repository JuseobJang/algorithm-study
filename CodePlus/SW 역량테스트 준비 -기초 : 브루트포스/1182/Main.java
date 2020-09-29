import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int s;
    static int[] arr;
    static int cnt;

    static void dfs(int depth, int sum) {
        if (depth == n) {
            if (depth != 0 && sum == s) {
                // System.out.println(sum);
                cnt++;

            }
            return;
        }
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String[] input_arr = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input_arr[i]);
        }
        dfs(0, 0);
        if (s == 0) {
            cnt--;
        }
        System.out.println(cnt);
    }
}
