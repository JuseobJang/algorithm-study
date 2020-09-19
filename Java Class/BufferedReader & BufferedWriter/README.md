## BufferedReader & BufferedWriter

### BufferedReader 과 spilt()

>  일반적으로 Scanner 를 사용하여 입력을 받으나 데이터의 양이 많을 떄는 BufferReader 를 사용하는 것이 훨씬 빠르다. 하지만 BufferReader는 항상 한줄 단위와 문자열을 받기 때문에 띄어쓰기와 다른 타입에 대해서는 입력을 받은 후 따로 가공을 해주어야 한다.
>
>  BufferReader를 사용하여 받은 후 여러 방법으로 가공할 수 있는데 여기서는 split() 을 사용하여 "abcd" 로 들어온 문자열을 "a" ,"b", "c", "d" 로 쪼개서 배열에 담았다.
>
>  Get Started 
>
>  ```java
>  BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
>  ```
>
>  Parsing
>
>  ```java
>  String[] str = br.readLine().split(""); // 문자열을 쪼개 배열에 담음
>  Integer.parseInt(br.readLine()); // 문자열로 들어온 숫자를 int 타입으로 파싱해줌
>  ```
>
>  StringTokenizer 를 활용 해서도 쪼갤 수 있는데 개인 적으로 split() 함수가 더 간단하여 많이 사용하게 된다.



### BufferedWriter

>Get Started
>
>```java
>BufferedWriter bw = new BufferedWriter( new InputStreamReader(System.out));
>```
>
>Method
>
>```java
>bw.write("Juseob"); // 버퍼에 문자열을 쓴다.
>bw.newLine(); // 개행을 추가한다.
>bw.flush(); // 스트림을 비운다
>bw.close(); // 스트림을 닫는다.
>```



