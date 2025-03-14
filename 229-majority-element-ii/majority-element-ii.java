class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int e1=Integer.MIN_VALUE,e2=Integer.MIN_VALUE;
        int cnt1=0,cnt2=0;
        for(int i:nums){
            if(cnt1==0 && i!=e2){
                cnt1=1;
                e1=i;
            }else if(cnt2==0 && i!=e1){
                cnt2=1;
                e2=i;
            }else if(i==e1){
                cnt1++;
            }else if(i==e2){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        List<Integer>ans=new ArrayList<>();
        cnt1=0;
        cnt2=0;
        for(int i:nums){
            if(i==e1) cnt1++;
            if(i==e2) cnt2++;
        }
        int n=nums.length;
        int mini=(int)(n/3);
        if(cnt1>mini) ans.add(e1);
        if(cnt2>mini) ans.add(e2);
        return ans;

      
    }
}