import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static BufferedReader br;
    static BufferedWriter bw;

    static void dfs(int depth, int nextNum) throws Exception {
        arr[depth] = nextNum;

        if (depth == m - 1) {
            for (int i = 0; i < m; i++) {
                bw.write(Integer.toString(arr[i]) + " ");
            }
            bw.newLine();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i + 1 >= arr[depth]) {
                dfs(depth + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[m];

        for (int i = 0; i < n; i++) {
            dfs(0, i + 1);
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
