import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[] ham;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        ham = new int[n];
        for (int i = 0; i < n; i++) {
            ham[i] = Integer.parseInt(input[i]);
        }
        int sum = 0;
        for (int num : ham) {
            sum += num;
        }
        dp = new boolean[sum + 1][sum + 1];
        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                for (int k = sum; k >= 0; k--) {
                    if (j - ham[i] >= 0)
                        dp[j][k] |= dp[j - ham[i]][k];
                    if (k - ham[i] >= 0)
                        dp[j][k] |= dp[j][k - ham[i]];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] && j >= (sum - i - j))
                    ans = Math.max(ans, sum - i - j);
            }
        }

        bw.write(Integer.toString(ans));
        bw.flush();

        br.close();
        bw.close();
    }
}
