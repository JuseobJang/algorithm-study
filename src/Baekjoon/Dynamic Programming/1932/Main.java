import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[][] tri;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        tri = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(input[j]);
            }
        }
        dp[0][0] = tri[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + tri[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + tri[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + tri[i][j];
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int sum : dp[n - 1]) {
            ans = Math.max(sum, ans);
        }
        bw.write(Integer.toString(ans));
        bw.flush();

        br.close();
        bw.close();
    }
}