## Map(HashMap)

맵이란 일반적인 리스트와 다르게 특정 Key 와 그에 해당 하는 Value 를 통해 값을 저장하고 자료구조이다. 

일반 Key의 값은 중복으로 들어가지 않게 한다.

> Get Started
>
> ```java
> HashMap<Key, Value> map = new HashMap<Key, Value>();
> ```
>
> Method
>
> ```java
> map.put(key,value) // key-value 쌍을 해쉬맵에 추가한다.
> map.get(key) // key값을 통해 value를 가져온다.
> map.clear() // map을 비운다.
> map.size() // map의 현재 사이즈를 구한다. map의 (key-value)쌍의 갯수를 구한다.
>   
> for( key : map.keySet()){ 
>   System.out.println(key) //for문과 keySet()을 이용하여 모든 키값을 구할 수 있다.
> }
> 
> for( value : map.values()){
>   System.out.println(value) //for문과 values()를 이용하여 모든 value값들을 구할 수 있다.
> }
> ```
>
> 