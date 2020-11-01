### Modifier

**Super Class**가 **Sub Class** 에게 inheritance(상속)을 하기 위해 존재하는 세가지 타입의 Modifier. 
Pure virtual, Virtual, Non-virtual이고 이것을 JAVA 내에서는 각각 abstract, (default), final 로 명명한다.

**Pure virtual(abstract)**
> 보통 Interface를 구성 할 때 사용 하는 이 타입은 슈퍼클래스에서는 이 메소드에 대해 명시만 할뿐 정의는 상속 받은 자식 클래스에서 진행하며 선택이 아니라 무조건 정의를 해줘야 한다.

**Virtual(default)**
> 일반적을 상속시 따로 명시를 안해주면 Virtual 타입이 된다. 슈퍼클래스에서 메소드에 대해 명시도 하고 정의 까지 해놓는다. 
>
> 그렇지만  서브 클래스에서 필요시, **Overriding**을 활용 하여 메소드를 재정의 할 수 있다.

**Non-virtual(final)**
> 슈퍼 클래스에서 메소드에 대한 명시와 정의를 다 맡아서 하고 서브 클래스에서 이 메소드에 대해 재정의 할 수 없다. 그렇기 때문에 이 타입을 사용하면 컴파일시 static binding 이 일어난다. 




