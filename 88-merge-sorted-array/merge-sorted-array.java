
class Solution{
    public void merge(int [] nums1,int m,int [] nums2,int n){
        int i=m-1;
        int j=n-1;
        int l=nums1.length-1;
        while(i>=0 || j>=0){
            if(i<0){
                nums1[l--]=nums2[j--];
            }else if(j<0){
                nums1[l--]=nums1[i--];
            }else if(nums1[i]>=nums2[j]){
                nums1[l--]=nums1[i--];
            }else{
                nums1[l--]=nums2[j--];
            }
        }
    }
}