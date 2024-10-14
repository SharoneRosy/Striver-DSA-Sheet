class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int cnt=0;
        for(char key:map.keySet()){
            cnt+=map.get(key)%2;
        }
        return cnt<=1;
    }
}