## Baekjoon 1463 : 1로 만들기
### 논리순서

1. dp[n] = 주어진 연산을 통해 n을 만들 수 있는 최소 횟수.
2. 일단 dp[n] = dp[n - 1] + 1 로 세가지 연산중에 -1 을 통해 n-1 에서 오는 횟수를 계산 한다.
3. 그 다음 2 또는 3으로 나누어 지는 지 확인하여 해당 연산을 진행한다.
   - dp[n] = min(dp[n],dp[n/2] + 1) 
   - dp[n] = min(dp[n],dp[n/3] + 1)

```java
dp[0] = dp[1] = 0;
dp[2] = dp[3] = 1;
for (int i = 4; i <= x; i++) {
    dp[i] = dp[i - 1] + 1;
    if (i % 2 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 2] + 1);
    }
    if (i % 3 == 0) {
        dp[i] = Math.min(dp[i], dp[i / 3] + 1);
    }
}
```