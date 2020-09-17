### Baekjoon 14502 : 연구소

### 논리 순서

1. 벽 세개를 dfs를 활용하여 가능 한 모든 공간에 세운다.
2. 벽이 세개에 도달하면 bfs를 활용하여 현재 벽이 새로 새워진 맵에서 바이러스를 최대로 퍼뜨린다.
3. 안전한 장소의 갯수를 새고 최댓값을 구한다.



**DFS와 BFS를 동시에 활용한 벽세우기 함수**

> ```java
> static void makeWall(pos start, int count) {
>         if (count == 3) {
>             copyMap = new int[N][M];
>             copy();
>             int safe = 0;
>             Queue<pos> q = new LinkedList<pos>();
>             Iterator<pos> iterator = virus.iterator();
> 
>             while (iterator.hasNext()) {
>                 pos a = iterator.next();
>                 q.add(a);
>             }
>             while (!q.isEmpty()) {
>                 pos v = q.poll();
> 
>                 for (int i = 0; i < 4; i++) {
>                     int row = v.row + dir[i][0];
>                     int col = v.col + dir[i][1];
>                     if (row < 0 || col < 0 || row >= N || col >= M) {
>                         continue;
>                     }
>                     if (copyMap[row][col] == 0) {
>                         copyMap[row][col] = 2;
>                         q.add(new pos(row, col));
>                     }
>                 }
>             }
>             for (int i = 0; i < N; i++) {
>                 for (int j = 0; j < M; j++) {
>                     if (copyMap[i][j] == 0) {
>                         safe++;
>                     }
>                 }
>             }
>             if (max < safe)
>                 max = safe;
>             return;
>         }
>         int row = start.row;
>         int col = start.col;
> 
>         if (row == N) {
>             return;
>         }
>         if (col == M) {
>             makeWall(new pos(row + 1, 0), count);
>             return;
>         }
>         if (map[row][col] == 0) {
>             map[row][col] = 1;
>             makeWall(new pos(row, col + 1), count + 1);
>             map[row][col] = 0;
>         }
>         makeWall(new pos(row, col + 1), count);
>     }
> ```
>
> 
>

