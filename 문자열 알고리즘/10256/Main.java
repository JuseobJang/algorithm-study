import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br;
    static int size = 4;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            Trie tr = new Trie();

            String dna = br.readLine();
            String mark = br.readLine();
            for (String s : getMutation(mark)) {
                tr.insert(s);
            }
            tr.initFail();
            System.out.println(tr.find(dna));

        }
    }

    static HashSet<String> getMutation(String mark) {
        HashSet<String> mut = new HashSet<String>();
        for (int i = 0; i < mark.length(); i++) {
            for (int j = i + 1; j <= mark.length(); j++) {
                StringBuilder sb = new StringBuilder();
                for (int first = 0; first < i; first++) {
                    sb.append(mark.charAt(first));
                }
                for (int second = j - 1; second >= i; second--) {
                    sb.append(mark.charAt(second));
                }
                for (int third = j; third < mark.length(); third++) {
                    sb.append(mark.charAt(third));
                }
                mut.add(sb.toString());
            }
        }
        return mut;
    }

    static class Node {
        boolean isEnd;
        Node fail;
        Node[] child = new Node[4];

        Node setChild(char key) {
            switch (key) {
                case 'A':
                    key = 0;
                    break;
                case 'C':
                    key = 1;
                    break;
                case 'G':
                    key = 2;
                    break;
                case 'T':
                    key = 3;
                    break;
            }
            if (child[key] == null) {
                return child[key] = new Node();
            }
            return child[key];
        }
    }

    static class Trie {
        Node root = new Node();

        void insert(String word) {
            Node thisNode = this.root;
            for (int i = 0; i < word.length(); i++) {
                thisNode = thisNode.setChild(word.charAt(i));
            }
            thisNode.isEnd = true;
        }

        void initFail() {
            Queue<Node> q = new LinkedList<Node>();
            this.root.fail = this.root;
            q.add(this.root);
            while (!q.isEmpty()) {
                Node thisNode = q.poll();
                for (int i = 0; i < size; i++) {
                    Node nextNode = thisNode.child[i];
                    if (nextNode != null) {
                        if (thisNode == this.root) {
                            nextNode.fail = this.root;
                        } else {
                            Node failNode = thisNode.fail;
                            while (failNode != this.root && failNode.child[i] == null) {
                                failNode = failNode.fail;
                            }
                            if (failNode.child[i] != null) {
                                failNode = failNode.child[i];
                            }
                            nextNode.fail = failNode;
                        }
                        if (nextNode.fail.isEnd) {
                            nextNode.isEnd = true;
                        }
                        q.add(nextNode);
                    }
                }
            }
        }

        int find(String word) {
            int cnt = 0;
            Node thisNode = this.root;
            for (int i = 0; i < word.length(); i++) {
                int next = -1;
                switch (word.charAt(i)) {
                    case 'A':
                        next = 0;
                        break;
                    case 'C':
                        next = 1;
                        break;
                    case 'G':
                        next = 2;
                        break;
                    case 'T':
                        next = 3;
                        break;
                }
                while (thisNode != this.root && thisNode.child[next] == null) {
                    thisNode = thisNode.fail;
                }
                if (thisNode.child[next] != null) {
                    thisNode = thisNode.child[next];
                }
                if (thisNode.isEnd) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
