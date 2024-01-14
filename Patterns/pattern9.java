package Patterns;

public class pattern9 {
    public static void nLetterTriangle(int n) {
        // Write your code here
        for(int i=1;i<=n;i++){
            for(char ch='A';ch<'A'+i;ch++){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}
