## Baekjoon 11723 : 집합

### 논리순서

 1. Int 0 을 선언 후 비트연산을 이용하여 문제를 해결한다.
  2. "all" :  bitset 과 ~bitset을 OR 연산한다.
  3. "empty" : bitset 과 0 을 AND 연산한다.
  4. "add n" : bitset과 1 << (n-1) 을 OR 연산한다.
  5. "remove n" : bitsetdml ~(1 < (n-1))을 AND 연산한다.
  6. "check n" : bitset 과 1 << n-1 의 AND 연산이 0 이아니면 1을 출력 그 외에는 0을 출력한다.
  7. "toggle" : bitset 과 1<<(n-1) 을 XOR 연산한다.
