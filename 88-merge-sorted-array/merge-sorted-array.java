class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p=m-1;
        int q=n-1;
        int l=m+n-1;
        int curr=0;
        while(p>=0 || q>=0){
            if(p<0) {
                curr=nums2[q--];
            }else if(q<0){
                curr=nums1[p--];
            }else if(nums1[p]<nums2[q]){
                curr=nums2[q--];
            }else{
                curr=nums1[p--];
            }
            nums1[l--]=curr;
        }
    }
}