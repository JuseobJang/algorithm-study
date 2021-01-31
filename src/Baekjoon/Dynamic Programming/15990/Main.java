import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br;
    public static long[][] dp = new long[1000001][4];
    public static long mod = 1000000009;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 4; i <= n; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (dp[i][j] != 0) {
                        continue;
                    }
                    if (j == 1) {
                        dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
                    } else if (j == 2) {
                        dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
                    } else {
                        dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
                    }
                }
            }
            System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % mod);
        }
    }
}
