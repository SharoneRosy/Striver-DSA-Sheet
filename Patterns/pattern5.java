public class pattern5
 {
    public static void nStarTriangle(int n) {
        // Write your code here
        int i,j;
        for( i=1;i<=2*n-1;i++){
            int stars=i;
            if(i>n) stars=2*n-i;
            for(j=1;j<=stars;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}