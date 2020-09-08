

## Baekjoon 1039 : 교환

### 논리의 순서

중요한 점 : 처음엔 그냥 가장 큰 수를 찾는 것과 헷갈리기 쉽지만 이 문제의 요점은 어떻게든 **K번 교환**을 하였을 때 가장 큰 값을 찾는 것이다.

1. 교환 횟수와 그 횟수에서 나올 수 있는 수를 배열로 만들어 중복을 방지하기 위해 방문기록을 담아둠 
2. BFS를 통해 Queue에 집어 넣을 때, 교환횟수와 해당 수를 같이 집어 넣음
3. 교환 했을때 맨 앞자리가 0이 나오지 않고 방문한 적이 없는 숫자들을 Queue에 집어 넣음
4. 설정한 교환 횟수 만큼 반복을 마치면 Queue에 남은 값들 중 가장 큰 값을 출력(이 때 Queue 내의 모든 값들의 교환 횟수는 같음)

### Queue를 이용한 BFS

>BFS에서는 보통 Queue 를 많이 사용한다. 추가로 중복을 방지하기 위해 방문 기록을 담아 두는 것이 중요하다.
>
>```java
>static void bfs() {
>        Queue<pair> q = new LinkedList<pair>();
>        q.add(new pair(0, num));
>        visited[0][num] = true;
>
>        while (!q.isEmpty()) {
>            if (q.peek().getkey() == K) {
>                break;
>            }
>            pair p = q.poll();
>            int cur = p.getkey();
>            for (int i = 0; i < size - 1; i++) {
>                for (int j = i + 1; j < size; j++) {
>                    int a = swap(p.getvalue(), i, j);
>                    if (a != -1 && !visited[cur + 1][a]) {
>                        q.add(new pair(cur + 1, a));
>                        visited[cur + 1][a] = true;
>                    }
>                }
>            }
>
>        }
>        int ans = -1;
>        while (!q.isEmpty()) {
>            pair p = q.poll();
>            if (ans < p.getvalue()) {
>                ans = p.getvalue();
>            }
>
>        }
>        System.out.print(ans);
>
>    }
>```



