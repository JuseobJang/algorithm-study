import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static BufferedReader br;
    static HashSet<String> hs;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        hs = new HashSet<String>();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            hs.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            if (hs.contains(br.readLine())) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
