import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] num;
    static int[] op = new int[4];
    static int max = -1000000000;
    static int min = 1000000000;

    static void dfs(int depth, int result, int[] useOp) {
        if (depth == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        if (useOp[0] != op[0]) {
            useOp[0]++;
            dfs(depth + 1, result + num[depth], useOp);
            useOp[0]--;
        }
        if (useOp[1] != op[1]) {
            useOp[1]++;
            dfs(depth + 1, result - num[depth], useOp);
            useOp[1]--;
        }
        if (useOp[2] != op[2]) {
            useOp[2]++;
            dfs(depth + 1, result * num[depth], useOp);
            useOp[2]--;
        }
        if (useOp[3] != op[3]) {
            useOp[3]++;
            dfs(depth + 1, result / num[depth], useOp);
            useOp[3]--;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        int[] useOp = new int[4];
        String[] input = br.readLine().split(" ");
        String[] inputOp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(inputOp[i]);
        }
        dfs(1, num[0], useOp);
        System.out.println(max);
        System.out.println(min);
    }
}
