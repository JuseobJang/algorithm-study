import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for (String a : str) {
            left.push(a);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] com = br.readLine().split(" ");
            String move = com[0];
            String one;
            switch (move) {
                case "P":
                    one = com[1];
                    left.push(one);
                    break;
                case "B":
                    if (!left.empty()) {
                        left.pop();
                    }
                    break;
                case "L":
                    if (!left.empty()) {
                        one = left.pop();
                        right.push(one);
                    }
                    break;
                case "D":
                    if (!right.empty()) {
                        one = right.pop();
                        left.push(one);
                    }
                    break;
            }

        }
        while (!left.empty()) {
            right.push(left.pop());
        }
        while (!right.empty()) {
            System.out.print(right.pop());
        }

    }
}
