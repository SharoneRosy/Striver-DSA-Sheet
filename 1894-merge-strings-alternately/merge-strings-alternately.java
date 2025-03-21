class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<Math.max(m,n);i++){
            if(i<m){
                ans.append(word1.charAt(i));
            }
            if(i<n){
                ans.append(word2.charAt(i));
            }
        }
        return ans.toString();
    }
}