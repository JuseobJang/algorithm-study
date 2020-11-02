## Override & Overload

**Override**
> 상위 클래스의 메소드를 하위 클래스로 상속할 때, 상위 클래스의 메소드를 그대로 쓸 수 도 있지만 하위 클래스에서 새로 재정의 할 수 도 있다. 이것을 **override** 라고 부른다. 
>
>Example
>
> ```java
> public class Person{
>   public void walk(){
>       // something
>   }
> }
> public class Student extends Person{
>   @Override
>   public void walk(){
>       // something change!
>   }
> } 
> ```

**Overload**
> 같은 명을 같은 메소드이지만 매개변수의 숫자나 타입에 따라 다른 동작을 하는것을 **Overload** 라고 부른다.
>
>Example
>
> ```java
> public class Person{
>   public void talk(){
>       // 혼잣말
>   }
>
>   @Overload
>   public void talk(Person a){
>       // Person a 와 이야기
>   }
> }
> ```
