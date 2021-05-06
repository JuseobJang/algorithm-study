# Programmers

## 2020 KAKAO BLIND 인턴십 : 수식 최대화

### 논리 순서

1. calc(operation, formula) : formula 에서 해당 operation 이 존재한다면 해당 operation 의 양옆에 있는 숫자들에 대해 연산을 진행해주고 해당 operation과 양옆 수는 formula에서 지워주고 그 자리에 결과를 넣어준다.

2. 가능한 연산 + , - , * 세가지 이므로 우선 순위를 매기는 6가지 경우에 대해 연산을 진행 합니다.

3. 해당 결과값 중 가장 큰 값을 반환합니다.
