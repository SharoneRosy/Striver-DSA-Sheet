package BasicRecursion;
import java.util.ArrayList;
import java.util.List;


public class factorial {
    
    public static void print(List<Long> a, long n,long i,long count){
        if(count*i>n) return;
        a.add(count*i);
        print(a,n,count*i,count+1);
    }
    public static List<Long> factorialNumbers(long n) {
        // Write Your Code Here
        List<Long> a=new ArrayList<>();
        print(a,n,1,1);
        return a;
    }
}
    

