class Solution {
    public String largestNumber(int[] nums) {
   

        String s[]=new String[nums.length];
        for(int i=0;i<nums.length;i++) {
            s[i]=Integer.toString(nums[i]);
        }
        Arrays.sort(s,(a,b)->(b+a).compareTo(a+b));
        StringBuilder res=new StringBuilder();
        for(int i=0;i<nums.length;i++){
            res.append(s[i]);
        }
        return res.charAt(0)=='0'?"0":res.toString();
    }
}