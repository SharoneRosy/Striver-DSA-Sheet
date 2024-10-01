class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String>set=new HashSet<>();
        for(String x:dictionary) set.add(x);
        int [] dp=new int[s.length()+1];

        for(int i=1;i<s.length()+1;i++){
            dp[i]=dp[i-1]+1;
            for(int j=0;j<i;j++){
                if(set.contains(s.substring(j,i))){
                    dp[i]=Math.min(dp[i],dp[j]);
                }
            }
        }
        return dp[s.length()];
    }
}