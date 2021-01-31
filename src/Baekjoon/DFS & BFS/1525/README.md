## Baekjoon 1525 : 퍼즐

### 논리순서

1. 퍼즐의 칸은 3x3으로 칸수는 고정 되어 있다.
2. 방문을 체크 하기 위해서는 퍼즐의 상태를 담아야 하는데 2차원 배열로 상태를 담기엔 너무 비효율적이다.
3. 퍼즐을 9자리의 수의 형태로 전환하여 BFS 를 위한 큐와 방문 Map 에 담는다.
4. 0은 9자리 숫자에서 예외(맨앞으로 감)가 발생 할 수 있으므로 0 대신 9로 전환한다.
5. Map 의 Key = 퍼즐의 상태 (9자리 숫자) , Value = 이동 횟수
6. Map 의 Key == 123456789 가 존재 하면 그때 의 Value(이동 횟수)를 출력한다

**BFS 구현 함수**

> ```java
>  static int bfs() {
>         Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
>         Queue<Integer> q = new LinkedList<>();
>         visited.put(puz, 0);
>         q.add(puz);
> 
>         while (!q.isEmpty()) {
>             int num = q.poll();
>             String strNum = String.valueOf(num);
> 
>             int start = strNum.indexOf("9");
> 
>             for (int i = 0; i < 4; i++) {
>                 StringBuilder sb = new StringBuilder(strNum);
>                 int row = start / 3;
>                 int col = start % 3;
>                 row = row + dir[i][0];
>                 col = col + dir[i][1];
>                 if (row < 0 || col < 0 || row >= 3 || col >= 3) {
>                     continue;
>                 } else {
>                     int newIndex = row * 3 + col;
>                     char temp = strNum.charAt(newIndex);
>                     sb.setCharAt(newIndex, '9');
>                     sb.setCharAt(start, temp);
>                     int newNum = Integer.parseInt(sb.toString());
>                     if (!visited.containsKey(newNum)) {
>                         visited.put(newNum, visited.get(num) + 1);
>                         q.add(newNum);
>                     }
>                 }
>                 if (visited.containsKey(123456789)) {
>                     return visited.get(123456789);
>                 }
>             }
>         }
> 
>         return -1;
> 
>     }
> ```

