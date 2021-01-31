## Baekjoon 11066 : 파일 합치기

### 논리순서

1. j<= s <= i 이고, sum[i]는 처음부터 i 번째 까지 수를 합친 값이다.
2. sum[i] - sum[j-1] 는 index j ~ i 까지의 숫자들을 합친 값이라 할 수있다. 
3. dp[j][i] = min(dp[j][s] + dp[s+1][i] + (sum[i] - sum[j-1]) )

```java
for (int i = 2; i <= n; i++) {
    for (int j = i - 1; j > 0; j--) {
        dp[j][i] = max;
        for (int s = j; s <= i; s++) {
            dp[j][i] = Math.min(dp[j][i], dp[j][s] + dp[s + 1][i]);
        }
        dp[j][i] += sum[i] - sum[j - 1];
    }
}
```




