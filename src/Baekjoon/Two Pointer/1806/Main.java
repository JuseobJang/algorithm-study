import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int n;
    static int s;
    static int[] arr;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);

        arr = new int[n + 1];
        sum = new int[n + 1];

        String[] input2 = br.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input2[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }

        if (sum[n] < s) {
            bw.write("0");
            bw.flush();

            br.close();
            bw.close();
            return;
        }

        int i = 0;
        int j = 1;
        int ans = Integer.MAX_VALUE;
        while (i != j && j <= n) {
            if (sum[j] - sum[i] >= s) {
                ans = Math.min(ans, j - i);
                i++;
            } else {
                j++;
            }

        }
        bw.write(Integer.toString(ans));
        bw.flush();

        br.close();
        bw.close();
    }
}
