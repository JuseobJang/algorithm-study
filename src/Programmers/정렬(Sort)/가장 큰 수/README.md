# Programmers 
## 정렬(Sort) : 가장 큰 수

### 논리순서

1. Java Library의 Arrays.sort() 의 Comparator을 새로 선언.
2. 새로운 Comparator :
   - 주어진 두 값을 순서를 바꾸어 각각 이어 붙힌다.
   - 둘 중 더 큰 값을 배열의 앞으로 가게 한다.

3. 새로운 Comparator를 이용하여 배열을 정렬한 후 차례로 이어 붙힌다.

```java
Comparator<String> comparator = new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int num1 = Integer.parseInt(sb1.append(o1).append(o2).toString());
        int num2 = Integer.parseInt(sb2.append(o2).append(o1).toString());
        if (num1 > num2) {
            return -1;
        } else {
            return 1;
        }
    }
};
```