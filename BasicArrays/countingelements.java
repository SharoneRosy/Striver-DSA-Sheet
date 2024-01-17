

public class countingelements {
    public static int[] countFrequency(int n, int x, int []nums){
        // Write your code here.
                // Write your code here.
        int l[]=new int[n];
        for(int i=0;i<n;i++){
            l[i]=0;
        }
        for(int i=0;i<n;i++){
            if(nums[i]-1<n){
              l[nums[i]-1]++;
              }

            
        }
        return l;
    }
}
