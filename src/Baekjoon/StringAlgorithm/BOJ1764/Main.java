package Baekjoon.StringAlgorithm.BOJ1764;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static int m;
    static Trie trie;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.insert(br.readLine());
        }

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (trie.contain(s)) {
                list.add(s);
            }
        }

        Collections.sort(list);
        bw.write(Integer.toString(list.size()) + "\n");
        for (String s : list) {
            bw.write(s + "\n");
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

    boolean contain(String word) {
        TrieNode thisNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            TrieNode node = thisNode.getChildNodes().get(key);
            if (node == null)
                return false;
            thisNode = node;
        }
        return thisNode.isLastChar();
    }
}