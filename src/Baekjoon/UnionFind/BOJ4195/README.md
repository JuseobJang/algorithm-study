## Baekjoon 4195 : 친구 네트워크

### Solution Logic

Union-Find 알고리즘 활용.

1. 이름(문자열)을 Union Find 함수에 적용하기 위해 이름 (key)에 대한 번호(value)를 갖는 해쉬맵을 사용

2. 처음에 모든 사람은 이어져 있지 않으므로 cnt배열을 1로 초기화

3. 만약 union될 때 이미 같은 집합이라면 continue한다.

4. 만약 union될 때 같은 집합이 아니라면, 상위 root가 되는 번호의 cnt배열에 합쳐지는 root의 cnt값을 더해준다.

 