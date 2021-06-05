

## Baekjoon 2573 : 빙산

### 논리의 순서

종료조건 : 시작점을 잡고 BFS를 통해 구한 빙산의 칸수와 전체 빙산의 칸수가 달라지는 순간이 빙산이 두 덩어리 이상이 된 연수

1. 전체 맵의 정보를 토대로 특정 부분 빙산에 대해 주변에 바다가 몇칸 있는 지를 나타내는 값을 구한다.(이중배열을 사용)

2. 1에서 구한 정보를 이용해 빙산을 녹이고 빙산 중 제일 왼쪽, 위에 있는 빙산을 시작으로 BFS로 탐색하고 몇칸을 차지 하는 지 구한다.

3. 맵에서 빙산이 맵에 전체 몇칸을 차지 하는지 구한다.

4. 2, 3 에서 구한 값을 비교하고 만약 값이 다르다면 빙산은 두 덩어리 이상이 된것이므로 값을 출력한다.

5. 만약 같다면 년 수를 늘리고 위 과정을 반복한다.

   


### Queue를 이용한 BFS

>BFS에서는 보통 Queue 를 많이 사용한다. 추가로 중복을 방지하기 위해 방문 기록을 담아 두는 것이 중요하다.
>
>```java
>static int breadthSearch(int[][] ice, int row, int col, int x, int y) {
>        int iceCount = 0;
>        int[][] breadth = new int[row][col];
>        queue.clear();
>
>        queue.add(new pair(x, y));
>        while (!queue.isEmpty()) {
>            pair node = queue.poll();
>            int visitedX = node.getkey();
>            int visitedY = node.getvalue();
>            if (visitedX == 0 || visitedY == 0) {
>                return -1;
>            }
>            iceCount++;
>            breadth[visitedX][visitedY] = 1;
>            if (ice[visitedX + 1][visitedY] != 0 && breadth[visitedX + 1][visitedY] == 0) {
>                breadth[visitedX + 1][visitedY] = 1;
>                queue.add(new pair(visitedX + 1, visitedY));
>            }
>            if (ice[visitedX][visitedY + 1] != 0 && breadth[visitedX][visitedY + 1] == 0) {
>                breadth[visitedX][visitedY + 1] = 1;
>                queue.add(new pair(visitedX, visitedY + 1));
>            }
>            if (ice[visitedX - 1][visitedY] != 0 && breadth[visitedX - 1][visitedY] == 0) {
>                breadth[visitedX - 1][visitedY] = 1;
>                queue.add(new pair(visitedX - 1, visitedY));
>            }
>            if (ice[visitedX][visitedY - 1] != 0 && breadth[visitedX][visitedY - 1] == 0) {
>                breadth[visitedX][visitedY - 1] = 1;
>                queue.add(new pair(visitedX, visitedY - 1));
>            }
>        }
>        return iceCount;
>    }
>```



