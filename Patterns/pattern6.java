package Patterns;

public class pattern6 {
    
        public static void nBinaryTriangle(int n) {
            // Write your code here.
            int start=1;
            int i,j;
            for( i=0;i<n;i++){
                if(i%2==0) start=1;
                else start=0;
                for(j=0;j<=i;j++){
                    System.out.print(start+" ");
                    start=1-start;
                }
                System.out.println();
            }
        
    }
}
