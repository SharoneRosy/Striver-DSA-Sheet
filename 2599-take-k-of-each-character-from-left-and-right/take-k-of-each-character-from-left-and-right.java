class Solution {
    public int takeCharacters(String s, int k) {
        int n=s.length();
        int [] arr=new int[3];
        for(char ch:s.toCharArray()) arr[ch-'a']++;

        if(arr[0]<k || arr[1]<k || arr[2]<k) return -1;

        int left=0,right=0;
        int minwindow=n;

        while( right<n){
            arr[s.charAt(right)-'a']--;
            while(left<=right && arr[0]<k || arr[1]<k || arr[2]<k){
                arr[s.charAt(left)-'a']++;
                left++;
            }
            minwindow=Math.min(minwindow,n-(right-left+1));
            right++;
        }
        return minwindow;
    }
}