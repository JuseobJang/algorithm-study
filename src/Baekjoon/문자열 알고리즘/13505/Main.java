import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br;
    public static String[] arr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new String[n];

        Trie tr = new Trie();
        int max = Integer.MIN_VALUE;

        String input[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = binToStr(Integer.parseInt(input[i]));
            tr.insert(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, tr.findMax(arr[i]));
        }
        System.out.println(max);
    }

    static String binToStr(int n) {
        StringBuilder sb = new StringBuilder();
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < 30 - s.length(); i++) {
            sb.append("0");
        }
        sb.append(s);
        return sb.toString();
    }

    static class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        void insert(String s) {
            TrieNode thisNode = root;
            for (int i = 0; i < s.length(); i++) {
                int key = 0;
                if (s.charAt(i) == '1') {
                    key = 1;
                }
                if (thisNode.node[key] == null) {
                    thisNode.node[key] = new TrieNode();
                }
                thisNode = thisNode.node[key];
            }
        }

        int findMax(String s) {
            StringBuilder sb = new StringBuilder();
            TrieNode thisNode = root;

            for (int i = 0; i < s.length(); i++) {
                int key = 1;
                if (s.charAt(i) == '1') {
                    key = 0;
                }
                if (thisNode.node[key] == null) { // 반대가 없다.
                    sb.append('0');
                    if (key == 0) {
                        thisNode = thisNode.node[1];
                    } else {
                        thisNode = thisNode.node[0];
                    }
                } else { // 있다.
                    sb.append('1');
                    thisNode = thisNode.node[key];
                }
            }
            return Integer.parseInt(sb.toString(), 2);
        }
    }

    static class TrieNode {
        TrieNode node[] = new TrieNode[2];
    }
}
