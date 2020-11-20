import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static int n;
    static long[][] dp = new long[101][10];
    static int mod = 1000000000;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (dp[i][j] == 0) {
                    if (j == 0) {
                        dp[i][j] = (dp[i - 1][j + 1]) % mod;
                    } else if (j == 9) {
                        dp[i][j] = (dp[i - 1][j - 1]) % mod;
                    } else {
                        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= 9; i++) {
            ans += dp[n][i];
            ans %= mod;
        }
        System.out.println(ans);
    }
}
