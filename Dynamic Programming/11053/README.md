## Baekjoon 11053 : 가장 긴 증가하는 부분 수열

### 논리순서

1. dp[i] 는 1 부터 i 까지의 증가하는 부분수열의 길이이다.
2. dp[i] 를 구하기 위한 두가지 조건은 아래와 같다.(j < i)
   - arr[j] < arr[i] (arr[i] 보다 작은 수들을 본다.)
   - dp[j] >= dp[i] (수가 작더라도 가장 긴 부분 수열을 찾아야 함)


```java
for (int i = 1; i <= n; i++) {
    dp[i]++;
    for (int j = 1; j <= i; j++) {
        if (arr[j] < arr[i] && dp[j] >= dp[i]) {
            dp[i] = dp[j] + 1;
        }
    }
}
```