import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][] visited = new boolean[11][1000001]; // 교환 횟수와 숫자
    static int num;
    static int size;
    static int K;

    static class pair {
        Integer key;
        Integer value;

        public pair(final Integer key, final Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getkey() {
            return key;
        }

        public Integer getvalue() {
            return value;
        }
    }

    static void bfs() {
        Queue<pair> q = new LinkedList<pair>();
        q.add(new pair(0, num));
        visited[0][num] = true;

        while (!q.isEmpty()) {
            if (q.peek().getkey() == K) {
                break;
            }
            pair p = q.poll();
            int cur = p.getkey();
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    int a = swap(p.getvalue(), i, j);
                    if (a != -1 && !visited[cur + 1][a]) {
                        q.add(new pair(cur + 1, a));
                        visited[cur + 1][a] = true;
                    }
                }
            }

        }
        int ans = -1;
        while (!q.isEmpty()) {
            pair p = q.poll();
            if (ans < p.getvalue()) {
                ans = p.getvalue();
            }

        }
        System.out.print(ans);

    }

    static int swap(int num, int i, int j) {
        String numString = Integer.toString(num);
        String[] arr = new String[size];
        String new_num = "";

        arr = numString.split("");
        if (Integer.parseInt(arr[j]) == 0 && i == 0) {
            return -1;
        } else {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for (int k = 0; k < size; k++) {
            new_num += arr[k];
        }
        return Integer.parseInt(new_num);

    }

    static boolean compare(int[] a, int[] b) {
        for (int i = 0; i < size; i++) {
            if (a[i] > b[i]) {
                return true;
            } else if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        K = Integer.parseInt(input[1]); // 횟수
        size = input[0].split("").length;
        num = Integer.parseInt(input[0]);
        bfs();
        // System.out.print(num);
    }
}
