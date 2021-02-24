import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] mat = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        System.out.println(sol.solution(3, mat));

    }
}

class Solution {
    int[] root;

    public int solution(int n, int[][] computers) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(computers[i][j] == 1){
                    merge(i, j);
                }
            }
        }
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0 ; i < n ;i ++){
            hs.add(find(i));
        }
        int answer = hs.size();

        return answer;
    }

    private int find(int n) {
        if (root[n] == n)
            return n; // root[n] == n 이면 트리의 맨위 root 이다.
        else {
            return find(root[n]);
        }
    }

    private void merge(int a, int b) {
        root[find(b)] = find(a);
    }
}