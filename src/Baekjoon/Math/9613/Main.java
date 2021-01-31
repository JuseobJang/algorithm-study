import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int row = Integer.parseInt(br.readLine());
        int[][] num = new int[row][101];
        long[] gcd = new long[row];
        for (int i = 0; i < row; i++) {
            String[] input = br.readLine().split(" ");
            int col = Integer.parseInt(input[0]);
            for (int j = 0; j < col; j++) {
                num[i][j] = Integer.parseInt(input[j + 1]);
            }
            for (int j = 0; j < col; j++) {
                for (int k = j + 1; k < col; k++) {
                    gcd[i] += gcd(num[i][j], num[i][k]);
                }
            }
        }

        for (long i : gcd) {
            System.out.println(i);
        }

    }

}
