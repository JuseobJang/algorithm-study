## Interface

**인터페이스 란?**

>인터페이스는 추상적 메서드들의 집합이라고 할 수 있다. 여기서 추상적이라 함은 abstract 를 의미하는데 abstract란 interface 구현시 정의 하지 않고 상속을 받았을 시 무조건 이 해당 메서드를 포함해야하고 그거에 대해서 Override(재정의) 해야한다. 

**인터페이스 사용**

> ```java
> interface A { // interface 선언
>   void exampleMethod(); // abstract 메서드 안의 내용은 정의 하지 않음
> }
> 
> public class B implements A{ // interface A 를 implements 하여 B에 상속시킴
>   @override // 재정의
>   void exampleMethod(){ // interface A 에서 선언한 추상 메서드를 재정의 함
>       return;
>   }
> }
> ```

**인터페이스 특징**

> 인터페이스는 클래스에 상속 시킬 때는 implements를 사용하고 implements 끼리 상속을 할때는 extends 를  사용한다.
> 
> 인터페이스 끼리는 다중 상속이 가능하여 이를 이용하여 클래스에 다중 상속을 할 수 있다.
> 
> example
> ```java
> interface A {
>   methodA();
> }
> interface B {
>   methodB();
> }
> interface C extends A, B {
> }
>
> public class D implements C{
>   @override
>   methodA(){
>       return;
>   }
>   @override
>   methodA(){
>       returnl
>   }
> }
> ```

**클래스 상속과 인터페이스 차이**

>일단 두가지 다 java에서 다형성(polymorphism)을 보여준다. 상속은 중복 코드를 제거하고 심플한 코드 작성이 가능하지만 그만큼 변화가 생긴다면 구조가 깨지기 쉽다. 하지만 프로그램은 현실을 반영하는 것이라 할 수 있는데 현실이 계속 변하는 것 처럼 프로그램도 계속 변화 해야만 한다. 따라서 클래스 상속은 변화가 잘 일어나지 않는 그런 곳에 사용해야 한다. 즉 IS-A 관계가 확실 해야만 한다.
> 따라서 변화에 대응하기 위하여 보통은 interface 상속을 많이 사용한다. interface 상속은 CAN-DO 관계를 따른다. interface는 설계 이후 변화에 대응하는 구조를 만들기 쉽다.
