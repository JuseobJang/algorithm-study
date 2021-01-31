import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int E = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);
        int i = 0, j = 0, k = 0;
        int count = 0;
        while (E != i || S != j || M != k) {
            count++;
            i++;
            j++;
            k++;
            if (i > 15) {
                i = 1;
            }
            if (j > 28) {
                j = 1;
            }
            if (k > 19) {
                k = 1;
            }
        }
        System.out.println(count);
    }
}
