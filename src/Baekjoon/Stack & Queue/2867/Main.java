import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static class pair {
        Integer key;
        Integer value;

        public pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N + 1];

        int[] leftMax = new int[N + 1];
        int[] rightMax = new int[N + 1];
        int[] leftMin = new int[N + 1];
        int[] rightMin = new int[N + 1];

        int ans = 0;
        int cnt;

        Stack<pair> stk = new Stack<>();

        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            while (!stk.empty() && stk.peek().getValue() <= seq[i])
                stk.pop();
            if (stk.empty())
                leftMax[i] = 1;
            else {
                leftMax[i] = stk.peek().getKey() + 1;
            }
            stk.push(new pair(i, seq[i]));
        }

        stk.clear();

        for (int i = N; i > 0; i--) {
            while (!stk.empty() && stk.peek().getValue() < seq[i])
                stk.pop();
            if (stk.empty())
                rightMax[i] = N;
            else {
                rightMax[i] = stk.peek().getKey() - 1;
            }
            stk.push(new pair(i, seq[i]));
        }
        stk.clear();

        for (int i = 1; i <= N; i++) {
            while (!stk.empty() && stk.peek().getValue() >= seq[i])
                stk.pop();
            if (stk.empty())
                leftMin[i] = 1;
            else {
                leftMin[i] = stk.peek().getKey() + 1;
            }
            stk.push(new pair(i, seq[i]));

        }
        stk.clear();
        for (int i = N; i > 0; i--) {
            while (!stk.empty() && stk.peek().getValue() > seq[i])
                stk.pop();
            if (stk.empty())
                rightMin[i] = N;
            else {
                rightMin[i] = stk.peek().getKey() - 1;
            }
            stk.push(new pair(i, seq[i]));
        }
        for (int i = 1; i <= N; i++) {
            cnt = (rightMax[i] - i + 1) * (i - leftMax[i] + 1);
            ans += cnt * seq[i];
            cnt = (rightMin[i] - i + 1) * (i - leftMin[i] + 1);
            ans -= cnt * seq[i];

        }

        System.out.println(ans);
    }
}
