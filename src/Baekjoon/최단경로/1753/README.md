# Baekjoon 1753 : 최단경로

다익스트라 알고리즘 사용

1. 문제조건의 메모리 제한을 고려하여 경로들을 인접 리스트에 닮음

2. 현재 노드에서 다음 노드(v)로 갈때 드는 가중치(weight)를 담은 구조체 Node를 Priority Queue에 넣음

3. 이 Priority Queue는 Node 들중 Weight가 가장 작은 값이 Priority가 가장 높다.

4. 큐에 두 시작 인덱스로 가는 가중치는 0 을 의미 하는 Node(start,0)을 넣고 시작한다.

5. 큐에서 가장 작은 가중치를 갖는 노드를 poll() 하여 방문한적이 없다면 현재 방문 노드로 하고 방문을 체크 하여준다.

6. 현재 노드(cur)에서 갈 수 있는 다른 노드들(next) 중 기존에 있던 next까지 가는 거리(dist[next.v])와 현재 노드를 거쳐 next까지 가는 거리(dist[cur.v] + next.weight) 중 더 작은 것을 dist[next.v]에 넣는다.

7. 또한 dist 값이 변한다면 큐에 Node(next.v, dist[next.v]) 를 add() 하여준다.

8. 모든 노드를 방문 할 때까지 5, 6, 7 과정을 반복한다.