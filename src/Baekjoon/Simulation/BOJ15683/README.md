# Baekjoon 15683 : 감시

## Solution Logic

DFS를 이용한다.

1. 각각의 CCTV를 depth라 하고, CCTV의 방향을 노드로 한다.

2. DFS를 사용하여 모든 CCTV를 다 돌았을때(depth == CCTV 개수) map 배열에서 체크 되지 않은 원소의 갯수를 센다.

3. 이 중 가장 적은 값을 답으로 한다.