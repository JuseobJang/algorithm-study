import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br;
    static int size = 26;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        Trie tr = new Trie();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            tr.insert(br.readLine());
        }
        tr.initFail();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            System.out.println(tr.find(br.readLine()) ? "YES" : "NO");
        }

    }

    static class Node {
        boolean isEnd;
        Node fail;
        Node[] child = new Node[26];

        Node setChild(char key) {
            if (child[key - 97] == null) {
                return child[key - 97] = new Node();
            }
            return child[key - 97];
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
                        if (thisNode == this.root) { // thisNode 가 root 라면 nextNode는 null이 아니어도 nextNode.fail 은 무조건 root
                                                     // 이다.
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

        boolean find(String word) {
            Node thisNode = this.root;
            for (int i = 0; i < word.length(); i++) {
                int next = word.charAt(i) - 97;
                while (thisNode != this.root && thisNode.child[next] == null) {
                    thisNode = thisNode.fail;
                }
                if (thisNode.child[next] != null) {
                    thisNode = thisNode.child[next];
                }
                if (thisNode.isEnd) {
                    return true;
                }
            }
            return false;
        }
    }

}
