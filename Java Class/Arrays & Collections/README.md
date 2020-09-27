## Arrays & Collections

**Arrays 와 collections 의 차이**

Arrays는 생성시 사이즈가 고정되어 상황에 따라서 크기를 줄이거나 늘리거나 하는 것이 불가능 하지만 Collections는 필요에 따라 사이즈를 늘리거나 줄이거나 할 수 있다.



### Arrays

> method
>
> ```java
> Arrays.asList(arr); //배열을 ArrayList로 전환함
> Arrays.sort(arr) // 기본 오름차순 정렬
> Arrays.sort(arr,Collections.reverseOrder()) // Comparator 를 사용한 내림차순 정렬
> Arrays.sort(arr,start_index, end_index) // start_index부터 end_index까지 오름차순 정렬
> Arrays.sort(arr.start_index,end_index,Collections.reverseOrder()) // // start_index부터 end_index까지 내림 차순 정렬
> Arrays.copyOf(arr,newlength) // 배열을 특정 사이즈 만큼 복사함
> Arrays.toString(arr) // arr을 String 형으로 전환해줌
> 
> ```



### Collections

>method
>
>```java
>List<Integer> list = {1,2,3,4}
>Collections.max(list) // 최댓값 반환
>Collections.min(list) // 최솟값 반환
>Collections.sort(list) // 오름차순으로 정렬
>Collections.shuffle(list) // 랜덤으로 값들을 섞어줌
>Collections.binarySearch(list,value) // IndexOf 역할 , value 에 해당 하는 인덱스를 반환
>Collections.reverse(list) // 순서를 반대로 뒤집어줌
>```
>
>
>
>
>
>