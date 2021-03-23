# Programmers

## 해시 : 베스트앨범

### Solution Logic

genres 와 plays 를 동시에 돌면서 map1<genre, play> 를 구해 genre 별로 가장 많이 재생된 장르를 찾는다.

1. 그 다음 가장 많이 재생된 장르를 map1에서 가져온 후 해당 장르 정보는 map1에서 지워준다.

2. genres 와 plays를 돌면서 그 장르에 해당하는 노래에 대해 번호와 재생수를 map2<num, play> 담는다.

3. map2 에서 재생수가 큰 순서대로 2번 출력 해주고 만약 1개라면 1번만 출력해준다.

위 1,2,3 과정을 map1이 비워질때 까지 반복한다.
