import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static BufferedReader br;
    static ArrayList<Integer> ans;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ans = new ArrayList<Integer>();
        String t = br.readLine();
        String p = br.readLine();
        kmp(getPi(p), t, p);
        System.out.println(ans.size());
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static void kmp(int[] pi, String t, String p) {
        int tSize = t.length();
        int pSize = p.length();
        int j = 0;
        for (int i = 0; i < tSize; i++) {
            while (j > 0 && t.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (t.charAt(i) == p.charAt(j)) {
                if (j + 1 == pSize) {
                    ans.add(i - pSize + 2);
                    j = pi[j];

                } else {
                    j++;
                }

            }
        }

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
