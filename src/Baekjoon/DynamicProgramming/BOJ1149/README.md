# Baekjoon 1149 : RGB 거리

## Solution Logic

Dynaminc Programming

1. 이 집들은 일렬로 서있다고 볼 수 있기 때문에, 이전 집하고만 색깔이 겹치지 않으면 된다.

2. dp[n][3] 에 대하여 dp[i][j]에서

    i : 집의 번호

    j : 해당 집의 색

3. dp[i][j] = 해당 집을 j 번째 색으로 했을 때 가장적게 드는 비용

4. dp[i][j] = dp[i-1][j 이외 인덱스] 중에 가장 작은값 + 해당 집을 j 번째 색으로 칠하는 비용이다.
