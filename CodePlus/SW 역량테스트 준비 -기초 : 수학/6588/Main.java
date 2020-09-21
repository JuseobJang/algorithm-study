import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int num;
        while ((num = Integer.parseInt(br.readLine())) != 0) {
            arr.add(num);
        }
        for (int a : arr) {
            int ps;
            int pl;
            for (ps = 3; ps < a; ps++) {
                pl = a - ps;
                if (isPrime(ps) && isPrime(pl)) {
                    System.out.println(a + " = " + ps + " + " + pl);
                    break;
                }
            }
        }
    }
}
