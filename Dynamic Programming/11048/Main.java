import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int m;
    static int mat[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        mat = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String input2[] = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                mat[i][j] = Integer.parseInt(input2[j - 1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int max = Math.max(mat[i - 1][j - 1], mat[i - 1][j]);
                mat[i][j] = Math.max(mat[i][j - 1], max) + mat[i][j];
            }
        }
        System.out.println(mat[n][m]);
    }

}
