

## Baekjoon 3190 : 뱀

 Stack & Queue 이외 사용한 것

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



