# Baekjoon 2559 : 수열

## Solution Logic

1. 주어진 수열의 갯수 : N, 연속된 값의 갯수 : K 라고 하면 구하고자하는 구간별 합 `sum[]` 배열 크기는 (N - K + 1) 이다.
2. 우선적으로 누적합을 사용하기 위해  `sum[0]` 값은 `arr[0] ~ arr[K-1]` 을 더한 값으로 설정한다.
3. 슬라이딩 윈도우를 활용하여 각 `sum[]` 의 요소는 직전 값에서 기존 윈도우의 첫번째 값을 빼주고 새로 윈도우에 들어오는 값을 더해준다.
4. `sum[]` 에서 가장 큰 값을 출력한다.

