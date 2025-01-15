class Solution {
    public String minWindow(String s, String t) {
        int n=s.length(),m=t.length();
        int min=Integer.MAX_VALUE;
        int cnt=0;
        int startIdx=-1;
        int l=0,r=0;
        HashMap<Character,Integer>seen=new HashMap<>();
        for(char c:t.toCharArray()){
            seen.put(c,seen.getOrDefault(c,0)+1);
        }
        while(r<n){
            if(seen.getOrDefault(s.charAt(r),0)>0) cnt++;
            seen.put(s.charAt(r),seen.getOrDefault(s.charAt(r),0)-1);
            while(cnt==m){
                if(r-l+1<min){
                    min=r-l+1;
                    startIdx=l;
                }
                seen.put(s.charAt(l),seen.getOrDefault(s.charAt(l),0)+1);
                if(seen.get(s.charAt(l))>0) cnt--;
                l++;
            }
            r++;
        }
        return (startIdx==-1)?"":s.substring(startIdx,startIdx+min);
    }
}