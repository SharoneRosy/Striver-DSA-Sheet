class Solution {
    int cnt=0;
    public int reversePairs(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return cnt;
    }
    public void mergesort(int nums[],int left, int right){
        if(left>=right) return ;
        int mid=(left+right)/2;
        mergesort(nums,left,mid);
        mergesort(nums,mid+1,right);
        countPairs(nums,left,mid,right);
        merge(nums,left,mid,right);
    }
    public void merge(int nums[],int low,int mid,int high){
        int i=low;
        int j=mid+1;
        List<Integer>temp=new ArrayList<>();
        while(i<=mid && j<=high){
            if(nums[i]<=nums[j]){
                temp.add(nums[i]);
                i++;
            }else{
                temp.add(nums[j]);
                j++;
            }
        }
        while(i<=mid){
            temp.add(nums[i]);
            i++;
        }
        while(j<=high){
            temp.add(nums[j]);
            j++;
        }
        for(int i1=low;i1<=high;i1++){
            nums[i1]=temp.get(i1-low);
        }
    }
    public void countPairs(int [] nums,int low,int mid,int high){
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)nums[i]>2*(long)nums[right]){
                right++;
            }
            cnt+=(right-(mid+1));
        }
    }
}