## Set(HashSet)

Set 이란? 말그대로 집합으로서 중복을 허용하지 않고 NULL 값 또한 단 한번만 허용한다.

> Get Started
>
> ```java
> HashSet<car> cars = new HashSet<car>();// 자동차 객체를 넣는 해쉬셋 생성
> ```
>
> Method
>
> ```java
> cars.add(volvo) // volvo 자동차 객체를 set에 추가
> cars.contain(volvo) // volvo가 셋에 포함되어 있는지 확인
> cars.clear() // 셋을 비움
> cars.size() // 셋의 사이즈를 반환해준다.
> cars.remove(volvo) // volvo 제거
> ```