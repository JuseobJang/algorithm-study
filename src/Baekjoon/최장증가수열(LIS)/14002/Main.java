import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int[] arr;
    static int[] p;
    static ArrayList<Integer> lis;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        p = new int[n];
        lis = new ArrayList<Integer>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        lis.add(arr[0]);
        p[0] = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > lis.get(lis.size() - 1)) {
                p[i] = lis.size();
                lis.add(arr[i]);
            } else {
                int low = lowerbound(arr[i]);
                p[i] = low;
                lis.set(low, arr[i]);
            }
        }

        int[] ans = new int[lis.size()];
        for (int i = n - 1, size = lis.size() - 1; i >= 0 && size >= 0; i--) {
            if (p[i] == size) {
                ans[size--] = arr[i];
            }
        }

        bw.write(Integer.toString(lis.size()) + "\n");
        for (int num : ans) {
            bw.write(Integer.toString(num) + " ");
        }
        bw.flush();

        bw.close();
        bw.close();

    }

    static int lowerbound(int k) {
        int start = 0;
        int end = lis.size();

        while (start < end) {
            int mid = (start + end) / 2;
            if (lis.get(mid) >= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
