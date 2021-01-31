## Hash

* 연관 배열 구조 key - value 이 1:1 로 맵핑 되어 있는 구조
* 장점 : 해쉬테이블을 이용한 삽입, 삭제, 탐색이기 때문에 평균적으로 O(1)의 시간 복잡도를 가지고 있다.
* 단점 : 
 1. 해쉬 충돌 발생 가능성이 존재.
 2. 순서 또는 관게가 있는 배열에선 쓰기 힘듬
 3. 공간 효율성이 떨어짐
 4. hash function의 의존도가 높다. 평균 시간 복잡도는 O(1)이지만 hash function이 복잡해 질 경우 해쉬 테이블 연산속도가 엄청 늘어난다. 

> **key**
> hash function의 인풋으로 작용함
> 키값을 일정한 크기의 해시로 변경하여 저장소에 저장한다.
> 
> **hash function**
> * 인풋으로 들어온 key를 고정된 hash 로 변경해주는 역할, hashing 이라고 한다.
> * 서로 다른 키값이 같은 hash 값을 가질 수 있는데 이걸 해쉬 충동이라고 한다.
> 
> **value**
> 저장소에 최종적으로 hash와 매칭 되어 저장되는 값
>
> **hash table**
> * hash function 을 거쳐 key에 hash로 변환 한 값을 index삼아 value와 함께 저장하는 자료구조
> * 데이터(value)저장 위치를 버킷 또는 슬롯 이라 명칭함.
> * hash table 의 기본 연산은 삽입, 삭제 , 탐색이다.

Hash 를 이용한 java class
- [HashMap](https://github.com/wntjq68/algorithm-learn/tree/master/Java%20Class/HashMap)
- [HashSet](https://github.com/wntjq68/algorithm-learn/tree/master/Java%20Class/HashSet)



