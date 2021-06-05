## Baekjoon 2178 : 미로탐색

### 논리순서

 처음에는 제목만 보고 미로를 탐색 하는 경로와 한 가지 길만 있다고 착각하고 DFS로 시도 했다가 목적지로 갈 수 있는 길이 여러 길이 있다는 사실과 그때의 최솟값을 구하는 것에 대해 생각해보니 BFS가 적합하다 생각하고 BFS로 풀었다.

1. 일단 미로의 범위를 넘지 않는 내에서 현재 위치를 부모 노드라 생각한다.
2. 네 방향 위치에 대해서 갈수 있는 지 판별하고 중복 되지 않는지 판단후 자식노드로 삼고 큐에 차례로 넣어준다.
3. 큐에서 하나씩 빼면서 네방향 탐색에 대한 위과정을 반복한다.
4. 목적지에 도착한 그 순간이 길이의 최솟값이라 할 수 있다.



**BFS 사용 코드**

> ```java
> static void bfs(int row, int col) {
>         Queue<pos> q = new LinkedList<pos>();
>         q.add(new pos(row, col, 1));
>         while (!q.isEmpty()) {
>             pos p = q.poll();
>             if (p.x == N - 1 && p.y == M - 1) {
>                 System.out.println(p.count);
>                 return;
>             }
>             for (int i = 0; i < 4; i++) {
>                 int new_row = p.x + dir[i][0];
>                 int new_col = p.y + dir[i][1];
>                 int cnt = p.count;
>                 if (new_row >= 0 && new_col >= 0 && new_row < N && new_col < M) {
>                     if (map[new_row][new_col] == 1 && visited[new_row][new_col] == false) {
>                         visited[new_row][new_col] = true;
>                         q.add(new pos(new_row, new_col, cnt + 1));
>                     }
>                 }
>             }
>         }
>     }
> ```

