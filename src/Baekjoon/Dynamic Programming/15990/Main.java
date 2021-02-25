import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static long[][] dp = new long[1000001][4];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        dp[1][1] = 1; // 1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 1+2 , 2+1 , 3
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 4; i <= n; i++) {
                if (dp[i][1] == 0) {
                    dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
                }
                if (dp[i][2] == 0) {
                    dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
                }
                if (dp[i][3] == 0) {
                    dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
                }
            }
            int ans = 0 ;
            for (int i = 1; i <= 3; i++) {
                ans += dp[n][i];
                ans %= 1000000009;
            }
            bw.write(Integer.toString(ans)+"\n");
        }
        bw.flush();


        br.close();
        bw.close();
    }
}
