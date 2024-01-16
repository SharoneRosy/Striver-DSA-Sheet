package Basic  Recursion;

public class oneToN {
    

        static void print(int a[] , int n){
            if(n==0){
                return;
            }
            print(a,n-1);
            a[n-1]=n;
        }
        public static int[] printNos(int x) {
            // Write Your Code Here
            int a[]=new int[x];
            print(a,x);
            return a;
        }
        
    
    
}
