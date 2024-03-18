class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int i=0;
        int max_count=0;
        int max_length=0;
        int [] count=new int[26];
        for(int j=0;j<n;j++){
            count[s.charAt(j)-'A']++;
            int curr_count=count[s.charAt(j)-'A'];
            max_count=Math.max(max_count,curr_count);
            if((j-i-max_count+1)>k){
                count[s.charAt(i)-'A']--;
                i++;
            }
            max_length=Math.max(max_length,j-i+1);
        }
        return max_length;
    }
}