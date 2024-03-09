class Solution {
public List<Integer> majorityElement(int[] nums) {
    int e1=-1;
    int e2=-3;
    int c1=0;
    int c2=0;
    int n=nums.length;
    for(int i=0;i<n;i++){
        if(c1==0 && nums[i]!=e2){
            c1=1;
            e1=nums[i];
        }
        else if(c2==0 && nums[i]!=e1){
            c2=1;
            e2=nums[i];
        }
        else if(nums[i]==e1){
            c1++;
        }else if(nums[i]==e2){
            c2++;
        }else{
            c1--;
            c2--;
        }
    }
    c1=0;
    c2=0;
    for(int i=0;i<n;i++){
        if(nums[i]==e1) c1++;
        if(nums[i]==e2) c2++;
    }
    int min=(int)n/3;
    ArrayList<Integer> ans=new ArrayList();
    if(c1>min) ans.add(e1);
    if(c2>min) ans.add(e2);
    return ans;

}
}