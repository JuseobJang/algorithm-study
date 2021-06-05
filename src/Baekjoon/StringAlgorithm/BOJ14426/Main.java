package Baekjoon.StringAlgorithm.BOJ14426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br;
    static Trie tr;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        tr = new Trie();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            tr.insert(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            if (tr.contain(br.readLine())) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static class TrieNode {
        private Map<Character, TrieNode> childNodes = new HashMap<>();
        private boolean isLastChar;

        Map<Character, TrieNode> getChildNodes() {
            return this.childNodes;
        }

        boolean isLastChar() {
            return this.isLastChar;
        }

        void setIsLastChar(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }
    }

    public static class Trie {
        private TrieNode rootNode;

        Trie() {
            this.rootNode = new TrieNode();
        }

        void insert(String word) {
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                char key = word.charAt(i);
                TrieNode node = thisNode.getChildNodes().get(key);
                if (node == null) {
                    thisNode.getChildNodes().put(key, new TrieNode());
                }
                thisNode = thisNode.getChildNodes().get(key);
            }
            thisNode.setIsLastChar(true);
        }

        boolean contain(String word) {
            TrieNode thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                char key = word.charAt(i);
                TrieNode node = thisNode.getChildNodes().get(key);
                if (node == null)
                    return false;
                thisNode = node;
            }
            return true;
        }
    }

}
