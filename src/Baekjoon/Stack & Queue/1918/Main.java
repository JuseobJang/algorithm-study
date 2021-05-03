import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] median = br.readLine().split("");

        Stack<String> stk = new Stack<String>();

        for (String s : median) {
            if (s.equals("(")) {
                stk.push(s);
            } else if (s.equals(")")) {
                while (!stk.peek().equals("(")) {
                    bw.write(stk.pop());
                }
                stk.pop();
            } else if (s.equals("+") || s.equals("-")) {
                if (stk.isEmpty()) {
                    stk.push(s);
                    continue;
                }
                while (!stk.isEmpty()) {
                    if (stk.peek().equals("*") || stk.peek().equals("/") || stk.peek().equals("+")
                            || stk.peek().equals("-")) {
                        bw.write(stk.pop());
                    } else {
                        break;
                    }
                }
                stk.push(s);

            } else if (s.equals("*") || s.equals("/")) {
                if (stk.isEmpty()) {
                    stk.push(s);
                    continue;
                }
                while (!stk.isEmpty()) {
                    if (stk.peek().equals("*") || stk.peek().equals("/")) {
                        bw.write(stk.pop());
                    } else {
                        break;
                    }
                }
                stk.push(s);
            } else {
                bw.write(s);
            }
        }
        while (!stk.isEmpty()) {
            bw.write(stk.pop());
        }

        bw.flush();

        br.close();
        bw.close();
    }
}