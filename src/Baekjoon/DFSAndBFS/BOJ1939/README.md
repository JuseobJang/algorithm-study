# Baekjoon 1939 : 중량 제한

## Solution Logic

1. 일단 중량 제한 중 가장 큰 값(max)을 찾는다.

2. 1 ~ max 를 범위로 하여 Binary Search 를 한다.

3. Binary Search의 mid 값으로 출발지부터 목적지까지 가는게 가능한지 BFS를 통해 확인한다.

4. 만약 가능하다면 현재 ans 값과 mid 값중 더 큰 값으로 ans값을 갱신한다.
