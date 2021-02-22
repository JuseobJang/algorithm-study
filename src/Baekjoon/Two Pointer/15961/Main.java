import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int n; // 접시수
    static int d; // 초밥의 가짓수
    static int k; // 연속해서 먹는 접시 수
    static int c; // 쿠폰 번호

    static int[] arr;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        d = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        c = Integer.parseInt(input[3]);

        arr = new int[n];
        ans = new int[d + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            ans[arr[i]]++;
        }
        ans[c]++;

        int kind = 0;

        for (int l = 1; l <= d; l++) {
            if (ans[l] != 0) {
                kind++;
            }
        }

        int max = kind;

        for (int i = 0, j = i + k; i < n; i++, j++) {
            int s = i;
            int e = j % n;

            if (ans[arr[e]] == 0) {
                kind++;
            }

            ans[arr[s]]--;
            ans[arr[e]]++;

            if (ans[arr[s]] == 0) {
                kind--;
            }

            max = Math.max(max, kind);
        }

        bw.write(Integer.toString(max));

        bw.flush();

        br.close();
        bw.close();
    }
}
