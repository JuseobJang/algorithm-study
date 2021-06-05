# Baekjoon 16398 : 행성 연결

크루스칼 알고리즘을 사용하는 가장 기본적인 MST 문제이다.

[Baekjoon 16562](../../UnionFind/BOj16562/)의 Union Find 를 사용하여 사이클을 확인한다.

## 논리순서

1. 각 간선을 기준으로 u(start) , v(end), cost 를 Priority Queue에 넣는다.

2. 해당 pq 는 cost기준으로 오름 차순으로 원소를 정렬한다.

3. 간선을 뽑아서 시작점과 끝점을 연결 했을 떄 싸이클이 생기지 않는다면 두 점을 이어 주고 해당 cost를 비용에 더해준다.
