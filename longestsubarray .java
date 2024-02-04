package MediumArrays;
import java.util.HashSet;
public class longestsubarray{
    

    public static int longestSuccessiveElements(int []a) {
        // Write your code here.
        int n=a.length;
        if(n==0) return 0;
        
        int max=1;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(a[i]);
        }
        for(int it:set){
            if(!set.contains(it -1)){
                int count=1;
                int x=it;
                while(set.contains(x+1)){
                   x=x+1;
                   count++;
                }
                 
                 max= Math.max(max, count);
            }
        }return max;

    }
}

