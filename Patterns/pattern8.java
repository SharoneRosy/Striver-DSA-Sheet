package Patterns;

public class pattern8{
    public static void nNumberTriangle(int n) {
        // Write your code here
        int c=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(c+" ");
                c+=1;
            }System.out.println();
        }
    }

}
