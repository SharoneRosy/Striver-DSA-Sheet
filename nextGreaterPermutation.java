package MediumArrays;
import java.util.*;
public class nextGreaterPermutation {

    public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        // Write your code here.
        
        int ind=-1;
        int n=A.size();
        for(int i=n-2;i>=0;i--){
            if(A.get(i)<A.get(i+1)){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            Collections.reverse(A);
            return A;
        }
        for(int i=n-1;i>ind;i--){
            if(A.get(i)>A.get(ind)){
            int temp=A.get(ind);
            A.set(ind, A.get(i));
            A.set(i, temp);
            break;
            }
        }
        List<Integer> subList=A.subList(ind+1, n);
        Collections.reverse(subList);
        return A;
        
    }
}

