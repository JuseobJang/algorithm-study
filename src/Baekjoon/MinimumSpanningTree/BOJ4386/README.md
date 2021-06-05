# Baekjoon 4386 : 별자리 만들기

[Baekjoon 16562](../../UnionFind/BOj16562/)의 Union Find 를 사용한다.

## 논리순서

1. 별을 노드, 거리를 가중치라 하고 모든 연결 가능한 경우의 수에 대해서 가중치와 끝 점의 두 노드들을 PriorityQueue에 담는다.

2. PQ 에서 가중치가 적은 순서로 뽑아낸다.

3. 뽑아 냈을 때, 양끝 노드가 이미 이어져 있다면(find(a)== find(b)) continue, 아니라면 두 노드를 이어주고(merge(a,b)) 비용에 가중치를 더해준다.
