package Baekjoon.StringAlgorithm.BOJ5670;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            Trie trie = new Trie();
            int n = Integer.parseInt(input);
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                String word = br.readLine();
                trie.insert(word);
                words[i] = word;
            }

            double ans = 0.00;
            for (int i = 0; i < n; i++) {
                ans += (double) trie.autoComplete(words[i]);
            }
            bw.write(String.format("%.2f", ans / n) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

class TrieNode {
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

class Trie {
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

    int autoComplete(String word) {
        TrieNode thisNode = this.rootNode;
        int autoCnt = 1;
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            Map<Character, TrieNode> childNodes = thisNode.getChildNodes();
            if (childNodes.size() > 1) {
                if (i != 0) {
                    autoCnt++;
                }
            } else if (childNodes.size() == 1) {
                if (thisNode.isLastChar()) {
                    autoCnt++;
                }
            }
            thisNode = childNodes.get(key);

        }
        return autoCnt;
    }
}