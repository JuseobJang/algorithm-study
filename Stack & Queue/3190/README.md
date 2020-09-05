

## Baekjoon 3190 : 뱀

### 논리의 순서

1. 방향 설정 

   방향은 0~ 3 을 사용하여 뱀이 머리를 내밀기 전에 현재 시간과 비교하여 설정해준다.

   0 : x+1

   1 : y-1

   2 : x-1

   3 : y+1 

2. 한칸이동

   현재 머리의 x 와 y 좌표를 가져와 설정된 방향으로 머리를 이동시킨다.

3. 종료조건

   * 뱀의 머리가 가로세로 최대크기(N) 또는 최소크기(0) 를 초과 또는 미만이 되었는 지 확인
   * 현재 Queue에 들어와 있는 나머지 뱀의 몸통의 좌표와 뱀의 머리가 마났는 지 확인

4. 사과 먹기

   만약 종료 조건에 걸리지 않았다면 머리를 내민 칸에 사과가 있는지 없는 지 확인하고 없다면 Queue 를 poll() 해서 마지막을 삭제해주고 있다면 아무런 동작도 하지 않는다.

5. 머리 추가

   Queue 의 처음에 머리의 좌표를 add() 해준다.

**Stack & Queue 이외 사용한 것**

### Iterator

>리스트나 stack & queue 와 같은 collection 에서 요소들을 읽어 온다.
>
>Get Started 
>
>```java
>Iterator<Object> itr = list.iterator();
>```
>
>Method
>
>```java
>public boolean hasnext() // 읽어올 요소가 있는지 확인 함
>public Object next() // Object 를 읽어옴 
>public void remove() // next()로 읽어온 요소 삭제
>```
>
>Using in prob
>```java
>Iterator<Positions> itr; // Positions 객체를 불러오는 iterator 생성
>itr = snake.iterator(); // Queue snake 에서 요소를 불러옴 
>while (itr.hasNext()) { // 요소가 남아 있는지 확인
>                Positions pos = itr.next(); // 불러온 객체를 저장
>                if (head.x == pos.x && head.y == pos.y) // 객체의 변수와 비교
>                    return count;
>}
>```
>



