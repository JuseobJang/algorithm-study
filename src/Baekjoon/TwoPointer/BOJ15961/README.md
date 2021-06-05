# Baekjoon 15961 : 회전 초밥

## Solution Logic

1. sliding window 기법을 사용한다.

2. coupon은 어떠한 window에서도 포함되므로 해당종류는 항상 있다고 생각한다. (배열에 +1)

3. window를 한칸씩 이동하면서 그때 마다, 새로운 종류가 추가되면 +1, 해당 종류의 갯수가 0 이되면 -1 해준다.