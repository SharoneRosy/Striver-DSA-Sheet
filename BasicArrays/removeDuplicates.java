package BasicArrays;

public class removeDuplicates {
    public static int removeDuplicates(int[] arr,int n) {
        // Write your code here.
        int res=1;
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[res-1]){
                arr[res]=arr[i];
                res++;
            }
        }return res;
    }
    
}
