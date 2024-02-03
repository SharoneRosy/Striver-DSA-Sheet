package MediumArrays;
import java.util.*;
public class SpiralMatrix {
   


    public static int[] spiralMatrix(int [][]MATRIX) {
        // Write your code here.
        
        int n=MATRIX.length;
        int m=MATRIX[0].length;
        int ans[]=new int[m*n];
        int top=0,left=0,bottom=n-1,right=m-1,z=0;
        while (top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                ans[z++]=MATRIX[top][i];
            }top++;
            for(int i=top;i<=bottom;i++){
                ans[z++]=MATRIX[i][right];
            }right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans[z++]=MATRIX[bottom][i];
                }bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans[z++]=MATRIX[i][left];
                }left++;
            }

        }return ans;
    }
}
    
}
