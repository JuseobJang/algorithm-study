# Baekjoon 11404 : 플로이드

플로이드 워셜 알고리즘 사용

1. Dynamic Programming 의 형태이다

2. dist[i][j]는 현재까지 갱신된 i -> j 노드 까지의 최단 경로이다.

3. 경유지를 k 라 할때 기존 dist[i][j]와 k 를 경유하는 dist[i][k] + dist[k][j] 를 비교하여 더 작은 값을 dist[i][j]에 갱신하여 준다.

4. 따라서 DP이기 때문에 **dist[i][j] = min(dist[i][j] , dist[i][k] + dist[k][j])** 점화식을 사용하여 매번 갱신한다.
