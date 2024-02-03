package MediumArrays;
import java.io.*;
import java.util.*;
public class ZeroMatrix {
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
    	// Write your code here.
        int[] r =new int[n];
        int[] c =new int [m];
        Arrays.fill(r, 0);
        Arrays.fill(c, 0);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix.get(i).get(j)==0){
                    r[i]=1;
                    c[j]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(r[i]==1 || c[j]==1){
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }
}
    
}
