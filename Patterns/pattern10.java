package Patterns;

public class pattern10{
    public static void nLetterTriangle(int n) {
        // Write your code here,
        for(int i=1;i<=n;i++){
            for(char ch='A';ch<='A'+(n-i);ch++){
                System.out.print(ch+" ");
            }System.out.println();
        }
    }
}
