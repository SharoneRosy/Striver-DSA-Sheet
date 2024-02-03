package MediumArrays;

public class twosum {
    public static String read(int n, int []book, int target){
        // Write your code here.
        HashMap<Integer,Integer>map=new HashMap<>();
        int more_needed;
        for(int i=0;i<n;i++){
            int num=book[i];
            more_needed=target-num;
            if(map.containsKey(more_needed)){
                return "YES";
            }
            map.put(num, i);
        }return  "NO";
    }
}
