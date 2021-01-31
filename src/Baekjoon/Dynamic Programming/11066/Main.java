import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static int dp[][];
    static int n;
    static int arr[];
    static int sum[];
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[502][502];
            arr = new int[n + 1];
            sum = new int[n + 1];

            String input[] = br.readLine().split(" ");

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(input[i - 1]);
                sum[i] = sum[i - 1] + arr[i];
            }
            for (int i = 2; i <= n; i++) {
                for (int j = i - 1; j > 0; j--) {
                    dp[j][i] = max;
                    for (int s = j; s <= i; s++) {
                        dp[j][i] = Math.min(dp[j][i], dp[j][s] + dp[s + 1][i]);
                    }
                    dp[j][i] += sum[i] - sum[j - 1];
                }
            }
            System.out.println(dp[1][n]);
        }
    }
}
