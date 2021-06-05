## Baekjoon 14426 : 접두사 찾기

### 논리순서

1. 트라이 구조를 이용한다.
2. 각각의 문자열을 char단위를 key로 삼아 트라이에 추가한다.
3. 주어진 접두사를 포함하는 문자열을 검색한다.
   - 접두사는 앞에서 부터 시작 하기때문에 앞에서 부터 검사하면서 한 char라도 포함하지 않으면 바로 return false 해서 검색을 끝낸다.
  
> **Trie(트라이)란?**
> - 트라이는 문자열 검색을 효율적으로 하기위한 트리형 자료구조 이다. ex) 자동완성 기능, 문자 검색 기능
> - 노드의 마지막에 끝을 표시하는 변수를 만들어 끝을 표시 할 수 있다.
>
> 트리의 rootNode는 빈 Node로 시작한다. 그리고 그 밑에 자식 노드 부터는 기본적으로 HashMap<key, value> 과 끝을 표시하는 변수로 이루어 진다. HashMap의 key 값은 알파벳이고 value는 그 다음 트리의 노드를 가르킨다. 그리고 각각의 노드는 자신의 자식노드를 확인 그리고 해당 노드가 마지막 노드인지 확인하고 설정하는 getter & setter 메소드를 가지고 있다.
> 
> ```java
>  public static class TrieNode {
>        private Map<Character, TrieNode> childNodes = new HashMap<>();
>        private boolean isLastChar;
>
>        Map<Character, TrieNode> getChildNodes() {
>          return this.childNodes;
>        }
>
>        boolean isLastChar() {
>            return this.isLastChar;
>        }
>
>        void setIsLastChar(boolean isLastChar) {
>            this.isLastChar = isLastChar;
>        }
>  }
> ```
> 트라이가 인스턴스로서 생성이 되면 기본적으로 rootNode를 가지고 생성 된다. 그리고 그 다음 부터 추가 메소드로 부터 원하는 문자열을 추가한다.
> 
> 문자열을 추가 할때는 node를 위에서 부터 검색하면서 해당 key(char)를 가진 자식노드가 있으면 그 자식노드 부터 다음 char를 추가할지 정하고 만약에 없다면 해당 key를 가진 자식노드를 만들고 그 자식 노드 부터 char를 추가할 지 정한다. 
> 
> 밑의 주석의 contain()은 부분 포함이 아닌 전체 포함으로 자식 노드를 순서대로 검색중 한번이라도 틀리면 다른 단어이기 때문에 return false를 하여 검색을 종료 하고 만약 검색이 끝났을 때에 Node가 마지막 Node가 맞다면 true 아니라면 false를 반환한다.
> ```java
> public static class Trie {
>    private TrieNode rootNode;
>
>    Trie() {
>        this.rootNode = new TrieNode();
>    }
>
>    void insert(String word) {
>        TrieNode thisNode = this.rootNode;
>        for (int i = 0; i < word.length(); i++) {
>            char key = word.charAt(i);
>            TrieNode node = thisNode.getChildNodes().get(key);
>            if (node == null) {
>                thisNode.getChildNodes().put(key, new TrieNode());
>            }
>            thisNode = thisNode.getChildNodes().get(key);
>        }
>        thisNode.setIsLastChar(true);
>    }
>
>    boolean contain(String word) {
>        TrieNode thisNode = this.rootNode;
>        for (int i = 0; i < word.length(); i++) {
>            char key = word.charAt(i);
>            TrieNode node = thisNode.getChildNodes().get(key);
>            if (node == null)
>                return false;
>            thisNode = node;
>        }
>        return thisNode.isLastChar();
>    }
>}