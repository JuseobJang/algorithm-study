package Programmers.그래프.가장먼노드;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        return bfs(n, edge);
    }

    public int bfs(int n, int[][] edge) {
        Queue<Node> q = new LinkedList<Node>();
        boolean[] visited = new boolean[n];
        int max = 0;
        int cnt = 0;
        q.add(new Node(1, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (!visited[cur.num - 1])
                visited[cur.num - 1] = true;
            else {
                continue;
            }
            if (max == cur.depth)
                cnt++;
            else {
                cnt = 1;
                max = cur.depth;
            }
            for (int i = 0; i < edge.length; i++) {
                if (cur.num == edge[i][0]) {
                    q.add(new Node(edge[i][1], cur.depth + 1));
                }
                if (cur.num == edge[i][1]) {
                    q.add(new Node(edge[i][0], cur.depth + 1));
                }
            }
        }
        return cnt;
    }
}

class Node {
    int num;
    int depth;

    public Node(int num, int depth) {
        this.num = num;
        this.depth = depth;

    }
}