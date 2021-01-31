import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int mat[][];
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mat = new int[n][10];
        for (int i = 0; i < 10; i++) {
            mat[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            int start = 0;
            mat[i][0] = start;
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    mat[i][j] += mat[i - 1][k];
                }
                mat[i][j] %= 10007;
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += mat[n - 1][i];
        }
        System.out.println(sum % 10007);
    }
}
