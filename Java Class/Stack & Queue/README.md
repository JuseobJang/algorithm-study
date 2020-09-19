## Stack & Queue

### Stack

> Get Started 
>
> ```java
> Stack<Element> stack = new Stack<>();
> ```
>
> Method
>
> ```java
> public Object push(Object element); // 데이터를 맨위 추가
> public Object pop(); // 맨위의 데이터를 뺀다
> public Object peek(); // 맨위의 데이터 조회
> public boolean empty(); // stack이비었는지 확인 비었으면 true 아니면 false 반환
> public int search(Object element); //element의 위치 반환 제일 위(최근)부터 0 반환
> ```
>



### Queue

>Get Started using LinkedList
>
>```java
>Queue<Positions> queue = new LinkedList();
>```
>
>Method
>
>```java
>public boolean add(Object element) // 데이터를 맨뒤 추가(저장공간 부족시 예외 발생)
>public Object remove() // queue 맨뒤 데이터를 제거하고 반환
>public Object element() // queue 맨뒤 데이터를 반환(삭제하지 않고 비었을때 예외 발생)
>public boolean offer(Object element) // 데이터를 맨뒤 추가 성공시 true 실패시 false
>public Object poll() // queue 맨뒤 데이터를 반환 비었으면 null
>public Object peek() // queue 맨뒤 데이터를 반환(삭제하지 않고 비었을때 null 반환)
>```
>