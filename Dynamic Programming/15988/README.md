## Baekjoon 15988 : 1,2,3 더하기 3

### 논리순서

1. dp[n] 에는 n 을 1,2,3 을 사용해 만들수 있는 방법의 수가 들어간다.
2. dp[1],dp[2],dp[3] 까지는 규칙이 적용 되지 않기 때문에 값을 직접 넣어준다.
3. dp[n](n>3) 부터는 1 + (n-1) , 2 + (n-2), 3 + (n-3)으로 나타낼 수 있다.
4. 따라서 n-1 , n-2, n-3 일 때의 방법의 수를 더하면 된다. 즉, dp[n-1]+dp[n-2]+dp[n-3]
5. Baekjoon 9095 : 1,2,3 더하기와 같은 순서와 논리이지만 수의 범위가 늘어나는 것이라 dp[]의 타입을 long으로 하고, 1000000까지 받을 수 있도록 하고 결과 마다 1000000009를 나누어 준다. 

```java
for (int test = 0; test < t; test++) {
    int n = Integer.parseInt(br.readLine());
    for (int i = 4; i <= n; i++) {
        for (int j = 1; j <= 3; j++) {
            if (dp[i][j] != 0) {
                continue;
            }
            if (j == 1) {
                dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
            } else if (j == 2) {
                dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
            } else {
                dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
        }
    }
}
System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % mod);
```