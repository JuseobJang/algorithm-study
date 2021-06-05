# Programmers 
## 완전탐색 : 소수찾기

### 논리순서

1. class pair에 노드 중복 방문 방지를 위해 value와 visited를 넣어준다.
2. Depth First Search(dfs)를 이용하여 만들 수 있는 모든 소수를 HashSet에 담아준다. 
    - node의 중복은 pair의 visited로 방지하지만 수의 중복을 방지하기 위해 HashSet을 사용한다.

3. HashSet의 사이즈를 반환해준다.