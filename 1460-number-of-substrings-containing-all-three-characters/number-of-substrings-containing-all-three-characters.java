class Solution {
    public int numberOfSubstrings(String s) {
     HashMap<Character,Integer>last=new HashMap<>();
     last.put('a',-1);
     last.put('b',-1);
     last.put('c',-1);
     int cnt=0;
     int n=s.length();
     for(int i=0;i<n;i++){
        char c=s.charAt(i);
        last.put(c,i);
        cnt+=1+Math.min(last.get('a'),Math.min(last.get('b'),last.get('c')));
     }
     return cnt;
    }
}