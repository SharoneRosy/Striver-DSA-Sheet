package BasicArrays;

public class rotate {
    public static int[] moveZeros(int n, int []a) {
        // Write your code here.
        int c=0;
        for(int i=0;i<n;i++){
            if(a[i]!=0){
                int temp=a[c];
                a[c]=a[i];
                a[i]=temp;
                c++;
            }
        }return a;
    }
}
