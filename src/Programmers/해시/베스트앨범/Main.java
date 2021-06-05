package Programmers.해시.베스트앨범;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };

        System.out.println(Arrays.toString(sol.solution(genres, plays))); // 4, 1, 3, 0
    }

}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        for (int i = 0; i < genres.length; i++) {
            if (map1.get(genres[i]) == null) {
                map1.put(genres[i], 0);
            }
            map1.put(genres[i], map1.get(genres[i]) + plays[i]);
        }
        while (!map1.isEmpty()) {
            String key = Collections.max(map1.entrySet(), Map.Entry.comparingByValue()).getKey();
            HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
            map1.remove(key);
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(key)) {
                    map2.put(i, plays[i]);
                }
            }

            int count = 0;
            while (!map2.isEmpty()) {
                int key2 = Collections.max(map2.entrySet(), Map.Entry.comparingByValue()).getKey();
                list.add(key2);
                map2.remove(key2);
                if (++count == 2)
                    break;
            }
        }

        int[] ans = new int[list.size()];
        int idx = 0;
        for (int num : list) {
            ans[idx++] = num;
        }
        return ans;
    }
}
