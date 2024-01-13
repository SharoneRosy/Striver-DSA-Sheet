import java.util.Scanner;

public class Solution {


	public static void main(String[] args) {
		
		/* Your class should be named Solution.
	 	* Read input as specified in the question.
	 	* Print output as specified in the question.
		*/
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			if(n==1 || n==2){
				System.out.println(1);
			}
			int a=1;
			int b=1;
			int temp=0;
			for(int i=3;i<=n;i++){
				temp=a+b;
				a=b;
				b=temp;
				if(i==n)
				System.out.println(temp);
			}
		
	}

}
