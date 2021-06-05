## Baekjoon 11048 : 이동하기

### 논리순서

1. mat[i][j] 에 올 수는 mat[i-1][j], mat[i][j-1], mat[i-1][j-1] 중 가장 큰 수와 기존 mat[i][j]를 더한 수 라고 할 수 있따.
2. 즉 mat[i][j] = max(mat[i-1][j], mat[i][j-1], mat[i-1][j-1]) + mat[i][j] 이다.
3. 이렇게 해서 마지막 mat[n][m]을 찾으면 된다.


```java
for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int max = Math.max(mat[i - 1][j - 1], mat[i - 1][j]);
                mat[i][j] = Math.max(mat[i][j - 1], max) + mat[i][j];
        }
}
```