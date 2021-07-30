# Baekjoon 9466 : 텀 프로젝트

## Solution Logic

1. 각 출발점에 대한 dfs()에서 사용할 visited[]과 각 노드를 뒤에 더 탐색할 필요가 있는지 체크하는 finished[] 을 사용한다.

2. 만약 visited = true 라면 순환이 발생하는 노드이다.
    - 순환이 발생 노드는 뒤에서도 더이상 탐색 할 필요가 없다 판단하고 finished값을 true로 한다.
    - 순환이 발생했다는 것은 팀이 있는 사람이 한명 늘어난 것이기 때문에 count++ 해준다.

3. 만약 visited = false 라면 아직 순환이 발생하지 않은 노드이다.
    - 일단 visited = true로 변경해준다.
    
4. 다음 노드에 대해서 finished 값이 false인 경우에 대해서만 dfs탐색을 이어간다.

5. dfs에서 나오게 되면 visited값은 다시 false로 바꿔주고 해당 노드에 대해선 모든 작업이 끝난 것이므로 finished = true로 하여준다. 