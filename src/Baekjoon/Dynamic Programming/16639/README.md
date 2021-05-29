# Baekjoon 16639 : 괄호 추가하기

## Solution Logic

1. n개의 숫자가 있고 1 <= i < j <= n 이라고 한다.

2. 연산중 i ~ j 까지 의 연산의 최댓값을 저장하는 배열을 max_dp[i][j]

3. 연산중 i ~ j 까지 의 연산의 최솟값을 저장하는 배열을 min_dp[i][j]

4. 최댓값을 구하는 문제인데 왜 최솟값 정보를 저장하냐면 빼기 연산으로 음수의 값이 나올 수 있고 이로 인해 음수와 음수의 곱셈을 했을 경우 가장 큰 값이 나올 수 있기 때문이다.

5. max_dp[i][j], min_dp[i][j] 를 구하기 위해서는 네가지 조합에 대하여 해당 연산을 진행 해야 한다.(i <= k < j)
   1. max_dp[i][k] , max_dp[k+1][j]
   2. max_dp[i][k] , min_dp[k+1][j]
   3. min_dp[i][k] , max_dp[k+1][j]
   4. min_dp[i][k] , min_dp[k+1][j]

6. 네가지 조합중 제일 큰값을 candidate_max 라하고 제일 작은 값을 candidate_min 이라 하면

7. 기존 max_dp[i][j] 와 candidate_max 비교하여 더 큰 값으로 max_dp[i][j]를 갱신한다.

8. 기존 min_dp[i][j] 와 candidate_min 비교하여 더 작은 값으로 min_dp[i][j]를 갱신한다.

9. 마지막으로 max_dp[1][n] 의 값을 출력하여 준다.