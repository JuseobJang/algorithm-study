import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int l;
    static int c;
    static int[] arr;
    static int[] visited;

    static void dfs(int depth, int[] set, int cons, int vowel) {

        if (depth == l) {
            if (cons > 1 && vowel > 0) {
                // System.out.println(Arrays.toString(set));
                for (int i = 0; i < l; i++) {
                    System.out.print((char) set[i]);
                }
                System.out.println();
            }
            return;
        }
        for (int i = 0; i < c; i++) {
            if (depth != 0 && set[depth - 1] > arr[i]) {
                continue;
            }

            if (visited[i] == 0) {
                visited[i] = 1;
                set[depth] = arr[i];
                if (arr[i] == 97 || arr[i] == 101 || arr[i] == 105 || arr[i] == 111 || arr[i] == 117) {
                    dfs(depth + 1, set, cons, vowel + 1);
                } else {
                    dfs(depth + 1, set, cons + 1, vowel);
                }
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        l = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        arr = new int[c];
        visited = new int[c];

        String[] input_arr = br.readLine().split(" ");
        for (int i = 0; i < c; i++) {
            arr[i] = (int) input_arr[i].charAt(0);
        }
        Arrays.sort(arr);
        dfs(0, new int[l], 0, 0);
    }
}
