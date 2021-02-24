# Baekjoon 16562 : 친구비

분리 집합(Disjoint Set) : Union Find를 이용하여 해결
> Union Find
> 
> find() 와 merge()로 구성
>
> find(n) :  재귀를 이용해 n과 연결된 노드를 타고 올라가 최상위 root 노드를 찾는다.
>
> ```java
> int find(int n) {
>        if (root[n] == n)
>            return n;
>        else {
>            return find(root[n]);
>        }
> }
> ```
>
> merge(a,b) : a와 b를 연결 한다. b와 연결 되어 있는 최상위 root 노드의 상위 노드를 a의 최상위 root 노드로 설정하여 준다.
>
> ``` java
> void merge(int a, int b) {
>        root[find(b)] = find(a);
> }
> ```

## 논리순서

1. 받은 관계 들에 대해 모두 merge 하여 분리 집합들을 만든다.

2. 각 분리 집합들 중 친구로 사귀는 비용이 가장 싼사람의 값만 더해준다.

3. 위에서 구한 최소 비용보다 가진 돈이 적으면 전부를 친구를 사귈 수 없다.