package Patterns;

public class pattern7 {
    
        public static void numberCrown(int n) {
            // Write your code here.
            int space=2*(n-1);
            int i,j;
            for( i=1;i<=n;i++){
                for(j=1;j<=i;j++){
                    System.out.print(j+" ");
                }
                for(j=1;j<=space;j++){
                    System.out.print(" ");
                }
                for(j=i;j>=1;j--){
                    System.out.print(j+" ");
                }
                System.out.println();
                space-=2;
            }
        }
    
}
