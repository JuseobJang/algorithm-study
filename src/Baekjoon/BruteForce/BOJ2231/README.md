## Baekjoon 2231 : 분해합

### 논리순서

1. 주어진 숫자의 자수를 구한다.

2. 각 자리수에 올 수 있는 최댓값은 9 이기 때문에 (9 * 자릿수) 만큼을 주어진 수에서 빼준다.

3. 해당 수 부터 분해합을 구해서 원래 주어진 숫자가 나오는지 체크한다.

4. 만약 처음 주어진 숫자가 나온다면 해당 값을 출력해주고 아니라면 -1을 출력한다. 