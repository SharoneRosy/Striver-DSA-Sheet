package BasicRecursion;
import java.util.Arrays;
public class fibonacciNumbers {
  


    public static int print(int a[], int n){
        if(n==0 || n==1) return n;

        if(a[n]!=-1){
             return a[n];
        }

        return a[n]=print(a,n-1)+print(a,n-2);
    }
    public static int[] generateFibonacciNumbers(int n) {
        // Write your code here.
        
        int a[]=new int[n];
        Arrays.fill(a, -1);
        a[0]=0;
        if(n<=1) return a;
        a[1]=1;
        print(a,n-1);
        return a;
    }

    
}
