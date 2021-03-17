import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static int[] words;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        words = new int[n];
        
        int alphabet = 1;
        for (int i = 1; i < 26; i++) {
            alphabet <<= 1;
            alphabet++;
        }
        for (int i = 0; i < n; i++) {
            words[i] = wordToBin(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int cmd = Integer.parseInt(input[0]);
            int target = wordToBin(input[1]);
            int ans = 0 ;
            alphabet ^= target;
            for(int word : words){
                if((alphabet & word) == word){
                    ans++;
                }
            }
            bw.write(Integer.toString(ans));
            bw.newLine();
        }
        bw.flush();

        br.close();
        bw.close();
    }
    static int wordToBin(String word) {
        char[] charArray = word.toCharArray();
        int ans = 0;
        for (int c : charArray) {
            c -= 96;
            int al = 1;
            for (int i = 1; i < c; i++)
                al <<= 1;
            ans |= al;
        }
        return ans;
    }
}
