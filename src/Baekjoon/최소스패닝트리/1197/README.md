# Baekjoon 1197 : 최소 스패닝 트리

[Baekjoon 16562](../../분리집합/16562/)의 Union Find 를 사용하여 이어져 있는지 아닌지 판별.

## Solution Logic

1. Priority Queue를 사용하여 가장 거리가 짧은 Edge순으로 뽑는다.

2. 해당 Edge의 시작과 끝이 이어져 있지 않다면 이어주고 sum을 weight만큼 더해준다.

3. 모든 Edge를 탐색할 때까지 위 과정을 반복한다.
