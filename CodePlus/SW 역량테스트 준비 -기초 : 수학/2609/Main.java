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
        String[] input = br.readLine().split(" ");
        int num_1 = Integer.parseInt(input[0]);
        int num_2 = Integer.parseInt(input[1]);

        int gcd = gcd(num_1, num_2);
        int lcm = (num_1 * num_2) / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}
