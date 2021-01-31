import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static int[] pi;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String s = br.readLine();
        pi = getPi(s);
        System.out.println(l - pi[l - 1]);

    }

    public static int[] getPi(String word) {
        int size = word.length();
        int j = 0;
        int[] pi = new int[size];
        for (int i = 1; i < size; i++) {
            while (j > 0 && word.charAt(i) != word.charAt(j)) {
                j = pi[j - 1];
            }
            if (word.charAt(i) == word.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
