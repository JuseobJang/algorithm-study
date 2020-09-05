

## Baekjoon 1406 : 에디터

### 논리의 순서

커서의 위치를 기준으로 왼쪽 과 오른쪽 Stack 을 각각 생성한다.

1. P $

   왼쪽 스택에 $에 해당하는 값을 push() 한다.

2. B

   왼쪽 스택이 비어 있지 않다면 왼쪽 스택의 맨위를 pop()해준다.

3. L

   왼쪽 스택이 비어 있지 않다면 왼쪽 스택의 맨위를 pop()해서 오른쪽 스택에 push() 해준다.

4. D

   오른쪽 스택이 비어 있지 않다면 오른쪽 스택의 맨위를 pop()해서 왼쪽 스택에 push() 해준다.

출력 : 왼쪽 스택을 맨위부터 차례로 오른쪽 스택에 push()해준 후 오른쪽 스택의 

​		맨위부터 차례로 출력한다.



**Stack & Queue 이외 사용한 것**

### BufferReader 과 spilt()

>  일반적으로 Scanner 를 사용하여 입력을 받으나 데이터의 양이 많을 떄는 BufferReader 를 사용하는 것이 훨씬 빠르다. 하지만 BufferReader는 항상 한줄 단위와 문자열을 받기 때문에 띄어쓰기와 다른 타입에 대해서는 입력을 받은 후 따로 가공을 해주어야 한다.
>
>  BufferReader를 사용하여 받은 후 여러 방법으로 가공할 수 있는데 여기서는 split() 을 사용하여 "abcd" 로 들어온 문자열을 "a" ,"b", "c", "d" 로 쪼개서 배열에 담았다.
>
> Get Started 
>
> ```java
> BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
> ```
>
> Parsing
>
> ```java
> String[] str = br.readLine().split(""); // 문자열을 쪼개 배열에 담음
> Integer.parseInt(br.readLine()); // 문자열로 들어온 숫자를 int 타입으로 파싱해줌
> ```




