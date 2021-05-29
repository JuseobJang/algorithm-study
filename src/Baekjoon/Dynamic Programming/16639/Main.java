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
    static String[] input;
    static int[][] max;
    static int[][] min;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        n = (n / 2) + 1;
        input = br.readLine().split("");
        max = new int[n][n];
        min = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            max[i][i] = Integer.parseInt(input[i * 2]);
            min[i][i] = Integer.parseInt(input[i * 2]);
        }

        for (int cnt = 1; cnt < n; cnt++) { // 계산에 쓰일 수의 갯수
            for (int i = 0; i < n - cnt; i++) {
                int[] cand = new int[4];
                for (int j = i; j < i + cnt; j++) {
                    cand[0] = calc(max[i][j], max[j + 1][i + cnt], input[j * 2 + 1]);
                    cand[1] = calc(max[i][j], min[j + 1][i + cnt], input[j * 2 + 1]);
                    cand[2] = calc(min[i][j], max[j + 1][i + cnt], input[j * 2 + 1]);
                    cand[3] = calc(min[i][j], min[j + 1][i + cnt], input[j * 2 + 1]);
                    Arrays.sort(cand);
                    max[i][i + cnt] = Math.max(max[i][i + cnt], cand[3]);
                    min[i][i + cnt] = Math.min(min[i][i + cnt], cand[0]);

                }
            }
        }

        System.out.println(max[0][n - 1]);

        bw.flush();

        br.close();
        bw.close();
    }

    public static int calc(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
        }
        return 0;
    }
}
