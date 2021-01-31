import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int price[];
    static int dyn[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        price = new int[N + 1];
        dyn = new int[N + 1];

        String input[] = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            price[i] = Integer.parseInt(input[i - 1]);
        }

        for (int i = 1; i <= N; i++) {
            dyn[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                dyn[i] = Math.min(dyn[i], dyn[i - j] + price[j]);
            }
        }
        System.out.println(dyn[N]);
    }
}
