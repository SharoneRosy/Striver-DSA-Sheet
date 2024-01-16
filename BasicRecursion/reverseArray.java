package BasicRecursion;

public class reverseArray {
    
        public static void print(int []nums,int s,int n){
            if(s>=n){
                return;
            }
            int temp=nums[s];
            nums[s]=nums[n-1];
            nums[n-1]=temp;
            print(nums,s+1,n-1);
        }
        public static int[] reverseArray(int n, int []nums) {
            // Write your code here.
            print(nums,0,n);
            return nums;
    
        }
    
    
}
