## Baekjoon 13460 : 구슬탈출2

### 논리의 순서

종료조건 : 10번의 시행을 마치거나 빨간 구슬만 구멍에 들어간 경우

1. 처음 주어진 맵을 토대로 빨간 구슬와 파란구슬, 구멍의 위치를 파악한다.
2. 네가지 방향에 대해 구슬을 굴리면서 위치 정보와 시행횟수를 큐에 넣는다.
3. 파란 구슬이 구멍에 들어간 경우와 빨간구슬과 파란구슬의 위치가 이미 중복된 경우에는 큐에 넣지 않는다.
4. 시행횟수를 한번씩 늘려주면서 만약 빨간구슬의 위치와 구멍의 위치가 일치하면 답을 출력한다.

 문제 자체의 논리를 생각하는 것 보다 , 논리를 구현하는 것이 힘들었던 문제, 처음에 중복을 확인하면서 풀지 않아 맞긴 하였지만 중복을 확인 한것에 비해 몇십배의 메모리 사용량과 시간이 들었다.


### Queue를 이용한 BFS

>```java
>static void bfs() {
>        Queue<ballInfo> q = new LinkedList<ballInfo>();
>        boolean[][][][] visit = new boolean[10][10][10][10];
>        int ans = -1;
>
>        ballInfo start = new ballInfo(0, start_rx, start_ry, start_bx, start_by);
>
>        q.add(start);
>        while (!q.isEmpty()) {
>            ballInfo rb = q.poll();
>            if (rb.count > 10) {
>                break;
>            }
>            if (rb.rx == hx && rb.ry == hy) {
>                ans = rb.count;
>                break;
>            }
>
>            for (int i = 0; i < 4; i++) {
>                int rx = rb.rx;
>                int ry = rb.ry;
>                int bx = rb.bx;
>                int by = rb.by;
>
>                int[] r = tumble(rx, ry, i);
>                int[] b = tumble(bx, by, i);
>
>                rx = r[0];
>                ry = r[1];
>                bx = b[0];
>                by = b[1];
>
>                if (bx == hx && by == hy)
>                    continue;
>                if (rx == bx && ry == by) {
>                    switch (i) {
>                        case 0:
>                            if (rb.rx < rb.bx)
>                                rx--;
>                            else
>                                bx--;
>                            break;
>                        case 1:
>                            if (rb.ry < rb.by)
>                                ry--;
>                            else
>                                by--;
>                            break;
>                        case 2:
>                            if (rb.rx < rb.bx)
>                                bx++;
>                            else
>                                rx++;
>                            break;
>                        case 3:
>                            if (rb.ry < rb.by)
>                                by++;
>                            else
>                                ry++;
>                            break;
>                    }
>                }
>                if (!visit[rx][ry][bx][by]) {
>                    visit[rx][ry][bx][by] = true;
>                    ballInfo next = new ballInfo(rb.count + 1, rx, ry, bx, by);
>                    q.add(next);
>                }
>            }
>        }
>        System.out.println(ans);
>    }
>```



