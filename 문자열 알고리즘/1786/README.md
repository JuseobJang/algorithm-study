## Baekjoon 1786 : 찾기

### 논리순서


> **KMP알고리즘 이란?**
>
> 어떠한 문자열이 있을 때, 특정한 패턴(문자열)이 이 문자열에 포함되어 있는 지를 **효율적**으로 확인하는 알고리즘 이다.
>
> 주어진 문자열의 길이를 n, 패턴의 길이를 m 이라고 한다면, 기본적으로 문자열의 맨앞부터 패턴을 한칸식 비교하면서 옮기는 방법은 O(n * m)이다. 
>
> 하지만 KMP 알고리즘을 사용하면 O(n + m) 으로 줄일 수 있다. 그렇다면 KMP 알고리즘은 어떻게 시간 복잡도를 어떻게 줄이는 것일까?
>
> 바로 주어진 패턴의 접두사와 접미사에 대한 일치 정보를 활용하여 문자열과 비교시 접두사와 접미사가 같은 부분에 대해서 바로 건너 뛰어 빠르게 포함관계를 확인 할 수 있다. 
> 
> 만약, 패턴이 **ABAABAB** 라고 한다면 이 패턴에 대한 PI 배열을 아래와 같이 구한다. PI 배열은 패턴의 길이를 점차 늘려가면서 접두사와 접미사가 몇글자 일치하는지에 대한 정보이다. 
> 
>       PI[0] = 0 , A
>       PI[1] = 0 , AB
>       PI[2] = 1 , ABA
>       PI[3] = 1 , ABAA
>       PI[4] = 2 , ABAAB
>       PI[5] = 3 , ABAABA
>       PI[6] = 2 , ABAABAB
>
> 이렇게 구한 PI 배열을 이용하여 만약 기존 문자열이 **ABAABAABAB**라고 하면 아래와 같은 순서로 문자열 검색을 효율적으로 진행할 수 있다.
>
>       ABAABAABAB 
>       A           Start 
>       ABAABAABAB 
>       AB          OK  
>       ABAABAABAB 
>       ABA         OK
>       ABAABAABAB 
>       ABAA        OK
>       ABAABAABAB 
>       ABAAB       OK
>       ABAABAABAB
>       ABAABAB     NO , PI[5] = 3
>       ABAABAABAB
>          A        Restart 
>       ...
> **소스코드**
> ```java
>    public static void kmp(int[] pi, String t, String p) {
>        int tSize = t.length();
>        int pSize = p.length();
>        int j = 0;
>        for (int i = 0; i < tSize; i++) {
>            while (j > 0 && t.charAt(i) != p.charAt(j)) {
>                j = pi[j - 1];
>            }
>            if (t.charAt(i) == p.charAt(j)) {
>                if (j + 1 == pSize) {
>                    ans.add(i - pSize + 2);
>                    j = pi[j];
>
>                } else {
>                    j++;
>                }
>
>            }
>        }
>
>    }
>
>    public static int[] getPi(String word) {
>        int size = word.length();
>        int j = 0;
>        int[] pi = new int[size];
>        for (int i = 1; i < size; i++) {
>            while (j > 0 && word.charAt(i) != word.charAt(j)) {
>                j = pi[j - 1];
>            }
>            if (word.charAt(i) == word.charAt(j)) {
>                pi[i] = ++j;
>            }
>        }
>        return pi;
>    }
> ```