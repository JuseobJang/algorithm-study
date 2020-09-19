## StringBuilder

StringBuilder 와 비슷하게 사용되는 것은 StringBuffer 이다. 둘은 거의 비슷하게 작동하지만 한가지 큰 차이점이 존재하다 StringBuilder의 경우는 단일 쓰레드를 사용하여 동기적으로 작동하지만(동시 처리 불가) StringBuffer 의 경우 멀티 쓰레드를 사용하기 때문에 비동기적으로(동시처리가능) 작동한다.

StringBuilder는 String 과 다르게 문자열을 변경하거나 조작하기가 간편하다.

>Get started
>
>```java
>StringBuilder sb = new StringBuilder("Juseob");
>```
>
>String 과 동일한 Method
>
>```java
>sb.charAt(index) //index 위치의 문자(char)반환
>sb.indexOf(char) //문자열 내에서 해당 문자가 처음 나오는 인덱스 반환
>sb.length() //문자열 길이 반환
>sb.replace(String, String) //앞에 인자 문자열을 뒤에 인자 문자열로 치환함 
>sb.subString(index,index) // 특정 범위 내의 문자열을 가지고 새로 인스턴스 생성  
>```
>
>Method
>
>```java
>sb.append(String) // 뒤에 문자열을 더함
>sb.delete(index,index) // 특정 범위의 문자열을 삭제함
>sb.insert(index,String) // 특정 인덱스에 문자열 삽입  
>```

