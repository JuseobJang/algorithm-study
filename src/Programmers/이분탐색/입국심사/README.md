# Programmers

## 이분탐색 : 입국심사

### Solution Logic

1. left = times 의 최솟값, right = times 최댓값 \* n 으로 하여 이분 탐색한다.

2. 만약 mid(시간)가 현재 times로 가능한지 판단한다.

   - mid / times[i] 는 주어진 시간(mid)내에 i 번째 직원 심사 사능한 사람 수이다.

   - 즉, sum(mid/ times[i]) 는 주어진 시간(mid)내에 가능한 최대 인원이다.

   - 주어진 시간내에 n 이 최대 인원 보다 작거나 같으면 해당 시간은 가능한 것으로 판단한다.

3. 가능하다고 판단하면 시간의 최솟값을 찾는것이기 때문에 right = mid - 1 , 반대 경우 left = mid + 1한다.

4. 만약 현재 가지고 있는 최솟값(ans)보다 해당 mid가 더 작다면 ans = mid 가 된다.
