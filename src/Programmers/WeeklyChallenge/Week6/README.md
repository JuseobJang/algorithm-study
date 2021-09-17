# Programmers

## Weekly Challenge : Week6 복서 정렬하기

### Solution Logic

1. 상대 선수와 경기 결과를 저장하기 위한 Record Struct 구현

2. 각 선수의 정보와 전적들(Record)을 저장하기 위한 Boxer Struct 구현

3. Boxer Struct 는 sort() 메서드를 사용하기 위해 문제 조건에 맞춰 Comparable Protocol 구현

4. Boxer 배열과 모든 Record를 기록하면 각 Boxer의 승률과 본인 무게 보다 무거운 선수를 이긴 기록을 구함

5. sort() 메서드를 사용하여 정렬 후 id 를 배열로 반환