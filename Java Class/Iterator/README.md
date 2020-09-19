### Iterator

 Iterator란? collection들에 저장되어 있는 값들을 하나씩 읽어 올 수 있게 해주는 class 이다. 



>Get started
>
>```java
>Iterator<Integer> itr = list.iterator();
>```
>
>
>
>Method
>
>```java 
>itr.hasNext() // itr내에 읽어올 요소가 남았는지 boolean으로 반환해줌
>itr.next() // itr내에서 다음 요소를 불러옴 (여기서 요소는 콜렉션에서 삭제 되는 것이 아니라 읽어 오는 것임)
>itr.remove() // itr.next() 에서 불러온 내용을 삭제한다.
>```
>
>
>
>Example
>
>```java
>While(itr.hasNext()){
>  int num = itr.next(); // list 요소가 Integer 라고 가정 
>  System.out.print(num); // list에 있는 모든값이 출력 된다.
>}
>```