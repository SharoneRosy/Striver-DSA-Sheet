class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<>(wordList);
    
    if(!set.contains(endWord)) return 0;
    
    Queue<String> q = new LinkedList<>();
    q.add(beginWord);
    
    int res = 1;
    
    while(!q.isEmpty()) {
        int size = q.size();
        
        for(int i = 0; i < size; i++) {
            String word = q.poll();
             if(word.equals(endWord)) return res;
            
            for(int j = 0; j < word.length(); j++){
                for(char k = 'a'; k <= 'z'; k++)  {
                    char arr[] = word.toCharArray();
                    arr[j] = k;

                    String str = new String(arr);
                    
                    if(set.contains(str)) {
                        q.add(str);
                        set.remove(str);
                    }
                }
            }
        }
        
        ++res;
    }
    
    return 0;    
}
    }
