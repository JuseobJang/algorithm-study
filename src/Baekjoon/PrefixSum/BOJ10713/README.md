# Baekjoon 10713 : 기차여행 

## Solution Logic

1. 각 길마다 (현금 비용) * 이용 횟수 , (카드 비용) * 이용 횟수 + (IC카드 구매 비용) 중 더 작은 값을 선택하면 된다.

2. 여기서 모든 이용횟수를 제외한 모든 값은 구해져 있기 때문에 이용횟수만 구하면 된다.

3. 아래와 같은 방법으로 다음 길이 이전길에 비해 얼만큼 늘어나는지에 대한 정보를 담아준다.
> ```java
> for i in 0..<path.count-1 {
>            let s : Int = Swift.min(path[i], path[i+1])
>            let l : Int = Swift.max(path[i], path[i+1])
>            
>            counts[s] += 1
>            counts[l] -= 1
>        }
>```

4. 따라서 각 길당 이용횟수는 이전 길 이용횟수 + counts[i]라고 할 수 있다