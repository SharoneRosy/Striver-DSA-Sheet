package Patterns;

public class pattern2 {
    public static void  Pattern(int n){
        int i, j;
        for( i=0;i<n ;i++){
            for ( j=0;j<i;j++){
                System.out.print(" ");
            }
            for( j=0;j<2*n-(2*i+1);j++){
                System.out.print("*");
            }
            for( j=0;j<i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int n=6;
        Pattern(n);
    }
}
