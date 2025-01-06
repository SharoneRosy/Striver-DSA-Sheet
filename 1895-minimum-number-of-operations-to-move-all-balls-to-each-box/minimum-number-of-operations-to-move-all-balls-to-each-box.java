class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int sum=0;
        int right_ones=0;
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                sum+=i;
                right_ones++;
            }
        }
        int res[]=new int[n];
        int prefix_sum=0;
        int left_ones=0;
        for(int i=0;i<n;i++){
            int moves=sum+prefix_sum;
            res[i]=moves;
            if(boxes.charAt(i)=='1'){
                left_ones++;
                right_ones--;
            }
            prefix_sum+=left_ones;
            sum-=right_ones;
        }
        return res;
    }
}