package Programmers.KakaoBlindRecruitment2020.괄호변환;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("(()())()"));// "(()())()"
        System.out.println(sol.solution(")(")); // "()"
        System.out.println(sol.solution("()))((()")); // "()(())()"
    }

}

class Solution {
    public String solution(String s) {
        String answer = "";
        String u = "";
        String v = "";
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
            if (cnt == 0 && i != 0) {
                u = s.substring(0, i + 1);
                v = s.substring(i + 1);
                break;
            }

        }
        if (!v.equals(""))
            v = solution(v);

        if (!isPerfect(u)) {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(v);
            sb.append(')');
            sb.append(change(u));
            return sb.toString();
        }
        return u + v;
    }

    public boolean isPerfect(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        if (cnt != 0) {
            return false;
        }
        return true;
    }

    public String change(String s) {
        s = s.substring(1, s.length() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}
