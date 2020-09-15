## Baekjoon 16236 : 아기 상어

### 논리 순서

1. 현재 위치에서 먹을 수 있는 가장 가까운 물고기를 BFS를 통해 탐색한다.
2. 가장 가까운 거리에 있는 물고기들 중 가장 위, 왼쪽에 있는 물고기를 찾는다.
3. 물고기가 있는 방향으로 상어를 이동 시켜 주고 그 때 이동 칸수를 더해준다.
4. 물고기를 먹었다면 
   1. 상어의 크기 만큼 물고기 갯수 도달시 상어의 크기를 1 더해주고 물고기 갯수를 0으로 초기화한다.
   2. 물고기 갯수가 상어의 크기에 도달 하지 못했다면 물고기의 갯수 만 늘려준다.
5. 물고기를 먹은 위치 부터 다시 BFS 탐색을 통해 다음 먹을 물고기의 위치를 구하고.위과정을 반복한다.



> ```java
>     static pos bfs(int row, int col, int size) {
>         Queue<pos> q = new LinkedList<pos>();
>         ArrayList<pos> find = new ArrayList<pos>();
>         visited = new int[N][N];
>         int find_dis = -1;
> 
>         q.add(new pos(row, col, 0));
>         while (!q.isEmpty()) {
>             pos p = q.poll();
>             int dis = p.dis;
>             for (int i = 0; i < 4; i++) {
> 
>                 int next_row = p.x + dir[i][0];
>                 int next_col = p.y + dir[i][1];
> 
>                 if (next_row < 0 || next_col < 0 || next_row >= N || next_col >= N) {
>                     continue;
>                 }
> 
>                 if (map[next_row][next_col] < size && map[next_row][next_col] != 0) {
>                     visited[next_row][next_col] = 1;
>                     if (find_dis == -1) {
>                         find_dis = dis + 1;
>                         find.add(new pos(next_row, next_col, dis + 1));
>                     } else {
>                         if (find_dis == dis + 1) {
>                             find.add(new pos(next_row, next_col, dis + 1));
> 
>                         }
>                     }
>                 } else if (map[next_row][next_col] == size || map[next_row][next_col] == 0) {
>                     if (visited[next_row][next_col] == 0) {
>                         visited[next_row][next_col] = 1;
>                         q.add(new pos(next_row, next_col, dis + 1));
>                     }
>                 }
>             }
>         }
>         int min_x = 20;
>         int min_y = 20;
>         pos ans = null;
>         for (pos a : find) {
>             if (a.x < min_x) {
>                 min_x = a.x;
>                 ans = a;
>                 if (a.y < min_y) {
>                     min_y = a.y;
>                     ans = a;
> 
>                 }
>             }
>         }
>         if (ans != null) {
>             map[ans.x][ans.y] = 0;
>         }
>         return ans;
>     }
> ```
>
> 

