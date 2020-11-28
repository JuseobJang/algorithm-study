## Baekjoon 14002 : 가장 긴 증가하는 부분 수열 4

### 논리순서

1. dp[i] 는 1 부터 i 까지의 증가하는 부분수열의 길이이다.
2. dp[i] 를 구하기 위한 두가지 조건은 아래와 같다.(j < i)
   - arr[j] < arr[i] (arr[i] 보다 작은 수들을 본다.)
   - dp[j] >= dp[i] (수가 작더라도 가장 긴 부분 수열을 찾아야 함)
3.  dp[i] (1<=i<=n) 을 구했다면 그 중 가장 큰 값 max를 찾아준다.
4.  기존 dp 배열 맨 뒤부터 max 와 같은 dp[i]를 찾고 만약 같다면 i 에 해당하는 index를 갖는 배열을 스택에 넣어준다.
5. 그리고 max 값을 1 줄인다.
6. 그 다음은 dp의 맨 뒤부터가 아닌 해당 i 보다 작은 인덱스 부터 하나씩 줄여 가며 다시 탐색한다.(반복)


```java
// dp 배열 구하기
for (int i = 1; i <= n; i++) {
    dp[i]++;
    for (int j = 1; j <= i; j++) {
        if (arr[j] < arr[i] && dp[j] >= dp[i]) {
            dp[i] = dp[j] + 1;
        }
    }
}
// 최댓값 찾기
int max = 0;
for (int i = 1; i <= n; i++) {
    max = Math.max(max, dp[i]);
}
// 역추적해가며 해당하는 부분배열 찾기
int num = max;
for (int i = n; i >= 1; i--) {
    if (num == dp[i]) {
        stk.push(arr[i]);
        num--;
    }
}

```